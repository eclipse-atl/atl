# AGENTS.md

## Project: org.eclipse.atl

### Standard Instructions

#### Build and Test

This project uses the Eclipse Tycho plug-in for Maven. Dependency reolution is done via P2 instead of standard Maven dependencies.

- **Build:** `mvn -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml clean verify`
  - Cleans the target directory, compiles the code, runs tests, and packages the application.

- **Parallel Build:** `mvn -T $(nproc) -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml clean verify`
  - Cleans the target directory, compiles the code, runs tests, and packages the application with $(nproc) parallel threads.

- **Run Tests:** `mvn -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml test`
  - Executes all unit tests in the project.

- **Skip tests:**
```bash
mvn -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml clean verify -DskipTests
```

- **Specific target platform** (default is `2025-12`):
```bash
mvn -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml clean verify -Dtarget-platform=2026-06
```

- **Run a single test class** (Tycho surefire, must be an Eclipse fragment test):
```bash
mvn -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml verify \
  -pl ../../tests/org.eclipse.m2m.atl.emftvm.tests \
  -Dtest=StackFrameTest
```

- Java 21 is required for target platforms 2025-03 and later; Java 17 for 2024-12 and earlier.
- Test results are written to `**/target/surefire-reports/TEST-*.xml`.

## Architecture

### Plugin layout

| Directory | Contents |
|-----------|----------|
| `plugins/` | All Eclipse OSGi bundles (production code) |
| `tests/` | Test bundles (`eclipse-test-plugin` packaging) |
| `releng/` | Parent POM, target platform definitions (`tp/*.target`), update site |
| `dsls/` | ATL and ACG language definitions (Syntax, Metamodel, Compiler, RuntimeSupport) |
| `doc/` | Cheatsheets and documentation bundles |
| `examples/` | Example ATL transformations |

### Three virtual machines

ATL ships three execution engines:

1. **RegularVM** (`org.eclipse.m2m.atl.engine.vm`) — the legacy "Regular VM". ATL source files (`.atl`) are compiled into XML-based ASM bytecode.
2. **EMFVM** (`org.eclipse.m2m.atl.engine.emfvm`) — the default EMF-specific VM. ATL source files (`.atl`) are compiled into XML-based ASM bytecode.
3. **EMFTVM** (`org.eclipse.m2m.atl.emftvm`) — the modern "EMF Transformation Virtual Machine". ATL source is compiled to a bytecode format (`.emftvm` files) and can optionally be JIT-compiled (`jit/` package). This is the preferred engine for new work.

### Core abstraction (org.eclipse.m2m.atl.core)

The `core` plugin defines the portable API shared by both engines:

- `IModel` / `IReferenceModel` — model and metamodel handles
- `ModelFactory` — creates model instances
- `IInjector` / `IExtractor` — load/save models from/to resources
- `ILauncher` — executes an ATL transformation
- `CoreService` / `LauncherService` — registries that look up implementations via Eclipse extension points (`org.eclipse.m2m.atl.core.launcher`, `.injector`, `.extractor`, `.model`)

When running outside Eclipse (standalone), implementations must be registered explicitly via `CoreService.register*()` before use (see `TestEMFVMStandalone` for an example).

### EMF-generated model code

Several plugins contain EMF models (`.ecore` + `.genmodel`):

- `org.eclipse.m2m.atl.emftvm` — EMFTVM instruction set model (`emftvm.ecore`)
- `org.eclipse.m2m.atl.emftvm.trace` — Trace model
- `org.eclipse.m2m.atl.common` — ATL AST model and Problem model
- `org.eclipse.m2m.atl.profiler.exportmodel` — Profiler export model

Classes in `impl/` packages (e.g., `org.eclipse.m2m.atl.emftvm.impl`) are **EMF-generated** — regenerate from the `.genmodel` rather than editing by hand.

## Key Conventions

- **OSGi bundle identity** — Each plugin directory name equals its bundle symbolic name (e.g., `plugins/org.eclipse.m2m.atl.emftvm`). The Maven `<artifactId>` matches this name; Tycho derives bundle metadata from `META-INF/MANIFEST.MF` and `plugin.xml`, not from `pom.xml`.

- **`eclipse-plugin` / `eclipse-test-plugin` packaging** — All production plugins use `<packaging>eclipse-plugin</packaging>`; test bundles use `eclipse-test-plugin`. These are Tycho-specific packaging types, not standard Maven JARs.

- **Extension points over service locators** — New implementations of launchers, injectors, extractors, and model factories must declare themselves via `plugin.xml` extension points under `org.eclipse.m2m.atl.core.*`. For standalone/unit-test scenarios use `CoreService.register*()`.

- **`.atl` → `.emftvm` compilation** — ATL source files in `plugins/org.eclipse.m2m.atl.emftvm/transformations/` are compiled to `.emftvm` binaries that are checked in alongside them. When changing an `.atl` file in that directory, recompile to update the corresponding `.emftvm` file.

- **License header** — Every `.java` file must include an EPL-2.0 copyright header with the author's name and affiliation, matching the style used throughout the codebase.

- **Bug/issue tracker** — GitHub Issues at `https://github.com/eclipse-atl/atl/issues`. Older bugs live in Eclipse Bugzilla (read-only); reference the Bugzilla ID in a new GitHub issue when continuing that work.

#### Debugging

- **Debug with Eclipse IDE:**
  - Import the project into Eclipse as a Maven project.
  - Set breakpoints in your source files.
  - Run the project in debug mode using the Eclipse debugger.

- **Generate Javadocs:** `mvn javadoc:javadoc`
  - Generates Java documentation for the project.

#### Additional Tools

- **Formatting Code:** Use [Eclipse Formatter](https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Ftasks%2Ftask-code_style.htm) or Maven plugins like `maven-formatter-plugin` to maintain consistent code formatting.
  
- **Dependency Management:**
  - Update dependencies with `mvn versions:display-dependency-updates`
  - Upgrade dependencies with `mvn versions:use-latest-releases`

#### Troubleshooting

- **Build Failures:** Check the Maven output for error messages. Use `-X` flag (`mvn clean install -X`) to get debug information.
  
- **Test Failures:** Review test logs in `target/surefire-reports/`. Identify failing tests and fix them accordingly.

#### Committing Changes

- **Commit Messages:**
  - Follow the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) style.
  - Example: `fix(core): resolve memory leak issue in ModuleX`

- **Pre-commit Hooks:** Ensure pre-commit hooks are set up for code validation before commit.

#### Documentation

- **Update README.md:** Include any new features, breaking changes, or important notes.
  
- **API Changes:** Document any API changes in the relevant modules.