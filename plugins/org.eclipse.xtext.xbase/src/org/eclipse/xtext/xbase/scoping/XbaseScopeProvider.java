/*
 * generated by Xtext
 */
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.Function;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class XbaseScopeProvider extends AbstractDeclarativeScopeProvider {
	
	protected IScope scope_Type(Function function, EReference reference) {
		if (function.getTypeParams().isEmpty())
			return delegateGetScope(function, reference);
		return Scopes.scopeFor(function.getTypeParams(), delegateGetScope(function, reference));
	}
	
	
	/**
	 * scoping for simple feature
	 * 
	 */
}
