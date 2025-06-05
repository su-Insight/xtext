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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug288760TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288760TestLanguageGrammarAccess;

public class Bug288760TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug288760TestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, Bug288760TestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getWorkflowElementAccess().getAlternatives(), "rule__WorkflowElement__Alternatives");
			mappings.put(grammarAccess.getWorkflowElementAccess().getGroup_0(), "rule__WorkflowElement__Group_0__0");
			mappings.put(grammarAccess.getWorkflowElementAccess().getGroup_1(), "rule__WorkflowElement__Group_1__0");
			mappings.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			mappings.put(grammarAccess.getWorkflowElementAccess().getNameAssignment_0_0(), "rule__WorkflowElement__NameAssignment_0_0");
			mappings.put(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_0_1(), "rule__WorkflowElement__AttributesAssignment_0_1");
			mappings.put(grammarAccess.getWorkflowElementAccess().getNameAssignment_1_0(), "rule__WorkflowElement__NameAssignment_1_0");
			mappings.put(grammarAccess.getWorkflowElementAccess().getAttributesAssignment_1_1(), "rule__WorkflowElement__AttributesAssignment_1_1");
			mappings.put(grammarAccess.getWorkflowElementAccess().getChildrenAssignment_1_3(), "rule__WorkflowElement__ChildrenAssignment_1_3");
			mappings.put(grammarAccess.getWorkflowElementAccess().getEndAssignment_1_4(), "rule__WorkflowElement__EndAssignment_1_4");
			mappings.put(grammarAccess.getAttributeAccess().getNameAssignment_0(), "rule__Attribute__NameAssignment_0");
			mappings.put(grammarAccess.getAttributeAccess().getValueAssignment_2(), "rule__Attribute__ValueAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug288760TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug288760TestLanguageParser createParser() {
		InternalBug288760TestLanguageParser result = new InternalBug288760TestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT" };
	}

	public Bug288760TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug288760TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
