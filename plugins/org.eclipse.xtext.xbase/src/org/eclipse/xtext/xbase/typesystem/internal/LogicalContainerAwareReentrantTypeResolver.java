/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class LogicalContainerAwareReentrantTypeResolver extends DefaultReentrantTypeResolver {

	public static class DemandTypeReferenceProvider extends AbstractReentrantTypeReferenceProvider {
		private final XExpression expression;
		private final ResolvedTypes resolvedTypes;
		private final boolean returnType;

		public DemandTypeReferenceProvider(XExpression expression, ResolvedTypes resolvedTypes, boolean returnType) {
			this.expression = expression;
			this.resolvedTypes = resolvedTypes;
			this.returnType = returnType;
		}

		@Override
		@Nullable
		protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
			LightweightTypeReference actualType = returnType ? resolvedTypes.getReturnType(expression) : resolvedTypes.getActualType(expression);
			if (actualType == null)
				return null;
			return actualType.toTypeReference();
		}
	}

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Override
	public void initializeFrom(EObject root) {
		if (!(root instanceof JvmType)) {
			throw new IllegalArgumentException("only JvmTypes are supported as root by this resolver");
		}
		super.initializeFrom(root);
	}
	
	@Override
	protected JvmType getRoot() {
		return (JvmType) super.getRoot();
	}
	
	/**
	 * Assign computed type references to the identifiable structural elements in the processed type.
	 */
	protected void prepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession) {
		doPrepare(resolvedTypes, featureScopeSession, getRoot());
	}
	
	protected void doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmIdentifiableElement element) {
		if (element instanceof JvmDeclaredType) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmDeclaredType) element);
		} else if (element instanceof JvmConstructor) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmConstructor) element);
		} else if (element instanceof JvmField) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmField) element);
		} else if (element instanceof JvmOperation) {
			_doPrepare(resolvedTypes, featureScopeSession, (JvmOperation) element);
		}
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, type);
		List<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			doPrepare(resolvedTypes, childSession, members.get(i));
		}
	}

	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmField field) {
		JvmTypeReference knownType = field.getType();
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference reference = createComputedTypeReference(resolvedTypes, featureScopeSession, field, false);
			casted.setEquivalent(reference);
		} else if (knownType != null) {
			LightweightTypeReference lightweightReference = resolvedTypes.getConverter().toLightweightReference(knownType);
			resolvedTypes.setType(field, lightweightReference);
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypes, featureScopeSession, field, false);
			field.setType(reference);
		}
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmConstructor constructor) {
		JvmDeclaredType producedType = constructor.getDeclaringType();
		JvmParameterizedTypeReference asReference = getServices().getTypeReferences().createTypeRef(producedType);
		LightweightTypeReference lightweightReference = resolvedTypes.getConverter().toLightweightReference(asReference);
		resolvedTypes.setType(constructor, lightweightReference);
	}
	
	protected void _doPrepare(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmOperation operation) {
		JvmTypeReference knownType = operation.getReturnType();
		if (InferredTypeIndicator.isInferred(knownType)) {
			XComputedTypeReference casted = (XComputedTypeReference) knownType;
			JvmTypeReference reference = createComputedTypeReference(resolvedTypes, featureScopeSession, operation, true);
			casted.setEquivalent(reference);
		} else if (knownType != null) {
			LightweightTypeReference lightweightReference = resolvedTypes.getConverter().toLightweightReference(knownType);
			resolvedTypes.setType(operation, lightweightReference);
		} else {
			JvmTypeReference reference = createComputedTypeReference(resolvedTypes, featureScopeSession, operation, true);
			operation.setReturnType(reference);
		}
	}
	
	protected JvmTypeReference createComputedTypeReference(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member, boolean returnType) {
		XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
		result.setTypeProvider(createTypeProvider(resolvedTypes, featureScopeSession, member, returnType));
		// TODO do we need a lightweight computed type reference?
//		resolvedTypes.setType(member, result);
		return result;
	}
	
	protected AbstractReentrantTypeReferenceProvider createTypeProvider(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmMember member, boolean returnType) {
		XExpression expression = logicalContainerProvider.getAssociatedExpression(member);
		return new DemandTypeReferenceProvider(expression, resolvedTypes, returnType);
	}
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		prepare(resolvedTypes, session);
		super.computeTypes(resolvedTypes, session);
		processResult(resolvedTypes);
	}
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, EObject element) {
		if (element instanceof JvmConstructor) {
			_computeTypes(resolvedTypes, featureScopeSession, (JvmConstructor) element);
		} else if (element instanceof JvmField) {
			_computeTypes(resolvedTypes, featureScopeSession, (JvmField) element);
		} else if (element instanceof JvmOperation) {
			_computeTypes(resolvedTypes, featureScopeSession, (JvmOperation) element);
		} else if (element instanceof JvmDeclaredType) {
			_computeTypes(resolvedTypes, featureScopeSession, (JvmDeclaredType) element);
		} else {
			super.computeTypes(resolvedTypes, featureScopeSession, element);
		}
	}

	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmField field) {
		FieldTypeComputationState state = new FieldTypeComputationState(resolvedTypes, featureScopeSession, field, this);
		state.computeTypes();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, field);
	}
	
	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmConstructor constructor) {
		ConstructorBodyComputationState state = new ConstructorBodyComputationState(resolvedTypes, featureScopeSession, constructor, this);
		state.computeTypes();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, constructor);
	}
	
	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmOperation operation) {
		OperationBodyComputationState state = new OperationBodyComputationState(resolvedTypes, featureScopeSession, operation, this);
		state.computeTypes();
		computeAnnotationTypes(resolvedTypes, featureScopeSession, operation);
	}
	
	protected void computeAnnotationTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmAnnotationTarget annotable) {
		for(JvmAnnotationReference annotation: annotable.getAnnotations()) {
			for(JvmAnnotationValue value: annotation.getValues()) {
				if (value instanceof JvmCustomAnnotationValue) {
					JvmCustomAnnotationValue custom = (JvmCustomAnnotationValue) value;
					for(Object object: custom.getValues()) {
						if (object instanceof XExpression) {
							AnnotationValueTypeComputationState state = new AnnotationValueTypeComputationState(resolvedTypes, featureScopeSession, value, (XExpression) object, this);
							state.computeTypes();
						}
					}
				} else if (value instanceof JvmAnnotationAnnotationValue) {
					computeAnnotationTypes(resolvedTypes, featureScopeSession, (JvmAnnotationAnnotationValue) value);
				}
			}
		}
	}
	
	protected void _computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, JvmDeclaredType type) {
		StackedResolvedTypes childResolvedTypes = resolvedTypes.pushTypes();
		JvmTypeReference superType = getExtendedClass(type);
		IFeatureScopeSession childSession = addThisAndSuper(featureScopeSession, type, superType);
		if (superType != null) {
			LightweightTypeReference lightweightSuperType = resolvedTypes.getConverter().toLightweightReference(superType);
			childResolvedTypes.reassignType(superType.getType(), lightweightSuperType);
			/* 
			 * We use reassignType to make sure that the following works:
			 *
			 * StringList extends AbstractList<String> {
			 *   NestedIntList extends AbstractList<Integer> {
			 *   }
			 *   SubType extends StringList {}
			 * }
			 */
		}
		JvmParameterizedTypeReference thisType = getServices().getTypeReferences().createTypeRef(type);
		LightweightTypeReference lightweightThisType = resolvedTypes.getConverter().toLightweightReference(thisType);
		childResolvedTypes.reassignType(type, lightweightThisType);
		computeMemberTypes(childResolvedTypes, childSession, type);
		computeAnnotationTypes(childResolvedTypes, featureScopeSession, type);
		childResolvedTypes.mergeIntoParent();
	}

	protected void computeMemberTypes(StackedResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmDeclaredType type) {
		List<JvmMember> members = type.getMembers();
		for(int i = 0; i < members.size(); i++) {
			computeTypes(resolvedTypes, featureScopeSession, members.get(i));
		}
	}
	
	protected IFeatureScopeSession addThisAndSuper(IFeatureScopeSession session, JvmDeclaredType type) {
		JvmTypeReference superType = getExtendedClass(type);
		return addThisAndSuper(session, type, superType);
	}

	protected IFeatureScopeSession addThisAndSuper(IFeatureScopeSession session, JvmDeclaredType thisType,
			@Nullable JvmTypeReference superType) {
		IFeatureScopeSession childSession;
		if (superType != null) {
			ImmutableMap.Builder<QualifiedName, JvmIdentifiableElement> builder = ImmutableMap.builder();
			builder.put(IFeatureNames.THIS, thisType);
			builder.put(IFeatureNames.SUPER, superType.getType());
			childSession = session.addLocalElements(builder.build());
		} else {
			childSession = session.addLocalElement(IFeatureNames.THIS, thisType);
		}
		return childSession;
	}
	
	@Nullable
	public JvmTypeReference getExtendedClass(JvmDeclaredType type) {
		for(JvmTypeReference candidate: type.getSuperTypes()) {
			if (candidate.getType() instanceof JvmGenericType && !((JvmGenericType) candidate.getType()).isInterface())
				return candidate;
		}
		return null;
	}

	protected void processResult(@SuppressWarnings("unused") ResolvedTypes resolvedTypes) {
		// TODO keep the result available for subsequent linking requests et al
	}
	
	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return logicalContainerProvider;
	}
	
}
