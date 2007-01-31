/**********************************************************************
 * Copyright (c) 2005, 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    IBM Corporation - Initial API and implementation
 **********************************************************************/
package org.eclipse.jst.server.tomcat.core.internal;
/**
 * 
 */
public interface ITomcatServerWorkingCopy extends ITomcatServer {
	/**
	 * The default deployment directory.  Avoid "webapps" due to
	 * side effects.
	 */
	public static final String DEFAULT_DEPLOYDIR = "wtpwebapps";

	/**
	 * The deployment directory used by default in prior versions.
	 */
	public static final String LEGACY_DEPLOYDIR = "webapps";

	/**
	 * Sets this server to test environment mode.
	 * 
	 * @param b boolean
	 */
	public void setTestEnvironment(boolean b);

	/**
	 * Set the deployment directory for the server.  May be absolute
	 * or relative to runtime base directory.
	 * 
	 * @param deployDir deployment directory for the server
	 */
	public void setDeployDirectory(String deployDir);
}