/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.websites.dashboard.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.websites.dashboard.model.WebSitesDashboard;
import com.websites.dashboard.service.WebSitesDashboardLocalServiceUtil;

/**
 * @author liferay
 * @generated
 */
public abstract class WebSitesDashboardActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public WebSitesDashboardActionableDynamicQuery() throws SystemException {
		setBaseLocalService(WebSitesDashboardLocalServiceUtil.getService());
		setClass(WebSitesDashboard.class);

		setClassLoader(com.websites.dashboard.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("webId");
	}
}