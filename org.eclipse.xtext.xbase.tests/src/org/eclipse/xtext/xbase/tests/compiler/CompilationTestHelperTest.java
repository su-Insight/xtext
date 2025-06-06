/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.GeneratorConfigProvider;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper.Result;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class CompilationTestHelperTest extends AbstractJvmModelTest {
	@Rule
	@Inject
	public TemporaryFolder temporaryFolder;

	@Inject
	private CompilationTestHelper compilationTestHelper;

	@Inject
	private GeneratorConfigProvider generatorConfigProvider;

	@Inject
	private FileExtensionProvider extensionProvider;

	@Test
	public void testSwitchJavaVersion6() throws Exception {
		compilationTestHelper.setJavaVersion(JavaVersion.JAVA6);
		String source =
				"{\n" +
				"	val s = \"\"\n" +
				"	switch (s) {\n" +
				"		case \"foo\": \"foo\"\n" +
				"		default: \"bar\"\n" +
				"	}\n" +
				"}\n";
		compilationTestHelper.compile(source, (CompilationTestHelper.Result it) -> {
			String expectation =
					"import java.util.Objects;\n" +
					"\n" +
					"@SuppressWarnings(\"all\")\n" +
					"public class Test {\n" +
					"  public String doStuff(final String s) {\n" +
					"    String _xblockexpression = null;\n" +
					"    {\n" +
					"      final String s_1 = \"\";\n" +
					"      String _switchResult = null;\n" +
					"      boolean _matched = false;\n" +
					"      if (Objects.equals(s_1, \"foo\")) {\n" +
					"        _matched=true;\n" +
					"        _switchResult = \"foo\";\n" +
					"      }\n" +
					"      if (!_matched) {\n" +
					"        _switchResult = \"bar\";\n" +
					"      }\n" +
					"      _xblockexpression = _switchResult;\n" +
					"    }\n" +
					"    return _xblockexpression;\n" +
					"  }\n" +
					"}\n";
			Assert.assertEquals(expectation, Strings.toUnixLineSeparator(it.getSingleGeneratedCode()));
			it.getCompiledClass();
		});
	}

	@Test
	public void testSwitchJavaVersion7() throws Exception {
		compilationTestHelper.setJavaVersion(JavaVersion.JAVA7);
		String source =
				"{\n" +
				"	val s = \"\"\n" +
				"	switch (s) {\n" +
				"		case \"foo\": \"foo\"\n" +
				"		default: \"bar\"\n" +
				"	}\n" +
				"}\n";
		compilationTestHelper.compile(source, (CompilationTestHelper.Result it) -> {
			String expectation =
					"@SuppressWarnings(\"all\")\n" +
					"public class Test {\n" +
					"  public String doStuff(final String s) {\n" +
					"    String _xblockexpression = null;\n" +
					"    {\n" +
					"      final String s_1 = \"\";\n" +
					"      String _switchResult = null;\n" +
					"      if (s_1 != null) {\n" +
					"        switch (s_1) {\n" +
					"          case \"foo\":\n" +
					"            _switchResult = \"foo\";\n" +
					"            break;\n" +
					"          default:\n" +
					"            _switchResult = \"bar\";\n" +
					"            break;\n" +
					"        }\n" +
					"      } else {\n" +
					"        _switchResult = \"bar\";\n" +
					"      }\n" +
					"      _xblockexpression = _switchResult;\n" +
					"    }\n" +
					"    return _xblockexpression;\n" +
					"  }\n" +
					"}\n";
			Assert.assertEquals(expectation, Strings.toUnixLineSeparator(it.getSingleGeneratedCode()));
			it.getCompiledClass();
		});
	}

	@Test
	public void testLambdaJavaVersion6() throws Exception {
		compilationTestHelper.setJavaVersion(JavaVersion.JAVA6);
		String source =
				"{\n" +
				"	val f = [ int i | i + 1 ]\n" +
				"}\n";
		compilationTestHelper.compile(source, (CompilationTestHelper.Result it) -> {
			String expectation =
					"import org.eclipse.xtext.xbase.lib.Functions.Function1;\n" +
					"\n" +
					"@SuppressWarnings(\"all\")\n" +
					"public class Test {\n" +
					"  public String doStuff(final String s) {\n" +
					"    final Function1<Integer, Integer> _function = new Function1<Integer, Integer>() {\n" +
					"      @Override\n" +
					"      public Integer apply(final Integer i) {\n" +
					"        return Integer.valueOf((i + 1));\n" +
					"      }\n" +
					"    };\n" +
					"    final Function1<Integer, Integer> f = _function;\n" +
					"    return null;\n" +
					"  }\n" +
					"}\n";
			Assert.assertEquals(expectation, Strings.toUnixLineSeparator(it.getSingleGeneratedCode()));
			it.getCompiledClass();
		});
	}

	@Test
	public void testLambdaJavaVersion8() throws Exception {
		compilationTestHelper.setJavaVersion(JavaVersion.JAVA8);
		String source =
				"{\n" +
				"	val f = [ int i | i + 1 ]\n" +
				"}\n";
		compilationTestHelper.compile(source, (CompilationTestHelper.Result it) -> {
			String expectation =
					"import org.eclipse.xtext.xbase.lib.Functions.Function1;\n" +
					"\n" +
					"@SuppressWarnings(\"all\")\n" +
					"public class Test {\n" +
					"  public String doStuff(final String s) {\n" +
					"    final Function1<Integer, Integer> _function = (Integer i) -> {\n" +
					"      return Integer.valueOf((i + 1));\n" +
					"    };\n" +
					"    final Function1<Integer, Integer> f = _function;\n" +
					"    return null;\n" +
					"  }\n" +
					"}\n";
			Assert.assertEquals(expectation, Strings.toUnixLineSeparator(it.getSingleGeneratedCode()));
			it.getCompiledClass();
		});
	}

	@Test
	public void testCustomConfigIsNotLost() throws Exception {
		compilationTestHelper.setJavaVersion(JavaVersion.JAVA8);
		String model =
				"{\n" +
				"	val f = [ int i | i + 1 ]\n" +
				"}\n";
		@SuppressWarnings("unchecked")
		ResourceSet resourceSet = compilationTestHelper
				.resourceSet(Pair.of("MyFile." + extensionProvider.getPrimaryFileExtension(), model));
		GeneratorConfig generatorConfig = new GeneratorConfig();
		generatorConfig.setGenerateSyntheticSuppressWarnings(false);
		generatorConfigProvider.install(resourceSet, generatorConfig);
		compilationTestHelper.compile(resourceSet, (Result it) -> {
			String expectation =
					"import org.eclipse.xtext.xbase.lib.Functions.Function1;\n" +
					"\n" +
					"public class Test {\n" +
					"  public String doStuff(final String s) {\n" +
					"    final Function1<Integer, Integer> _function = (Integer i) -> {\n" +
					"      return Integer.valueOf((i + 1));\n" +
					"    };\n" +
					"    final Function1<Integer, Integer> f = _function;\n" +
					"    return null;\n" +
					"  }\n" +
					"}\n";
			Assert.assertEquals(expectation, Strings.toUnixLineSeparator(it.getSingleGeneratedCode()));
		});
	}
}
