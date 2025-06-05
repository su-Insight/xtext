/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug347012TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug347012TestLanguageGrammarAccess;

public class Bug347012TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug347012TestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, Bug347012TestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getVirtualSemiAccess().getAlternatives(), "rule__VirtualSemi__Alternatives");
			mappings.put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
			mappings.put(grammarAccess.getMyPrimaryAccess().getAlternatives(), "rule__MyPrimary__Alternatives");
			mappings.put(grammarAccess.getMyAttributeAccess().getAlternatives(), "rule__MyAttribute__Alternatives");
			mappings.put(grammarAccess.getMyProgramAccess().getGroup(), "rule__MyProgram__Group__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			mappings.put(grammarAccess.getMyPackageAccess().getGroup(), "rule__MyPackage__Group__0");
			mappings.put(grammarAccess.getMyPackageAccess().getGroup_6(), "rule__MyPackage__Group_6__0");
			mappings.put(grammarAccess.getMyClassAccess().getGroup(), "rule__MyClass__Group__0");
			mappings.put(grammarAccess.getMyClassAccess().getGroup_7(), "rule__MyClass__Group_7__0");
			mappings.put(grammarAccess.getMyAttributesAccess().getGroup(), "rule__MyAttributes__Group__0");
			mappings.put(grammarAccess.getMyFieldAccess().getGroup(), "rule__MyField__Group__0");
			mappings.put(grammarAccess.getMyFieldAccess().getGroup_4(), "rule__MyField__Group_4__0");
			mappings.put(grammarAccess.getMyBindingAccess().getGroup(), "rule__MyBinding__Group__0");
			mappings.put(grammarAccess.getMyBindingAccess().getGroup_1(), "rule__MyBinding__Group_1__0");
			mappings.put(grammarAccess.getMyBindingAccess().getGroup_2(), "rule__MyBinding__Group_2__0");
			mappings.put(grammarAccess.getMyProgramAccess().getPackageAssignment_2(), "rule__MyProgram__PackageAssignment_2");
			mappings.put(grammarAccess.getIdentifierAccess().getNameAssignment(), "rule__Identifier__NameAssignment");
			mappings.put(grammarAccess.getLiteralAccess().getNumAssignment_0(), "rule__Literal__NumAssignment_0");
			mappings.put(grammarAccess.getLiteralAccess().getStrAssignment_1(), "rule__Literal__StrAssignment_1");
			mappings.put(grammarAccess.getLiteralAccess().getBoolAssignment_2(), "rule__Literal__BoolAssignment_2");
			mappings.put(grammarAccess.getLiteralAccess().getBoolAssignment_3(), "rule__Literal__BoolAssignment_3");
			mappings.put(grammarAccess.getMyPackageAccess().getNameAssignment_2(), "rule__MyPackage__NameAssignment_2");
			mappings.put(grammarAccess.getMyPackageAccess().getDirectivesAssignment_6_0(), "rule__MyPackage__DirectivesAssignment_6_0");
			mappings.put(grammarAccess.getMyClassAccess().getNameAssignment_3(), "rule__MyClass__NameAssignment_3");
			mappings.put(grammarAccess.getMyClassAccess().getDirectivesAssignment_7_0(), "rule__MyClass__DirectivesAssignment_7_0");
			mappings.put(grammarAccess.getMyAttributeAccess().getPUBLICAssignment_0(), "rule__MyAttribute__PUBLICAssignment_0");
			mappings.put(grammarAccess.getMyAttributeAccess().getPRIVATEAssignment_1(), "rule__MyAttribute__PRIVATEAssignment_1");
			mappings.put(grammarAccess.getMyAttributesAccess().getAttributesAssignment_1(), "rule__MyAttributes__AttributesAssignment_1");
			mappings.put(grammarAccess.getMyFieldAccess().getAttrAssignment_0(), "rule__MyField__AttrAssignment_0");
			mappings.put(grammarAccess.getMyFieldAccess().getBindingsAssignment_3(), "rule__MyField__BindingsAssignment_3");
			mappings.put(grammarAccess.getMyFieldAccess().getBindingsAssignment_4_3(), "rule__MyField__BindingsAssignment_4_3");
			mappings.put(grammarAccess.getMyBindingAccess().getNameAssignment_0(), "rule__MyBinding__NameAssignment_0");
			mappings.put(grammarAccess.getMyBindingAccess().getTypeAssignment_1_3(), "rule__MyBinding__TypeAssignment_1_3");
			mappings.put(grammarAccess.getMyBindingAccess().getExpressionAssignment_2_3(), "rule__MyBinding__ExpressionAssignment_2_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug347012TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug347012TestLanguageParser createParser() {
		InternalBug347012TestLanguageParser result = new InternalBug347012TestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS" };
	}

	public Bug347012TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug347012TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
