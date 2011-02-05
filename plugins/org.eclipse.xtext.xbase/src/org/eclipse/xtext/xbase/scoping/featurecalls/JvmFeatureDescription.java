/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureDescription extends EObjectDescription {

	private final TypeArgumentContext context;
	private final String shadowingString;
	private final boolean isValid;
	private XFeatureCall implicitReceiver;
	private boolean isMemberSyntaxContext = true;
	private String issueCode;

	public JvmFeatureDescription(QualifiedName qualifiedName, JvmFeature element, TypeArgumentContext context,
			String shadowingString, boolean isValid, JvmIdentifiableElement implicitReceiver,
			boolean isMemberSyntaxContext) {
		super(qualifiedName, element, Collections.<String, String> emptyMap());
		this.context = context;
		this.shadowingString = shadowingString;
		this.isValid = isValid;
		this.setImplicitReceiver(implicitReceiver);
		this.isMemberSyntaxContext = isMemberSyntaxContext;
	}

	public JvmFeature getJvmFeature() {
		return (JvmFeature) getEObjectOrProxy();
	}

	public TypeArgumentContext getContext() {
		return context;
	}

	public String getKey() {
		return shadowingString;
	}

	@Override
	public String toString() {
		return shadowingString;
	}

	public boolean isValid() {
		return isValid && isEmpty(issueCode);
	}

	public void setImplicitReceiver(JvmIdentifiableElement implicitReceiver) {
		if (implicitReceiver == null) {
			this.implicitReceiver = null;
		} else {
			XFeatureCall call = XbaseFactory.eINSTANCE.createXFeatureCall();
			call.setFeature(implicitReceiver);
			this.implicitReceiver = call;
		}
	}

	public XFeatureCall getImplicitReceiver() {
		return implicitReceiver;
	}

	public boolean isMemberSyntaxContext() {
		return isMemberSyntaxContext;
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public String getIssueCode() {
		return issueCode;
	}
}
