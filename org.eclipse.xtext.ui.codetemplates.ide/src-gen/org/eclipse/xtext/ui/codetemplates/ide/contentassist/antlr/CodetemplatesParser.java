/*******************************************************************************
 * Copyright (c) 2015, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.codetemplates.ide.contentassist.antlr.internal.InternalCodetemplatesParser;
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;

public class CodetemplatesParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(CodetemplatesGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, CodetemplatesGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getCodetemplateAccess().getAlternatives_7(), "rule__Codetemplate__Alternatives_7");
			mappings.put(grammarAccess.getTemplatePartAccess().getAlternatives(), "rule__TemplatePart__Alternatives");
			mappings.put(grammarAccess.getVariableOrDollarAccess().getAlternatives(), "rule__VariableOrDollar__Alternatives");
			mappings.put(grammarAccess.getVariableAccess().getAlternatives_2(), "rule__Variable__Alternatives_2");
			mappings.put(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_0_0(), "rule__Variable__ParametersAlternatives_2_1_4_3_0_0");
			mappings.put(grammarAccess.getVariableAccess().getParametersAlternatives_2_1_4_3_1_3_0(), "rule__Variable__ParametersAlternatives_2_1_4_3_1_3_0");
			mappings.put(grammarAccess.getValidIDAccess().getAlternatives(), "rule__ValidID__Alternatives");
			mappings.put(grammarAccess.getLiteralValueAccess().getAlternatives(), "rule__LiteralValue__Alternatives");
			mappings.put(grammarAccess.getDollarAccess().getAlternatives_1(), "rule__Dollar__Alternatives_1");
			mappings.put(grammarAccess.getCodetemplatesAccess().getGroup(), "rule__Codetemplates__Group__0");
			mappings.put(grammarAccess.getCodetemplateAccess().getGroup(), "rule__Codetemplate__Group__0");
			mappings.put(grammarAccess.getTemplateBodyWithQuotesAccess().getGroup(), "rule__TemplateBodyWithQuotes__Group__0");
			mappings.put(grammarAccess.getTemplateBodyAccess().getGroup(), "rule__TemplateBody__Group__0");
			mappings.put(grammarAccess.getTemplateBodyAccess().getGroup_2(), "rule__TemplateBody__Group_2__0");
			mappings.put(grammarAccess.getVariableAccess().getGroup(), "rule__Variable__Group__0");
			mappings.put(grammarAccess.getVariableAccess().getGroup_2_1(), "rule__Variable__Group_2_1__0");
			mappings.put(grammarAccess.getVariableAccess().getGroup_2_1_0(), "rule__Variable__Group_2_1_0__0");
			mappings.put(grammarAccess.getVariableAccess().getGroup_2_1_4(), "rule__Variable__Group_2_1_4__0");
			mappings.put(grammarAccess.getVariableAccess().getGroup_2_1_4_3(), "rule__Variable__Group_2_1_4_3__0");
			mappings.put(grammarAccess.getVariableAccess().getGroup_2_1_4_3_1(), "rule__Variable__Group_2_1_4_3_1__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			mappings.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			mappings.put(grammarAccess.getDollarAccess().getGroup(), "rule__Dollar__Group__0");
			mappings.put(grammarAccess.getCodetemplatesAccess().getLanguageAssignment_2(), "rule__Codetemplates__LanguageAssignment_2");
			mappings.put(grammarAccess.getCodetemplatesAccess().getTemplatesAssignment_4(), "rule__Codetemplates__TemplatesAssignment_4");
			mappings.put(grammarAccess.getCodetemplateAccess().getNameAssignment_0(), "rule__Codetemplate__NameAssignment_0");
			mappings.put(grammarAccess.getCodetemplateAccess().getIdAssignment_2(), "rule__Codetemplate__IdAssignment_2");
			mappings.put(grammarAccess.getCodetemplateAccess().getDescriptionAssignment_4(), "rule__Codetemplate__DescriptionAssignment_4");
			mappings.put(grammarAccess.getCodetemplateAccess().getContextAssignment_7_0(), "rule__Codetemplate__ContextAssignment_7_0");
			mappings.put(grammarAccess.getCodetemplateAccess().getKeywordContextAssignment_7_1(), "rule__Codetemplate__KeywordContextAssignment_7_1");
			mappings.put(grammarAccess.getCodetemplateAccess().getBodyAssignment_8(), "rule__Codetemplate__BodyAssignment_8");
			mappings.put(grammarAccess.getTemplateBodyAccess().getPartsAssignment_1(), "rule__TemplateBody__PartsAssignment_1");
			mappings.put(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_0(), "rule__TemplateBody__PartsAssignment_2_0");
			mappings.put(grammarAccess.getTemplateBodyAccess().getPartsAssignment_2_1(), "rule__TemplateBody__PartsAssignment_2_1");
			mappings.put(grammarAccess.getVariableAccess().getNameAssignment_2_0(), "rule__Variable__NameAssignment_2_0");
			mappings.put(grammarAccess.getVariableAccess().getNameAssignment_2_1_0_0(), "rule__Variable__NameAssignment_2_1_0_0");
			mappings.put(grammarAccess.getVariableAccess().getTypeAssignment_2_1_3(), "rule__Variable__TypeAssignment_2_1_3");
			mappings.put(grammarAccess.getVariableAccess().getExpectingParametersAssignment_2_1_4_1(), "rule__Variable__ExpectingParametersAssignment_2_1_4_1");
			mappings.put(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_0(), "rule__Variable__ParametersAssignment_2_1_4_3_0");
			mappings.put(grammarAccess.getVariableAccess().getParametersAssignment_2_1_4_3_1_3(), "rule__Variable__ParametersAssignment_2_1_4_3_1_3");
			mappings.put(grammarAccess.getLiteralAccess().getValueAssignment(), "rule__Literal__ValueAssignment");
			mappings.put(grammarAccess.getDollarAccess().getEscapedAssignment_1_0(), "rule__Dollar__EscapedAssignment_1_0");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private CodetemplatesGrammarAccess grammarAccess;

	@Override
	protected InternalCodetemplatesParser createParser() {
		InternalCodetemplatesParser result = new InternalCodetemplatesParser(null);
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

	public CodetemplatesGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CodetemplatesGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
