/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - Initial Implementation
 *******************************************************************************/
package org.eclipse.m2m.atl.tests.unit;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.m2m.atl.adt.ui.text.atl.AtlCodeScanner;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * The JUnit tests for {@link AtlCodeScanner}.
 * 
 * Each <a href="../../../../../../../data/inputs/AtlCodeScanner">input file</a>
 * is scanned to produce the corresponding token keys. Then we check whether
 * they match the
 * <a href="../../../../../../../data/expected/AtlCodeScanner">expected
 * ones</a>.
 */
@RunWith(Parameterized.class)
public class AtlCodeScannerTestCase {

	private static final Path relativePathToDirectoryWithInputs = Paths.get("data", "inputs", "AtlCodeScanner");
	private static final Path relativePathToDirectoryWithExpectedOutputs = Paths.get("data", "expected",
			"AtlCodeScanner");
	private static final String expectedTokensSuffix = ".tokens";

	private final String inputFileName;

	private AtlCodeScanner scanner;

	@Parameters(name = "{0}")
	public static Iterable<String> inputFileNames() {
		return List.of("Brackets.txt", "Comments.txt", "Constants.txt", "Keywords.txt", "Literals.txt", "Operators.txt",
				"Symbols.txt", "Types.txt");
	}

	public AtlCodeScannerTestCase(final String inputFileName) {
		this.inputFileName = inputFileName;
	}

	@Before
	public void setUp() throws Exception {
		// The scanner is tweaked a bit so we do not need the whole colors and
		// everything, we just need the String that encodes the type of coloring that
		// will be applied at runtime.
		this.scanner = new AtlCodeScanner(null) {
			@Override
			protected String[] getPropertyNames() {
				return new String[0];
			}

			@Override
			protected Token getToken(String color) {
				return new Token(color);
			}
		};
	}

	private static Optional<Document> loadDocument(final Path relativePathToFile) {
		// When running the test as "JUnit Plug-In Test", this should find the file.
		InputStream input = AtlCodeScannerTestCase.class.getResourceAsStream("/" + relativePathToFile.toString()); //$NON-NLS-1$
		if (input == null) {
			// When running the test as a regular JUnit test, this should suffice.
			try {
				input = new FileInputStream(relativePathToFile.toString());
			} catch (FileNotFoundException fileNotFoundException) {
				return Optional.empty();
			}
		}

		try (final Scanner reader = new Scanner(input, Charset.defaultCharset().name())) {
			return Optional.of(new Document(reader.useDelimiter("\\A").next())); //$NON-NLS-1$
		}
	}

	private List<List<IToken>> scanDocumentLinesAsTokens(final Document document, final RuleBasedScanner scanner) {
		final List<List<IToken>> tokensByLine = new ArrayList<>();
		for (int line = 0; line < document.getNumberOfLines(); line++) {
			tokensByLine.add(new ArrayList<>());
		}

		IToken currentToken;
		do {
			currentToken = scanner.nextToken();
			int line;
			try {
				line = currentToken.isEOF() ? document.getNumberOfLines() - 1
						: document.getLineOfOffset(scanner.getTokenOffset());
			} catch (BadLocationException badLocationException) {
				throw new RuntimeException(badLocationException);
			}
			tokensByLine.get(line).add(currentToken);
		} while (!currentToken.isEOF());

		return tokensByLine;
	}

	private List<List<String>> getActualTokenKeys(final Path relativePathFromDirectoryToFile) {
		final Path relativePathToFile = relativePathToDirectoryWithInputs.resolve(relativePathFromDirectoryToFile);
		final Document document = loadDocument(relativePathToFile).orElseThrow(
				() -> new RuntimeException("Could not find file at location '%s'.".formatted(relativePathToFile)));
		scanner.setRange(document, 0, document.getLength());
		final List<List<IToken>> tokensByLine = scanDocumentLinesAsTokens(document, this.scanner);

		// Sanity checks about the tokens provided by the scanner.
		Assume.assumeTrue(tokensByLine.stream().flatMap(List::stream).noneMatch(IToken::isUndefined));
		Assume.assumeTrue(tokensByLine.stream().flatMap(List::stream).noneMatch(IToken::isWhitespace));
		Assume.assumeTrue(tokensByLine.stream().flatMap(List::stream).filter(IToken::isEOF).count() == 1);
		Assume.assumeTrue(tokensByLine.getLast().getLast().isEOF());

		return tokensByLine.stream().map(
				tokens -> tokens.stream().filter(IToken::isOther).map(IToken::getData).map(String.class::cast).toList())
				.toList();
	}

