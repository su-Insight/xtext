/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.backtracking.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.testlanguages.backtracking.ide.contentassist.antlr.internal.InternalBeeLangTestLanguageParser;
import org.eclipse.xtext.testlanguages.backtracking.services.BeeLangTestLanguageGrammarAccess;

public class BeeLangTestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(BeeLangTestLanguageGrammarAccess grammarAccess) {
			Map<AbstractElement, String> mappings = new HashMap<>();
			init(mappings, grammarAccess);
			this.mappings = Map.copyOf(mappings);
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(Map<AbstractElement, String> mappings, BeeLangTestLanguageGrammarAccess grammarAccess) {
			mappings.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getAlternatives_1(), "rule__ProvidedCapability__Alternatives_1");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getAlternatives_0(), "rule__AliasedRequiredCapability__Alternatives_0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getAlternatives_1(), "rule__RequiredCapability__Alternatives_1");
			mappings.put(grammarAccess.getPathAccess().getAlternatives(), "rule__Path__Alternatives");
			mappings.put(grammarAccess.getFirstParameterAccess().getAlternatives(), "rule__FirstParameter__Alternatives");
			mappings.put(grammarAccess.getFunctionAccess().getAlternatives_6_1(), "rule__Function__Alternatives_6_1");
			mappings.put(grammarAccess.getFunctionAccess().getAlternatives_8(), "rule__Function__Alternatives_8");
			mappings.put(grammarAccess.getGuardExpressionAccess().getAlternatives(), "rule__GuardExpression__Alternatives");
			mappings.put(grammarAccess.getAssignmentOperatorAccess().getAlternatives(), "rule__AssignmentOperator__Alternatives");
			mappings.put(grammarAccess.getRelationalOperatorAccess().getAlternatives(), "rule__RelationalOperator__Alternatives");
			mappings.put(grammarAccess.getTopLevelExpressionAccess().getAlternatives(), "rule__TopLevelExpression__Alternatives");
			mappings.put(grammarAccess.getVarDeclarationAccess().getAlternatives_2_0(), "rule__VarDeclaration__Alternatives_2_0");
			mappings.put(grammarAccess.getTypeRefAccess().getAlternatives(), "rule__TypeRef__Alternatives");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getAlternatives_1(), "rule__ClosureTypeRef__Alternatives_1");
			mappings.put(grammarAccess.getCachedExpressionAccess().getAlternatives(), "rule__CachedExpression__Alternatives");
			mappings.put(grammarAccess.getAdditiveExpressionAccess().getFunctionNameAlternatives_1_1_0(), "rule__AdditiveExpression__FunctionNameAlternatives_1_1_0");
			mappings.put(grammarAccess.getMultiplicativeExpressionAccess().getFunctionNameAlternatives_1_1_0(), "rule__MultiplicativeExpression__FunctionNameAlternatives_1_1_0");
			mappings.put(grammarAccess.getUnaryOrInfixExpressionAccess().getAlternatives(), "rule__UnaryOrInfixExpression__Alternatives");
			mappings.put(grammarAccess.getUnaryExpressionAccess().getFunctionNameAlternatives_1_0(), "rule__UnaryExpression__FunctionNameAlternatives_1_0");
			mappings.put(grammarAccess.getPreopExpressionAccess().getFunctionNameAlternatives_1_0(), "rule__PreopExpression__FunctionNameAlternatives_1_0");
			mappings.put(grammarAccess.getPostopExpressionAccess().getFunctionNameAlternatives_1_1_0(), "rule__PostopExpression__FunctionNameAlternatives_1_1_0");
			mappings.put(grammarAccess.getInfixExpressionAccess().getAlternatives_1(), "rule__InfixExpression__Alternatives_1");
			mappings.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
			mappings.put(grammarAccess.getWithExpressionAccess().getAlternatives_2(), "rule__WithExpression__Alternatives_2");
			mappings.put(grammarAccess.getKeywordVariablesAccess().getNameAlternatives_1_0(), "rule__KeywordVariables__NameAlternatives_1_0");
			mappings.put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
			mappings.put(grammarAccess.getClosureExpressionAccess().getAlternatives_2(), "rule__ClosureExpression__Alternatives_2");
			mappings.put(grammarAccess.getOneOrManyExpressionsAccess().getAlternatives(), "rule__OneOrManyExpressions__Alternatives");
			mappings.put(grammarAccess.getQIDAccess().getAlternatives_1(), "rule__QID__Alternatives_1");
			mappings.put(grammarAccess.getQIDAccess().getAlternatives_2_2(), "rule__QID__Alternatives_2_2");
			mappings.put(grammarAccess.getUnitAccess().getGroup(), "rule__Unit__Group__0");
			mappings.put(grammarAccess.getUnitAccess().getGroup_4(), "rule__Unit__Group_4__0");
			mappings.put(grammarAccess.getUnitAccess().getGroup_5(), "rule__Unit__Group_5__0");
			mappings.put(grammarAccess.getUnitAccess().getGroup_5_2(), "rule__Unit__Group_5_2__0");
			mappings.put(grammarAccess.getUnitAccess().getGroup_7_0(), "rule__Unit__Group_7_0__0");
			mappings.put(grammarAccess.getUnitAccess().getGroup_7_1(), "rule__Unit__Group_7_1__0");
			mappings.put(grammarAccess.getUnitAccess().getGroup_7_2(), "rule__Unit__Group_7_2__0");
			mappings.put(grammarAccess.getUnitAccess().getGroup_7_3(), "rule__Unit__Group_7_3__0");
			mappings.put(grammarAccess.getUnitAccess().getGroup_7_4(), "rule__Unit__Group_7_4__0");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getGroup(), "rule__ProvidedCapability__Group__0");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getGroup_2(), "rule__ProvidedCapability__Group_2__0");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getGroup_2_1_0(), "rule__ProvidedCapability__Group_2_1_0__0");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getGroup_2_1_1(), "rule__ProvidedCapability__Group_2_1_1__0");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getGroup_2_1_2(), "rule__ProvidedCapability__Group_2_1_2__0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGroup(), "rule__AliasedRequiredCapability__Group__0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGroup_2(), "rule__AliasedRequiredCapability__Group_2__0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGroup_3(), "rule__AliasedRequiredCapability__Group_3__0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGroup_3_1_0(), "rule__AliasedRequiredCapability__Group_3_1_0__0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGroup_3_1_1(), "rule__AliasedRequiredCapability__Group_3_1_1__0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGroup_3_1_2(), "rule__AliasedRequiredCapability__Group_3_1_2__0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGroup_3_1_3(), "rule__AliasedRequiredCapability__Group_3_1_3__0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGroup_3_1_4(), "rule__AliasedRequiredCapability__Group_3_1_4__0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getGroup(), "rule__RequiredCapability__Group__0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getGroup_3(), "rule__RequiredCapability__Group_3__0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getGroup_3_1_0(), "rule__RequiredCapability__Group_3_1_0__0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getGroup_3_1_1(), "rule__RequiredCapability__Group_3_1_1__0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getGroup_3_1_2(), "rule__RequiredCapability__Group_3_1_2__0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getGroup_3_1_3(), "rule__RequiredCapability__Group_3_1_3__0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getGroup_3_1_4(), "rule__RequiredCapability__Group_3_1_4__0");
			mappings.put(grammarAccess.getPathAccess().getGroup_1(), "rule__Path__Group_1__0");
			mappings.put(grammarAccess.getPathAccess().getGroup_1_2(), "rule__Path__Group_1_2__0");
			mappings.put(grammarAccess.getParameterListAccess().getGroup(), "rule__ParameterList__Group__0");
			mappings.put(grammarAccess.getParameterListAccess().getGroup_1(), "rule__ParameterList__Group_1__0");
			mappings.put(grammarAccess.getParameterDeclarationAccess().getGroup(), "rule__ParameterDeclaration__Group__0");
			mappings.put(grammarAccess.getFunctionAccess().getGroup(), "rule__Function__Group__0");
			mappings.put(grammarAccess.getFunctionAccess().getGroup_6(), "rule__Function__Group_6__0");
			mappings.put(grammarAccess.getFunctionAccess().getGroup_6_1_0(), "rule__Function__Group_6_1_0__0");
			mappings.put(grammarAccess.getFunctionAccess().getGroup_6_1_0_1(), "rule__Function__Group_6_1_0_1__0");
			mappings.put(grammarAccess.getFunctionAccess().getGroup_6_1_0_2(), "rule__Function__Group_6_1_0_2__0");
			mappings.put(grammarAccess.getFunctionAccess().getGroup_6_1_1(), "rule__Function__Group_6_1_1__0");
			mappings.put(grammarAccess.getFunctionAccess().getGroup_7(), "rule__Function__Group_7__0");
			mappings.put(grammarAccess.getFunctionAccess().getGroup_8_0(), "rule__Function__Group_8_0__0");
			mappings.put(grammarAccess.getGuardExpressionAccess().getGroup_0(), "rule__GuardExpression__Group_0__0");
			mappings.put(grammarAccess.getAssignmentExpressionAccess().getGroup(), "rule__AssignmentExpression__Group__0");
			mappings.put(grammarAccess.getAssignmentExpressionAccess().getGroup_1(), "rule__AssignmentExpression__Group_1__0");
			mappings.put(grammarAccess.getVarDeclarationAccess().getGroup(), "rule__VarDeclaration__Group__0");
			mappings.put(grammarAccess.getVarDeclarationAccess().getGroup_2(), "rule__VarDeclaration__Group_2__0");
			mappings.put(grammarAccess.getVarDeclarationAccess().getGroup_3(), "rule__VarDeclaration__Group_3__0");
			mappings.put(grammarAccess.getValDeclarationAccess().getGroup(), "rule__ValDeclaration__Group__0");
			mappings.put(grammarAccess.getSimpleTypeRefAccess().getGroup(), "rule__SimpleTypeRef__Group__0");
			mappings.put(grammarAccess.getSimpleTypeRefAccess().getGroup_1(), "rule__SimpleTypeRef__Group_1__0");
			mappings.put(grammarAccess.getSimpleTypeRefAccess().getGroup_1_2(), "rule__SimpleTypeRef__Group_1_2__0");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getGroup(), "rule__ClosureTypeRef__Group__0");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getGroup_1_0(), "rule__ClosureTypeRef__Group_1_0__0");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getGroup_1_0_1(), "rule__ClosureTypeRef__Group_1_0_1__0");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getGroup_1_0_2(), "rule__ClosureTypeRef__Group_1_0_2__0");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getGroup_1_1(), "rule__ClosureTypeRef__Group_1_1__0");
			mappings.put(grammarAccess.getCachedExpressionAccess().getGroup_0(), "rule__CachedExpression__Group_0__0");
			mappings.put(grammarAccess.getOrExpressionAccess().getGroup(), "rule__OrExpression__Group__0");
			mappings.put(grammarAccess.getOrExpressionAccess().getGroup_1(), "rule__OrExpression__Group_1__0");
			mappings.put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
			mappings.put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
			mappings.put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
			mappings.put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
			mappings.put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
			mappings.put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
			mappings.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
			mappings.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
			mappings.put(grammarAccess.getSetExpressionAccess().getGroup(), "rule__SetExpression__Group__0");
			mappings.put(grammarAccess.getSetExpressionAccess().getGroup_1(), "rule__SetExpression__Group_1__0");
			mappings.put(grammarAccess.getUnaryExpressionAccess().getGroup(), "rule__UnaryExpression__Group__0");
			mappings.put(grammarAccess.getPreopExpressionAccess().getGroup(), "rule__PreopExpression__Group__0");
			mappings.put(grammarAccess.getPostopExpressionAccess().getGroup(), "rule__PostopExpression__Group__0");
			mappings.put(grammarAccess.getPostopExpressionAccess().getGroup_1(), "rule__PostopExpression__Group_1__0");
			mappings.put(grammarAccess.getInfixExpressionAccess().getGroup(), "rule__InfixExpression__Group__0");
			mappings.put(grammarAccess.getInfixExpressionAccess().getGroup_1_0(), "rule__InfixExpression__Group_1_0__0");
			mappings.put(grammarAccess.getInfixExpressionAccess().getGroup_1_1(), "rule__InfixExpression__Group_1_1__0");
			mappings.put(grammarAccess.getInfixExpressionAccess().getGroup_1_2(), "rule__InfixExpression__Group_1_2__0");
			mappings.put(grammarAccess.getCallExpressionAccess().getGroup(), "rule__CallExpression__Group__0");
			mappings.put(grammarAccess.getCallExpressionAccess().getGroup_1(), "rule__CallExpression__Group_1__0");
			mappings.put(grammarAccess.getWithExpressionAccess().getGroup(), "rule__WithExpression__Group__0");
			mappings.put(grammarAccess.getWithExpressionAccess().getGroup_1(), "rule__WithExpression__Group_1__0");
			mappings.put(grammarAccess.getWithExpressionAccess().getGroup_1_1(), "rule__WithExpression__Group_1_1__0");
			mappings.put(grammarAccess.getWithExpressionAccess().getGroup_2_0(), "rule__WithExpression__Group_2_0__0");
			mappings.put(grammarAccess.getWithExpressionAccess().getGroup_2_1(), "rule__WithExpression__Group_2_1__0");
			mappings.put(grammarAccess.getWithContextExpressionAccess().getGroup(), "rule__WithContextExpression__Group__0");
			mappings.put(grammarAccess.getWithContextExpressionAccess().getGroup_3(), "rule__WithContextExpression__Group_3__0");
			mappings.put(grammarAccess.getBlockExpressionAccess().getGroup(), "rule__BlockExpression__Group__0");
			mappings.put(grammarAccess.getBlockExpressionAccess().getGroup_2(), "rule__BlockExpression__Group_2__0");
			mappings.put(grammarAccess.getValueAccess().getGroup(), "rule__Value__Group__0");
			mappings.put(grammarAccess.getKeywordVariablesAccess().getGroup(), "rule__KeywordVariables__Group__0");
			mappings.put(grammarAccess.getOperationCallAccess().getGroup(), "rule__OperationCall__Group__0");
			mappings.put(grammarAccess.getConstructorCallExpressionAccess().getGroup(), "rule__ConstructorCallExpression__Group__0");
			mappings.put(grammarAccess.getConstructorCallExpressionAccess().getGroup_3(), "rule__ConstructorCallExpression__Group_3__0");
			mappings.put(grammarAccess.getConstructorCallExpressionAccess().getGroup_4(), "rule__ConstructorCallExpression__Group_4__0");
			mappings.put(grammarAccess.getInitializationBlockExpressionAccess().getGroup(), "rule__InitializationBlockExpression__Group__0");
			mappings.put(grammarAccess.getInitializationExpressionAccess().getGroup(), "rule__InitializationExpression__Group__0");
			mappings.put(grammarAccess.getFeatureOfThisAccess().getGroup(), "rule__FeatureOfThis__Group__0");
			mappings.put(grammarAccess.getLiteralFunctionAccess().getGroup(), "rule__LiteralFunction__Group__0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getGroup(), "rule__ClosureExpression__Group__0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getGroup_1(), "rule__ClosureExpression__Group_1__0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getGroup_2_0(), "rule__ClosureExpression__Group_2_0__0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getGroup_2_0_1(), "rule__ClosureExpression__Group_2_0_1__0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getGroup_2_0_1_1(), "rule__ClosureExpression__Group_2_0_1_1__0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getGroup_2_0_1_2(), "rule__ClosureExpression__Group_2_0_1_2__0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getGroup_2_1(), "rule__ClosureExpression__Group_2_1__0");
			mappings.put(grammarAccess.getBlockExpressionWithoutBracketsAccess().getGroup(), "rule__BlockExpressionWithoutBrackets__Group__0");
			mappings.put(grammarAccess.getBlockExpressionWithoutBracketsAccess().getGroup_1(), "rule__BlockExpressionWithoutBrackets__Group_1__0");
			mappings.put(grammarAccess.getParanthesizedExpressionAccess().getGroup(), "rule__ParanthesizedExpression__Group__0");
			mappings.put(grammarAccess.getQIDAccess().getGroup(), "rule__QID__Group__0");
			mappings.put(grammarAccess.getQIDAccess().getGroup_2(), "rule__QID__Group_2__0");
			mappings.put(grammarAccess.getModelAccess().getUnitsAssignment_0(), "rule__Model__UnitsAssignment_0");
			mappings.put(grammarAccess.getModelAccess().getFunctionsAssignment_1(), "rule__Model__FunctionsAssignment_1");
			mappings.put(grammarAccess.getUnitAccess().getDocumentationAssignment_1(), "rule__Unit__DocumentationAssignment_1");
			mappings.put(grammarAccess.getUnitAccess().getNameAssignment_3(), "rule__Unit__NameAssignment_3");
			mappings.put(grammarAccess.getUnitAccess().getVersionAssignment_4_1(), "rule__Unit__VersionAssignment_4_1");
			mappings.put(grammarAccess.getUnitAccess().getImplementsAssignment_5_1(), "rule__Unit__ImplementsAssignment_5_1");
			mappings.put(grammarAccess.getUnitAccess().getImplementsAssignment_5_2_1(), "rule__Unit__ImplementsAssignment_5_2_1");
			mappings.put(grammarAccess.getUnitAccess().getSourceLocationAssignment_7_0_2(), "rule__Unit__SourceLocationAssignment_7_0_2");
			mappings.put(grammarAccess.getUnitAccess().getOutputLocationAssignment_7_1_2(), "rule__Unit__OutputLocationAssignment_7_1_2");
			mappings.put(grammarAccess.getUnitAccess().getProvidedCapabilitiesAssignment_7_2_2(), "rule__Unit__ProvidedCapabilitiesAssignment_7_2_2");
			mappings.put(grammarAccess.getUnitAccess().getRequiredCapabilitiesAssignment_7_3_2(), "rule__Unit__RequiredCapabilitiesAssignment_7_3_2");
			mappings.put(grammarAccess.getUnitAccess().getMetaRequiredCapabilitiesAssignment_7_4_3(), "rule__Unit__MetaRequiredCapabilitiesAssignment_7_4_3");
			mappings.put(grammarAccess.getUnitAccess().getFunctionsAssignment_7_5(), "rule__Unit__FunctionsAssignment_7_5");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getNameSpaceAssignment_1_0(), "rule__ProvidedCapability__NameSpaceAssignment_1_0");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getCondExprAssignment_2_1_0_2(), "rule__ProvidedCapability__CondExprAssignment_2_1_0_2");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getNameAssignment_2_1_1_2(), "rule__ProvidedCapability__NameAssignment_2_1_1_2");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getVersionAssignment_2_1_2_2(), "rule__ProvidedCapability__VersionAssignment_2_1_2_2");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getNameSpaceAssignment_0_0(), "rule__AliasedRequiredCapability__NameSpaceAssignment_0_0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getNameAssignment_1(), "rule__AliasedRequiredCapability__NameAssignment_1");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getAliasAssignment_2_1(), "rule__AliasedRequiredCapability__AliasAssignment_2_1");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getCondExprAssignment_3_1_0_2(), "rule__AliasedRequiredCapability__CondExprAssignment_3_1_0_2");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getGreedyAssignment_3_1_1_0(), "rule__AliasedRequiredCapability__GreedyAssignment_3_1_1_0");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getMinAssignment_3_1_2_2(), "rule__AliasedRequiredCapability__MinAssignment_3_1_2_2");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getMaxAssignment_3_1_3_2(), "rule__AliasedRequiredCapability__MaxAssignment_3_1_3_2");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getVersionRangeAssignment_3_1_4_2(), "rule__AliasedRequiredCapability__VersionRangeAssignment_3_1_4_2");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getNameSpaceAssignment_1_0(), "rule__RequiredCapability__NameSpaceAssignment_1_0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getNameAssignment_2(), "rule__RequiredCapability__NameAssignment_2");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getCondExprAssignment_3_1_0_2(), "rule__RequiredCapability__CondExprAssignment_3_1_0_2");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getGreedyAssignment_3_1_1_0(), "rule__RequiredCapability__GreedyAssignment_3_1_1_0");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getMinAssignment_3_1_2_2(), "rule__RequiredCapability__MinAssignment_3_1_2_2");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getMaxAssignment_3_1_3_2(), "rule__RequiredCapability__MaxAssignment_3_1_3_2");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getVersionRangeAssignment_3_1_4_2(), "rule__RequiredCapability__VersionRangeAssignment_3_1_4_2");
			mappings.put(grammarAccess.getParameterListAccess().getParametersAssignment_0(), "rule__ParameterList__ParametersAssignment_0");
			mappings.put(grammarAccess.getParameterListAccess().getParametersAssignment_1_1(), "rule__ParameterList__ParametersAssignment_1_1");
			mappings.put(grammarAccess.getParameterAccess().getExprAssignment(), "rule__Parameter__ExprAssignment");
			mappings.put(grammarAccess.getClosureParameterAccess().getExprAssignment(), "rule__ClosureParameter__ExprAssignment");
			mappings.put(grammarAccess.getParameterDeclarationAccess().getTypeAssignment_0(), "rule__ParameterDeclaration__TypeAssignment_0");
			mappings.put(grammarAccess.getParameterDeclarationAccess().getNameAssignment_1(), "rule__ParameterDeclaration__NameAssignment_1");
			mappings.put(grammarAccess.getFunctionAccess().getDocumentationAssignment_0(), "rule__Function__DocumentationAssignment_0");
			mappings.put(grammarAccess.getFunctionAccess().getVisibilityAssignment_1(), "rule__Function__VisibilityAssignment_1");
			mappings.put(grammarAccess.getFunctionAccess().getFinalAssignment_2(), "rule__Function__FinalAssignment_2");
			mappings.put(grammarAccess.getFunctionAccess().getReturnTypeAssignment_4(), "rule__Function__ReturnTypeAssignment_4");
			mappings.put(grammarAccess.getFunctionAccess().getNameAssignment_5(), "rule__Function__NameAssignment_5");
			mappings.put(grammarAccess.getFunctionAccess().getParametersAssignment_6_1_0_0(), "rule__Function__ParametersAssignment_6_1_0_0");
			mappings.put(grammarAccess.getFunctionAccess().getParametersAssignment_6_1_0_1_1(), "rule__Function__ParametersAssignment_6_1_0_1_1");
			mappings.put(grammarAccess.getFunctionAccess().getVarArgsAssignment_6_1_0_2_1(), "rule__Function__VarArgsAssignment_6_1_0_2_1");
			mappings.put(grammarAccess.getFunctionAccess().getParametersAssignment_6_1_0_2_2(), "rule__Function__ParametersAssignment_6_1_0_2_2");
			mappings.put(grammarAccess.getFunctionAccess().getVarArgsAssignment_6_1_1_0(), "rule__Function__VarArgsAssignment_6_1_1_0");
			mappings.put(grammarAccess.getFunctionAccess().getParametersAssignment_6_1_1_1(), "rule__Function__ParametersAssignment_6_1_1_1");
			mappings.put(grammarAccess.getFunctionAccess().getGuardAssignment_7_1(), "rule__Function__GuardAssignment_7_1");
			mappings.put(grammarAccess.getFunctionAccess().getFuncExprAssignment_8_0_1(), "rule__Function__FuncExprAssignment_8_0_1");
			mappings.put(grammarAccess.getFunctionAccess().getFuncExprAssignment_8_1(), "rule__Function__FuncExprAssignment_8_1");
			mappings.put(grammarAccess.getGuardExpressionAccess().getGuardExprAssignment_0_1(), "rule__GuardExpression__GuardExprAssignment_0_1");
			mappings.put(grammarAccess.getGuardExpressionAccess().getGuardExprAssignment_1(), "rule__GuardExpression__GuardExprAssignment_1");
			mappings.put(grammarAccess.getAssignmentExpressionAccess().getFunctionNameAssignment_1_1(), "rule__AssignmentExpression__FunctionNameAssignment_1_1");
			mappings.put(grammarAccess.getAssignmentExpressionAccess().getRightExprAssignment_1_2(), "rule__AssignmentExpression__RightExprAssignment_1_2");
			mappings.put(grammarAccess.getVarDeclarationAccess().getFinalAssignment_1(), "rule__VarDeclaration__FinalAssignment_1");
			mappings.put(grammarAccess.getVarDeclarationAccess().getTypeAssignment_2_0_1(), "rule__VarDeclaration__TypeAssignment_2_0_1");
			mappings.put(grammarAccess.getVarDeclarationAccess().getNameAssignment_2_1(), "rule__VarDeclaration__NameAssignment_2_1");
			mappings.put(grammarAccess.getVarDeclarationAccess().getValueExprAssignment_3_1(), "rule__VarDeclaration__ValueExprAssignment_3_1");
			mappings.put(grammarAccess.getValDeclarationAccess().getFinalAssignment_1(), "rule__ValDeclaration__FinalAssignment_1");
			mappings.put(grammarAccess.getValDeclarationAccess().getImmutableAssignment_2(), "rule__ValDeclaration__ImmutableAssignment_2");
			mappings.put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3(), "rule__ValDeclaration__TypeAssignment_3");
			mappings.put(grammarAccess.getValDeclarationAccess().getNameAssignment_4(), "rule__ValDeclaration__NameAssignment_4");
			mappings.put(grammarAccess.getValDeclarationAccess().getValueExprAssignment_6(), "rule__ValDeclaration__ValueExprAssignment_6");
			mappings.put(grammarAccess.getSimpleTypeRefAccess().getRawTypeAssignment_0(), "rule__SimpleTypeRef__RawTypeAssignment_0");
			mappings.put(grammarAccess.getSimpleTypeRefAccess().getActualArgumentsListAssignment_1_1(), "rule__SimpleTypeRef__ActualArgumentsListAssignment_1_1");
			mappings.put(grammarAccess.getSimpleTypeRefAccess().getActualArgumentsListAssignment_1_2_1(), "rule__SimpleTypeRef__ActualArgumentsListAssignment_1_2_1");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getParameterTypesAssignment_1_0_0(), "rule__ClosureTypeRef__ParameterTypesAssignment_1_0_0");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getParameterTypesAssignment_1_0_1_1(), "rule__ClosureTypeRef__ParameterTypesAssignment_1_0_1_1");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getVarArgsAssignment_1_0_2_1(), "rule__ClosureTypeRef__VarArgsAssignment_1_0_2_1");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getParameterTypesAssignment_1_0_2_2(), "rule__ClosureTypeRef__ParameterTypesAssignment_1_0_2_2");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getVarArgsAssignment_1_1_0(), "rule__ClosureTypeRef__VarArgsAssignment_1_1_0");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getParameterTypesAssignment_1_1_1(), "rule__ClosureTypeRef__ParameterTypesAssignment_1_1_1");
			mappings.put(grammarAccess.getClosureTypeRefAccess().getReturnTypeAssignment_4(), "rule__ClosureTypeRef__ReturnTypeAssignment_4");
			mappings.put(grammarAccess.getCachedExpressionAccess().getExprAssignment_0_2(), "rule__CachedExpression__ExprAssignment_0_2");
			mappings.put(grammarAccess.getOrExpressionAccess().getRightExprAssignment_1_2(), "rule__OrExpression__RightExprAssignment_1_2");
			mappings.put(grammarAccess.getAndExpressionAccess().getRightExprAssignment_1_2(), "rule__AndExpression__RightExprAssignment_1_2");
			mappings.put(grammarAccess.getRelationalExpressionAccess().getFunctionNameAssignment_1_1(), "rule__RelationalExpression__FunctionNameAssignment_1_1");
			mappings.put(grammarAccess.getRelationalExpressionAccess().getRightExprAssignment_1_2(), "rule__RelationalExpression__RightExprAssignment_1_2");
			mappings.put(grammarAccess.getAdditiveExpressionAccess().getFunctionNameAssignment_1_1(), "rule__AdditiveExpression__FunctionNameAssignment_1_1");
			mappings.put(grammarAccess.getAdditiveExpressionAccess().getRightExprAssignment_1_2(), "rule__AdditiveExpression__RightExprAssignment_1_2");
			mappings.put(grammarAccess.getMultiplicativeExpressionAccess().getFunctionNameAssignment_1_1(), "rule__MultiplicativeExpression__FunctionNameAssignment_1_1");
			mappings.put(grammarAccess.getMultiplicativeExpressionAccess().getRightExprAssignment_1_2(), "rule__MultiplicativeExpression__RightExprAssignment_1_2");
			mappings.put(grammarAccess.getSetExpressionAccess().getFunctionNameAssignment_1_1(), "rule__SetExpression__FunctionNameAssignment_1_1");
			mappings.put(grammarAccess.getSetExpressionAccess().getRightExprAssignment_1_2(), "rule__SetExpression__RightExprAssignment_1_2");
			mappings.put(grammarAccess.getUnaryExpressionAccess().getFunctionNameAssignment_1(), "rule__UnaryExpression__FunctionNameAssignment_1");
			mappings.put(grammarAccess.getUnaryExpressionAccess().getExprAssignment_2(), "rule__UnaryExpression__ExprAssignment_2");
			mappings.put(grammarAccess.getPreopExpressionAccess().getFunctionNameAssignment_1(), "rule__PreopExpression__FunctionNameAssignment_1");
			mappings.put(grammarAccess.getPreopExpressionAccess().getExprAssignment_2(), "rule__PreopExpression__ExprAssignment_2");
			mappings.put(grammarAccess.getPostopExpressionAccess().getFunctionNameAssignment_1_1(), "rule__PostopExpression__FunctionNameAssignment_1_1");
			mappings.put(grammarAccess.getInfixExpressionAccess().getNameAssignment_1_0_2(), "rule__InfixExpression__NameAssignment_1_0_2");
			mappings.put(grammarAccess.getInfixExpressionAccess().getParameterListAssignment_1_0_4(), "rule__InfixExpression__ParameterListAssignment_1_0_4");
			mappings.put(grammarAccess.getInfixExpressionAccess().getIndexExprAssignment_1_1_2(), "rule__InfixExpression__IndexExprAssignment_1_1_2");
			mappings.put(grammarAccess.getInfixExpressionAccess().getFeatureNameAssignment_1_2_2(), "rule__InfixExpression__FeatureNameAssignment_1_2_2");
			mappings.put(grammarAccess.getCallExpressionAccess().getParameterListAssignment_1_2(), "rule__CallExpression__ParameterListAssignment_1_2");
			mappings.put(grammarAccess.getWithExpressionAccess().getReferencedAdviceAssignment_1_0(), "rule__WithExpression__ReferencedAdviceAssignment_1_0");
			mappings.put(grammarAccess.getWithExpressionAccess().getReferencedAdviceAssignment_1_1_1(), "rule__WithExpression__ReferencedAdviceAssignment_1_1_1");
			mappings.put(grammarAccess.getWithExpressionAccess().getFuncExprAssignment_2_0_1(), "rule__WithExpression__FuncExprAssignment_2_0_1");
			mappings.put(grammarAccess.getWithExpressionAccess().getFuncExprAssignment_2_1_1(), "rule__WithExpression__FuncExprAssignment_2_1_1");
			mappings.put(grammarAccess.getWithContextExpressionAccess().getExprAssignment_2(), "rule__WithContextExpression__ExprAssignment_2");
			mappings.put(grammarAccess.getWithContextExpressionAccess().getAliasAssignment_3_1(), "rule__WithContextExpression__AliasAssignment_3_1");
			mappings.put(grammarAccess.getWithContextExpressionAccess().getContextBlockAssignment_4(), "rule__WithContextExpression__ContextBlockAssignment_4");
			mappings.put(grammarAccess.getBlockExpressionAccess().getExpressionsAssignment_2_0(), "rule__BlockExpression__ExpressionsAssignment_2_0");
			mappings.put(grammarAccess.getValueAccess().getNameAssignment_1(), "rule__Value__NameAssignment_1");
			mappings.put(grammarAccess.getKeywordVariablesAccess().getNameAssignment_1(), "rule__KeywordVariables__NameAssignment_1");
			mappings.put(grammarAccess.getOperationCallAccess().getNameAssignment_1(), "rule__OperationCall__NameAssignment_1");
			mappings.put(grammarAccess.getOperationCallAccess().getParameterListAssignment_3(), "rule__OperationCall__ParameterListAssignment_3");
			mappings.put(grammarAccess.getConstructorCallExpressionAccess().getTypeExprAssignment_2(), "rule__ConstructorCallExpression__TypeExprAssignment_2");
			mappings.put(grammarAccess.getConstructorCallExpressionAccess().getParameterListAssignment_3_1(), "rule__ConstructorCallExpression__ParameterListAssignment_3_1");
			mappings.put(grammarAccess.getConstructorCallExpressionAccess().getAliasAssignment_4_1(), "rule__ConstructorCallExpression__AliasAssignment_4_1");
			mappings.put(grammarAccess.getConstructorCallExpressionAccess().getContextBlockAssignment_5(), "rule__ConstructorCallExpression__ContextBlockAssignment_5");
			mappings.put(grammarAccess.getInitializationBlockExpressionAccess().getExpressionsAssignment_2(), "rule__InitializationBlockExpression__ExpressionsAssignment_2");
			mappings.put(grammarAccess.getInitializationExpressionAccess().getLeftExprAssignment_1(), "rule__InitializationExpression__LeftExprAssignment_1");
			mappings.put(grammarAccess.getInitializationExpressionAccess().getFunctionNameAssignment_2(), "rule__InitializationExpression__FunctionNameAssignment_2");
			mappings.put(grammarAccess.getInitializationExpressionAccess().getRightExprAssignment_3(), "rule__InitializationExpression__RightExprAssignment_3");
			mappings.put(grammarAccess.getFeatureOfThisAccess().getFeatureNameAssignment_1(), "rule__FeatureOfThis__FeatureNameAssignment_1");
			mappings.put(grammarAccess.getClosureExpressionAccess().getReturnTypeAssignment_1_1(), "rule__ClosureExpression__ReturnTypeAssignment_1_1");
			mappings.put(grammarAccess.getClosureExpressionAccess().getParametersAssignment_2_0_1_0(), "rule__ClosureExpression__ParametersAssignment_2_0_1_0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getParametersAssignment_2_0_1_1_1(), "rule__ClosureExpression__ParametersAssignment_2_0_1_1_1");
			mappings.put(grammarAccess.getClosureExpressionAccess().getVarArgsAssignment_2_0_1_2_1(), "rule__ClosureExpression__VarArgsAssignment_2_0_1_2_1");
			mappings.put(grammarAccess.getClosureExpressionAccess().getParametersAssignment_2_0_1_2_2(), "rule__ClosureExpression__ParametersAssignment_2_0_1_2_2");
			mappings.put(grammarAccess.getClosureExpressionAccess().getVarArgsAssignment_2_1_0(), "rule__ClosureExpression__VarArgsAssignment_2_1_0");
			mappings.put(grammarAccess.getClosureExpressionAccess().getParametersAssignment_2_1_1(), "rule__ClosureExpression__ParametersAssignment_2_1_1");
			mappings.put(grammarAccess.getClosureExpressionAccess().getFuncExprAssignment_4(), "rule__ClosureExpression__FuncExprAssignment_4");
			mappings.put(grammarAccess.getBlockExpressionWithoutBracketsAccess().getExpressionsAssignment_1_0(), "rule__BlockExpressionWithoutBrackets__ExpressionsAssignment_1_0");
			mappings.put(grammarAccess.getValueLiteralAccess().getValueAssignment(), "rule__ValueLiteral__ValueAssignment");
			mappings.put(grammarAccess.getUnitAccess().getUnorderedGroup_7(), "rule__Unit__UnorderedGroup_7");
			mappings.put(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), "rule__ProvidedCapability__UnorderedGroup_2_1");
			mappings.put(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), "rule__AliasedRequiredCapability__UnorderedGroup_3_1");
			mappings.put(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), "rule__RequiredCapability__UnorderedGroup_3_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private BeeLangTestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBeeLangTestLanguageParser createParser() {
		InternalBeeLangTestLanguageParser result = new InternalBeeLangTestLanguageParser(null);
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

	public BeeLangTestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(BeeLangTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
