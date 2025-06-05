/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.xmleditor.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.xmleditor.ide.contentassist.antlr.internal.InternalXmlParser;
import org.eclipse.xtext.ui.tests.xmleditor.services.XmlGrammarAccess;

public class XmlParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(XmlGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, XmlGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getContentAccess().getAlternatives(), "rule__Content__Alternatives");
			mappings.put(grammarAccess.getTagAccess().getAlternatives_3(), "rule__Tag__Alternatives_3");
			mappings.put(grammarAccess.getXmlDocumentAccess().getGroup(), "rule__XmlDocument__Group__0");
			mappings.put(grammarAccess.getTagAccess().getGroup(), "rule__Tag__Group__0");
			mappings.put(grammarAccess.getTagAccess().getGroup_3_1(), "rule__Tag__Group_3_1__0");
			mappings.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			mappings.put(grammarAccess.getXmlDocumentAccess().getContentsAssignment_1(), "rule__XmlDocument__ContentsAssignment_1");
			mappings.put(grammarAccess.getContentAccess().getTagAssignment_0(), "rule__Content__TagAssignment_0");
			mappings.put(grammarAccess.getContentAccess().getTextAssignment_1(), "rule__Content__TextAssignment_1");
			mappings.put(grammarAccess.getTagAccess().getNameAssignment_1(), "rule__Tag__NameAssignment_1");
			mappings.put(grammarAccess.getTagAccess().getAttributesAssignment_2(), "rule__Tag__AttributesAssignment_2");
			mappings.put(grammarAccess.getTagAccess().getContentsAssignment_3_1_1(), "rule__Tag__ContentsAssignment_3_1_1");
			mappings.put(grammarAccess.getTagAccess().getCloseNameAssignment_3_1_3(), "rule__Tag__CloseNameAssignment_3_1_3");
			mappings.put(grammarAccess.getAttributeAccess().getNameAssignment_0(), "rule__Attribute__NameAssignment_0");
			mappings.put(grammarAccess.getAttributeAccess().getValueAssignment_2(), "rule__Attribute__ValueAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private XmlGrammarAccess grammarAccess;

	@Override
	protected InternalXmlParser createParser() {
		InternalXmlParser result = new InternalXmlParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] {  };
	}

	public XmlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(XmlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
