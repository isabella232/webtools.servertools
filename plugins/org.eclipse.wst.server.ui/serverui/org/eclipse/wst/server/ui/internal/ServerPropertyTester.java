/*******************************************************************************
 * Copyright (c) 2003, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.ui.internal;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.internal.ServerPlugin;
/**
 * 
 */
public class ServerPropertyTester extends PropertyTester {
	/* (non-Javadoc)
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (expectedValue instanceof String)
			return checkProperty(receiver, property, (String) expectedValue);
		return checkProperty(receiver, property, null);
	}

	protected static boolean checkProperty(Object target, String property, String value) {
		if ("isRunnable".equals(property)) {
			boolean b = ServerPlugin.hasModuleArtifact(target);
			if (b)
				return true;
			
			/*if (!(receiver instanceof IEditorPart))
				return false;
			
			//	 check if the editor input itself can be run. Otherwise, check if
			// the editor has a file input that can be run
			IEditorPart editor = (IEditorPart) receiver;
			IEditorInput input = editor.getEditorInput();
			
			b = ServerPlugin.hasModuleArtifact(input);
			if (b)
				return true;*/
	
			if (target instanceof IFileEditorInput) {
				IFileEditorInput fei = (IFileEditorInput) target;
				IFile file = fei.getFile();
				b = ServerPlugin.hasModuleArtifact(file);
				if (b)
					return true;
			}
			return false;
		} else if ("serverType".equals(property)) {
			if (!(target instanceof IServer))
				return false;
			
			IServer server = (IServer) target;
			
			String[] typeIds = ServerPlugin.tokenize(value, ",");
			return supportsServerType(server.getServerType().getId(), typeIds);
		}
		return false;
	}
	
	/**
	 * Returns true if the given server type (given by the id) can use this action.
	 *
	 * @return boolean
	 */
	protected static boolean supportsServerType(String id, String[] typeIds) {
		if (id == null || id.length() == 0)
			return false;

		if (typeIds == null)
			return false;
		
		int size = typeIds.length;
		for (int i = 0; i < size; i++) {
			if (typeIds[i].endsWith("*")) {
				if (id.length() >= typeIds[i].length() && id.startsWith(typeIds[i].substring(0, typeIds[i].length() - 1)))
					return true;
			} else if (id.equals(typeIds[i]))
				return true;
		}
		return false;
	}
}