/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.typesystem;

import java.util.Collection;
import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Ignore;
import org.junit.Test;
import testdata.stubs.StubbedList;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class SuperTypesTest extends AbstractSuperTypesTest {
  @Override
  public Iterable<LightweightTypeReference> collectSuperTypes(final LightweightTypeReference reference) {
    return reference.getSuperTypes();
  }

  @Test
  @Override
  public void testString() {
    boolean _isJava12OrLater = JavaRuntimeVersion.isJava12OrLater();
    if (_isJava12OrLater) {
      this.assertSuperTypes(String.class, "Serializable", "Comparable<String>", "CharSequence", "Constable", "ConstantDesc");
    } else {
      this.assertSuperTypes(String.class, "Serializable", "Comparable<String>", "CharSequence");
    }
  }

  @Test
  @Override
  public void testRawCollection() {
    this.assertSuperTypes(Collection.class, "Iterable");
  }

  @Test
  @Override
  public void testStringCollection() {
    this.assertSuperTypes("java.util.Collection<String>", "Iterable<String>");
  }

  @Test
  @Override
  public void testStringArray() {
    boolean _isJava12OrLater = JavaRuntimeVersion.isJava12OrLater();
    if (_isJava12OrLater) {
      this.assertSuperTypes("String[]", "Serializable[]", "Comparable<String>[]", "CharSequence[]", "Constable[]", "ConstantDesc[]");
    } else {
      this.assertSuperTypes("String[]", "Serializable[]", "Comparable<String>[]", "CharSequence[]");
    }
  }

  @Test
  @Override
  public void testObjectArray() {
    this.assertSuperTypes("Object[]", "Cloneable", "Serializable");
  }

  @Test
  @Override
  public void testPrimitiveArray() {
    this.assertSuperTypes("int[]", "Cloneable", "Serializable");
  }

  @Test
  @Override
  public void testRawList() {
    this.assertSuperTypes(StubbedList.class, "Collection");
  }

  @Test
  @Override
  public void testStringList() {
    this.assertSuperTypes("testdata.stubs.StubbedList<String>", "Collection<String>");
  }

  @Test
  @Override
  public void testStringArrayArrayList() {
    this.assertSuperTypes("java.util.ArrayList<? extends String[]>", 
      "AbstractList<? extends String[]>", 
      "List<? extends String[]>", 
      "RandomAccess", 
      "Cloneable", 
      "Serializable");
  }

  @Test
  @Override
  public void testTypeParameters() {
    this.assertSuperTypes(Pair.<String, String>of("T", "T extends CharSequence"), "CharSequence");
  }

  @Test
  @Override
  public void testTypeParameterArray() {
    this.assertSuperTypes(Pair.<String, String>of("T", "T extends CharSequence[]"), "CharSequence[]");
  }

  @Test
  @Override
  public void testDependentTypeParameters() {
    this.assertSuperTypes(Pair.<String, String>of("T", "V, T extends V"), "V");
  }

  @Test
  @Override
  public void testDependentTypeParametersWithBounds() {
    this.assertSuperTypes(Pair.<String, String>of("T", "V extends CharSequence, T extends V"), "V");
  }

  @Test
  @Override
  public void testParameterizedInnerTypes_01() {
    this.assertSuperTypes("test.InnerClasses.SubString<Number>.SubInner<CharSequence>", "Super<String>$Inner<CharSequence>");
  }

  @Test
  @Override
  public void testParameterizedInnerTypes_02() {
    this.assertSuperTypes("test.InnerClasses.Sub<Number>.SubInner2<CharSequence>", "Super<Number>$Inner<Number>");
  }

  @Test
  @Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=442013")
  @Override
  public void testParameterizedInnerTypes_03() {
    this.assertSuperTypes("test.InnerClasses.Sub3.Inner2<Number>", "Super3<String>$Inner<Number>");
  }

  @Test
  @Override
  public void testParameterizedInnerTypes_04() {
    this.assertSuperTypes("test.InnerClasses.Sub4<Number>.Inner3<CharSequence>", "Super3<String>$Inner2<Number>");
  }
}