	private static Optional<List<List<String>>> getExpectedTokenKeys(final Path relativePathFromDirectoryToFile) {
		return loadDocument(relativePathToDirectoryWithExpectedOutputs.resolve(relativePathFromDirectoryToFile))
				.map(document -> document.get().lines().toList())
				.map(lines -> lines.stream().map(line -> Stream.of(line.split(" ")).toList()).toList());
	}

	@Test
	public void actualTokenKeysMatchExpectedTokenKeys() {
		final List<List<String>> actualTokensByLine = getActualTokenKeys(Paths.get(inputFileName));
		getExpectedTokenKeys(Paths.get(inputFileName + expectedTokensSuffix)).ifPresentOrElse(
				expectedTokensByLine -> compareTokenKeys(inputFileName, expectedTokensByLine, actualTokensByLine),
				() -> {
					// The corresponding expected tokens file does not exist, let's initialize it to
					// facilitate the addition of new test cases.
					final Path expectedFile = relativePathToDirectoryWithExpectedOutputs
							.resolve(inputFileName + expectedTokensSuffix);
					final List<String> lines = actualTokensByLine.stream()
							.map(tokens -> tokens.stream().collect(Collectors.joining(" "))).toList();
					try {
						Files.createDirectories(expectedFile.getParent());
						Files.write(expectedFile,
								// Write bytes directly instead of lines, otherwise we have an extra line separator at the end of the file.
								lines.stream().collect(Collectors.joining(System.lineSeparator())).getBytes(Charset.defaultCharset()),
								StandardOpenOption.CREATE_NEW);
					} catch (IOException ioException) {
						throw new UncheckedIOException(
								"Could not initialize expected tokens file at: '%s'.".formatted(expectedFile),
								ioException);
					}
					Assert.fail(
							"Expected tokens file was missing at '%s'.\nIt was initialized using the current scanner results (refresh the workspace if needed).\nValidate its contents are correct before committing it."
									.formatted(expectedFile.toString()));
				});
	}

	private void compareTokenKeys(final String inputFileName, final List<List<String>> expectedTokensByLine,
			final List<List<String>> actualTokensByLine) {
		final StringBuilder differences = new StringBuilder();

		for (int currentLineNumber = 0; currentLineNumber < Math.max(expectedTokensByLine.size(),
				actualTokensByLine.size()); currentLineNumber++) {
			if (currentLineNumber >= expectedTokensByLine.size() || currentLineNumber >= actualTokensByLine.size()) {
				differences.append("Line %d: expected <%s>, actual <%s>%n".formatted(currentLineNumber + 1,
						currentLineNumber < expectedTokensByLine.size() ? expectedTokensByLine.get(currentLineNumber)
								: "missing",
						currentLineNumber < actualTokensByLine.size() ? actualTokensByLine.get(currentLineNumber)
								: "missing"));
				continue;
			}

			final List<String> expectedTokens = expectedTokensByLine.get(currentLineNumber);
			final List<String> actualTokens = actualTokensByLine.get(currentLineNumber);
			for (int currentToken = 0; currentToken < Math.max(expectedTokens.size(),
					actualTokens.size()); currentToken++) {
				if (currentToken >= expectedTokens.size() || currentToken >= actualTokens.size()
						|| !expectedTokens.get(currentToken).equals(actualTokens.get(currentToken))) {
					differences.append("Line %d, token %d: expected <%s>, actual <%s>%n".formatted(
							currentLineNumber + 1, currentToken + 1,
							currentToken < expectedTokens.size() ? expectedTokens.get(currentToken) : "missing",
							currentToken < actualTokens.size() ? actualTokens.get(currentToken) : "missing"));
				}
			}
		}

		if (!differences.isEmpty()) {
			fail("Unexpected tokens found when scanning '%s' (%d expected lines, %d actual lines):%n%s"
					.formatted(inputFileName, expectedTokensByLine.size(), actualTokensByLine.size(), differences));
		}
	}

}
