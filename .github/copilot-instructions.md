# Eclipse ATL — Copilot Instructions

Eclipse ATL (ATL Transformation Language) is a Model-Driven Engineering toolkit for producing target models from source models. It is structured as a multi-bundle Eclipse plugin project built with Maven/Tycho.

## Build & Test

**Full build (compile + test):**
```bash
mvn -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml clean verify
```

**Full parallel build (compile + test):**
```bash
mvn -T $(nproc) -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml clean verify
```

**Skip tests:**
```bash
mvn -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml clean verify -DskipTests
```

**Specific target platform** (default is `2025-12`):
```bash
mvn -f releng/org.eclipse.m2m.atl.releng.parent/pom.xml clean verify -Dtarget-platform=2026-06
```

**Run a single test class** (Tycho surefire, must be an Eclipse fragment test):
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

### Two virtual machines

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
