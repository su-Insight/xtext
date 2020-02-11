/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import com.google.inject.Inject
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * Called to rename an element in the {@link IChangeSerializer} based refactoring.
 * 
 * Clients may extend the {@link DefaultImpl} to customize the behavior or implement 
 * this interface directly.
 * 
 * Changes are usually performed in the The {@link RenameContext} 
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
interface IRenameStrategy2 {

	def void applyRename(RenameContext context)
	
	class DefaultImpl implements IRenameStrategy2 {
		
		@Inject IResourceServiceProvider resourceServiceProvider
		
		def boolean canHandle(RenameChange change) {
			resourceServiceProvider.canHandle(change.targetURI)
		}
		
		override applyRename(RenameContext context) {
			context.changes.filter[ canHandle ].forEach [ change |
				context.addModification(change) [ doRename(change, context) ]
			]
		}
		
		protected def void doRename(EObject target, RenameChange change, RenameContext context) {
			val nameAttribute = getNameEAttribute(target)
			if (nameAttribute !== null)
				target.eSet(nameAttribute, change.newName)
			else
				context.issues.add(Severity.WARNING, 'Element of class ' + target.eClass.name + ' cannot be renamed.')
		}
		
		protected def EAttribute getNameEAttribute(EObject target) {
			target.eClass.EAllAttributes.filter[name == 'name' && EType == EcorePackage.Literals.ESTRING].head
		}
	}
}


