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
package org.eclipse.wst.server.core;
/**
 * An abstract port on a server.
 * 
 * @since 1.0
 */
public interface IServerPort {
	/**
	 * Return an optional internal id used to identify this port.
	 * 
	 * @return an internal id
	 */
	public String getId();

	/**
	 * Return the name of the port.
	 * 
	 * @return the name of the port
	 */
	public String getName();

	/**
	 * Return the actual port number.
	 * 
	 * @return the port number
	 */
	public int getPort();

	/**
	 * Returns the protocol, e.g. HTTP of this port. Returns null
	 * if the protocol is unknown.
	 * 
	 * @return the procotol
	 */
	public String getProtocol();

	/**
	 * Returns the content types that this port would normally serve, or null
	 * if the content is unknown.
	 * 
	 * @return a possibly empty array of content types
	 */
	public String[] getContentTypes();

	/**
	 * Returns true if this port is an "advanced" port and should not be shown
	 * to novice users.
	 * 
	 * @return <code>true</code> if the port is advanced, or <code>false</code>
	 *    otherwise
	 */
	public boolean isAdvanced();
}