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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for WebSitesDashboard. This utility wraps
 * {@link com.websites.dashboard.service.impl.WebSitesDashboardLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author liferay
 * @see WebSitesDashboardLocalService
 * @see com.websites.dashboard.service.base.WebSitesDashboardLocalServiceBaseImpl
 * @see com.websites.dashboard.service.impl.WebSitesDashboardLocalServiceImpl
 * @generated
 */
public class WebSitesDashboardLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.websites.dashboard.service.impl.WebSitesDashboardLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the web sites dashboard to the database. Also notifies the appropriate model listeners.
	*
	* @param webSitesDashboard the web sites dashboard
	* @return the web sites dashboard that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard addWebSitesDashboard(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWebSitesDashboard(webSitesDashboard);
	}

	/**
	* Creates a new web sites dashboard with the primary key. Does not add the web sites dashboard to the database.
	*
	* @param webId the primary key for the new web sites dashboard
	* @return the new web sites dashboard
	*/
	public static com.websites.dashboard.model.WebSitesDashboard createWebSitesDashboard(
		long webId) {
		return getService().createWebSitesDashboard(webId);
	}

	/**
	* Deletes the web sites dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webId the primary key of the web sites dashboard
	* @return the web sites dashboard that was removed
	* @throws PortalException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard deleteWebSitesDashboard(
		long webId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWebSitesDashboard(webId);
	}

	/**
	* Deletes the web sites dashboard from the database. Also notifies the appropriate model listeners.
	*
	* @param webSitesDashboard the web sites dashboard
	* @return the web sites dashboard that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard deleteWebSitesDashboard(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWebSitesDashboard(webSitesDashboard);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.websites.dashboard.model.WebSitesDashboard fetchWebSitesDashboard(
		long webId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWebSitesDashboard(webId);
	}

	/**
	* Returns the web sites dashboard with the primary key.
	*
	* @param webId the primary key of the web sites dashboard
	* @return the web sites dashboard
	* @throws PortalException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard getWebSitesDashboard(
		long webId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWebSitesDashboard(webId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> getWebSitesDashboards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWebSitesDashboards(start, end);
	}

	/**
	* Returns the number of web sites dashboards.
	*
	* @return the number of web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static int getWebSitesDashboardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWebSitesDashboardsCount();
	}

	/**
	* Updates the web sites dashboard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param webSitesDashboard the web sites dashboard
	* @return the web sites dashboard that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard updateWebSitesDashboard(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWebSitesDashboard(webSitesDashboard);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static WebSitesDashboardLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WebSitesDashboardLocalService.class.getName());

			if (invokableLocalService instanceof WebSitesDashboardLocalService) {
				_service = (WebSitesDashboardLocalService)invokableLocalService;
			}
			else {
				_service = new WebSitesDashboardLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WebSitesDashboardLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WebSitesDashboardLocalService service) {
	}

	private static WebSitesDashboardLocalService _service;
}