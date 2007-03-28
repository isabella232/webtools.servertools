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
package org.eclipse.wst.server.ui.internal.viewers;

import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.ui.internal.ImageResource;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.swt.graphics.Image;
/**
 * Server tree label provider.
 */
public class ServerTreeLabelProvider extends AbstractTreeLabelProvider {
	/**
	 * ServerTreeLabelProvider constructor comment.
	 */
	public ServerTreeLabelProvider() {
		super();
	}

	/**
	 * ServerTreeLabelProvider constructor comment.
	 * 
	 * @param decorator a label decorator, or null if no decorator is required
	 */
	public ServerTreeLabelProvider(ILabelDecorator decorator) {
		super(decorator);
	}

	/**
	 * @see AbstractTreeLabelProvider#getImageImpl(Object)
	 */
	public Image getImageImpl(Object element) {
		IServer server = (IServer) element;
		return ImageResource.getImage(server.getServerType().getId());
	}

	/**
	 * @see AbstractTreeLabelProvider#getTextImpl(Object)
	 */
	public String getTextImpl(Object element) {
		IServer server = (IServer) element;
		return server.getName();
	}
}