/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBugInheritedDispatchTest extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class D extends C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(Integer o) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(CharSequence o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class C extends B {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(Number o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class B extends A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(String o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch void m(Object o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Generated;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class D extends C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _m(final Integer o) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected void _m(final CharSequence o) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Generated");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final Object o) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (o instanceof Integer) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((Integer)o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (o instanceof Number) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((Number)o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (o instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((String)o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (o instanceof CharSequence) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m((CharSequence)o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (o != null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_m(o);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Arrays.<Object>asList(o).toString());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void test_383430_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Parent<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch T test(Ausdruck a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch T test(Fallunterscheidung a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("test(a.dann)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Child extends Parent<String> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch String test(StringAusdruck a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"Hallo Welt\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Ausdruck {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Fallunterscheidung extends Ausdruck {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Ausdruck dann");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Ausdruck sonst");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class StringAusdruck extends Ausdruck {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Generated;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Parent<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected T _test(final Ausdruck a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected T _test(final Fallunterscheidung a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.test(a.getDann());");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Generated");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public T test(final Ausdruck a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (a instanceof Fallunterscheidung) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return _test((Fallunterscheidung)a);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (a != null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return _test(a);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Arrays.<Object>asList(a).toString());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void test_383430_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Child extends Parent<String> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch test(StringAusdruck a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Parent<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch T test(Ausdruck a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch T test(Fallunterscheidung a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("test(a.dann)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Ausdruck {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Fallunterscheidung extends Ausdruck {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Ausdruck dann");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Ausdruck sonst");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class StringAusdruck extends Ausdruck {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Generated;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Child extends Parent<String> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("protected String _test(final StringAusdruck a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Generated");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String test(final Ausdruck a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (a instanceof Fallunterscheidung) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return _test((Fallunterscheidung)a);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (a instanceof StringAusdruck) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return _test((StringAusdruck)a);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (a != null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return _test(a);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Arrays.<Object>asList(a).toString());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
