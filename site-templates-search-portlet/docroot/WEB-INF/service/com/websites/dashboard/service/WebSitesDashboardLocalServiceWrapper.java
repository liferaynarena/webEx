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

package com.websites.dashboard.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WebSitesDashboardLocalService}.
 *
 * @author liferay
 * @see WebSitesDashboardLocalService
 * @generated
 */
public class WebSitesDashboardLocalServiceWrapper
	implements WebSitesDashboardLocalService,
		ServiceWrapper<WebSitesDashboardLocalService> {
	public WebSitesDashboardLocalServiceWrapper(
		WebSitesDashboardLocalService webSitesDashboardLocalService) {
		_webSitesDashboardLocalService = webSitesDashboardLocalService;
	}

	/**
	* Adds the web sites dashboard to the database. Also notifies the appropriate model listeners.
	*
	* @param webSitesDashboard the web sites dashboard
	* @return the web sites dashboard that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.websites.dashboard.model.WebSitesDashboard addWebSitesDashboard(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.addWebSitesDashboard(webSitesDashboard);
	}

	/**
	* Creates a new web sites dashboard with the primary key. Does not add the web sites dashboard to the database.
	*
	* @param webId the primary key for the new web sites dashboard
	* @return the new web sites dashboard
	*/
	@Override
	public com.websites.dashboard.model.WebSitesDashboard createWebSitesDashboard(
		long webId) {
		return _webSitesDashboardLocalService.createWebSitesDashboard(webId);
	}

	/**
	* Deletes the web sites dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webId the primary key of the web sites dashboard
	* @return the web sites dashboard that was removed
	* @throws PortalException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.websites.dashboard.model.WebSitesDashboard deleteWebSitesDashboard(
		long webId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.deleteWebSitesDashboard(webId);
	}

	/**
	* Deletes the web sites dashboard from the database. Also notifies the appropriate model listeners.
	*
	* @param webSitesDashboard the web sites dashboard
	* @return the web sites dashboard that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.websites.dashboard.model.WebSitesDashboard deleteWebSitesDashboard(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.deleteWebSitesDashboard(webSitesDashboard);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _webSitesDashboardLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.websites.dashboard.model.WebSitesDashboard fetchWebSitesDashboard(
		long webId) throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.fetchWebSitesDashboard(webId);
	}

	/**
	* Returns the web sites dashboard with the primary key.
	*
	* @param webId the primary key of the web sites dashboard
	* @return the web sites dashboard
	* @throws PortalException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.websites.dashboard.model.WebSitesDashboard getWebSitesDashboard(
		long webId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.getWebSitesDashboard(webId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the web sites dashboards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of web sites dashboards
	* @param end the upper bound of the range of web sites dashboards (not inclusive)
	* @return the range of web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.websites.dashboard.model.WebSitesDashboard> getWebSitesDashboards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.getWebSitesDashboards(start, end);
	}

	/**
	* Returns the number of web sites dashboards.
	*
	* @return the number of web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWebSitesDashboardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.getWebSitesDashboardsCount();
	}

	/**
	* Updates the web sites dashboard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param webSitesDashboard the web sites dashboard
	* @return the web sites dashboard that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.websites.dashboard.model.WebSitesDashboard updateWebSitesDashboard(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboardLocalService.updateWebSitesDashboard(webSitesDashboard);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _webSitesDashboardLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_webSitesDashboardLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _webSitesDashboardLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WebSitesDashboardLocalService getWrappedWebSitesDashboardLocalService() {
		return _webSitesDashboardLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWebSitesDashboardLocalService(
		WebSitesDashboardLocalService webSitesDashboardLocalService) {
		_webSitesDashboardLocalService = webSitesDashboardLocalService;
	}

	@Override
	public WebSitesDashboardLocalService getWrappedService() {
		return _webSitesDashboardLocalService;
	}

	@Override
	public void setWrappedService(
		WebSitesDashboardLocalService webSitesDashboardLocalService) {
		_webSitesDashboardLocalService = webSitesDashboardLocalService;
	}

	private WebSitesDashboardLocalService _webSitesDashboardLocalService;
}