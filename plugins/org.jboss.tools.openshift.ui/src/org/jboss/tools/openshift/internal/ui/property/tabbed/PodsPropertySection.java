/*******************************************************************************
 * Copyright (c) 2016 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/

package org.jboss.tools.openshift.internal.ui.property.tabbed;

import org.eclipse.swt.SWT;
import org.jboss.tools.openshift.internal.common.ui.utils.TableViewerBuilder;
import org.jboss.tools.openshift.internal.ui.models.IResourceUIModel;

import com.openshift.restclient.model.IPod;

/**
 * Tabbed property section for displaying Pods.
 *  
 * @author Fred Bricon
 *
 */
public class PodsPropertySection extends OpenShiftResourcePropertySection {

	public PodsPropertySection() {
		super("popup:org.jboss.tools.openshift.ui.properties.tab.PodsTab");
	}

	protected void addColumns(TableViewerBuilder tableViewerBuilder) {
		addNameColumn(tableViewerBuilder);
		tableViewerBuilder.column((IResourceUIModel model) -> {
				IPod pod = (IPod) model.getResource();
				return pod.getStatus();
		}).name("Status").align(SWT.LEFT).weight(1).minWidth(10).buildColumn();
		addCreatedColumn(tableViewerBuilder);
	}
}
