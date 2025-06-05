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
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug289187TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug289187TestLanguageGrammarAccess;

public class Bug289187TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug289187TestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, Bug289187TestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getVisibilityAccess().getAlternatives(), "rule__Visibility__Alternatives");
			mappings.put(grammarAccess.getClassAccess().getGroup(), "rule__Class__Group__0");
			mappings.put(grammarAccess.getClassAccess().getGroup_4(), "rule__Class__Group_4__0");
			mappings.put(grammarAccess.getClassAccess().getGroup_5(), "rule__Class__Group_5__0");
			mappings.put(grammarAccess.getClassAccess().getGroup_5_2(), "rule__Class__Group_5_2__0");
			mappings.put(grammarAccess.getClassAccess().getGroup_7(), "rule__Class__Group_7__0");
			mappings.put(grammarAccess.getClassAccess().getGroup_8(), "rule__Class__Group_8__0");
			mappings.put(grammarAccess.getClassAccess().getGroup_9(), "rule__Class__Group_9__0");
			mappings.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			mappings.put(grammarAccess.getOperationAccess().getGroup(), "rule__Operation__Group__0");
			mappings.put(grammarAccess.getModelAccess().getClassesAssignment(), "rule__Model__ClassesAssignment");
			mappings.put(grammarAccess.getClassAccess().getAbstractAssignment_0(), "rule__Class__AbstractAssignment_0");
			mappings.put(grammarAccess.getClassAccess().getTransientAssignment_1(), "rule__Class__TransientAssignment_1");
			mappings.put(grammarAccess.getClassAccess().getNameAssignment_3(), "rule__Class__NameAssignment_3");
			mappings.put(grammarAccess.getClassAccess().getSuperClassAssignment_4_1(), "rule__Class__SuperClassAssignment_4_1");
			mappings.put(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_1(), "rule__Class__ImplementedInterfacesAssignment_5_1");
			mappings.put(grammarAccess.getClassAccess().getImplementedInterfacesAssignment_5_2_2(), "rule__Class__ImplementedInterfacesAssignment_5_2_2");
			mappings.put(grammarAccess.getClassAccess().getClassNumberAssignment_7_2(), "rule__Class__ClassNumberAssignment_7_2");
			mappings.put(grammarAccess.getClassAccess().getQuidAssignment_8_2(), "rule__Class__QuidAssignment_8_2");
			mappings.put(grammarAccess.getClassAccess().getDocumentationAssignment_9_2(), "rule__Class__DocumentationAssignment_9_2");
			mappings.put(grammarAccess.getClassAccess().getAttributesAssignment_10(), "rule__Class__AttributesAssignment_10");
			mappings.put(grammarAccess.getClassAccess().getOperationsAssignment_11(), "rule__Class__OperationsAssignment_11");
			mappings.put(grammarAccess.getAttributeAccess().getVisibilityAssignment_0(), "rule__Attribute__VisibilityAssignment_0");
			mappings.put(grammarAccess.getAttributeAccess().getNameAssignment_2(), "rule__Attribute__NameAssignment_2");
			mappings.put(grammarAccess.getOperationAccess().getVisibilityAssignment_0(), "rule__Operation__VisibilityAssignment_0");
			mappings.put(grammarAccess.getOperationAccess().getNameAssignment_2(), "rule__Operation__NameAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug289187TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug289187TestLanguageParser createParser() {
		InternalBug289187TestLanguageParser result = new InternalBug289187TestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public Bug289187TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug289187TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
