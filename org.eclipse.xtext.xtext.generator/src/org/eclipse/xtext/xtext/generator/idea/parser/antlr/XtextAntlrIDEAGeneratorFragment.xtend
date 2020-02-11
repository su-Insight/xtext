/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.idea.parser.antlr

import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2

@Deprecated
class XtextAntlrIDEAGeneratorFragment extends AbstractAntlrGeneratorFragment2 {


	override protected doGenerate() {
		if (!projectConfig.ideaPlugin.enabled)
			return;
		System.err.println("The support for Idea has been removed!")
	}
}
