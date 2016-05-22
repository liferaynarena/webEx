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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.websites.dashboard.model.WebSitesDashboard;

import java.util.List;

/**
 * The persistence utility for the web sites dashboard service. This utility wraps {@link WebSitesDashboardPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see WebSitesDashboardPersistence
 * @see WebSitesDashboardPersistenceImpl
 * @generated
 */
public class WebSitesDashboardUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WebSitesDashboard webSitesDashboard) {
		getPersistence().clearCache(webSitesDashboard);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WebSitesDashboard> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WebSitesDashboard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WebSitesDashboard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WebSitesDashboard update(WebSitesDashboard webSitesDashboard)
		throws SystemException {
		return getPersistence().update(webSitesDashboard);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WebSitesDashboard update(
		WebSitesDashboard webSitesDashboard, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(webSitesDashboard, serviceContext);
	}

	/**
	* Returns all the web sites dashboards where expireDate = &#63;.
	*
	* @param expireDate the expire date
	* @return the matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByExpireDate(
		java.util.Date expireDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExpireDate(expireDate);
	}

	/**
	* Returns a range of all the web sites dashboards where expireDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param expireDate the expire date
	* @param start the lower bound of the range of web sites dashboards
	* @param end the upper bound of the range of web sites dashboards (not inclusive)
	* @return the range of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByExpireDate(
		java.util.Date expireDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExpireDate(expireDate, start, end);
	}

	/**
	* Returns an ordered range of all the web sites dashboards where expireDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param expireDate the expire date
	* @param start the lower bound of the range of web sites dashboards
	* @param end the upper bound of the range of web sites dashboards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByExpireDate(
		java.util.Date expireDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExpireDate(expireDate, start, end, orderByComparator);
	}

	/**
	* Returns the first web sites dashboard in the ordered set where expireDate = &#63;.
	*
	* @param expireDate the expire date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard findByExpireDate_First(
		java.util.Date expireDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence()
				   .findByExpireDate_First(expireDate, orderByComparator);
	}

	/**
	* Returns the first web sites dashboard in the ordered set where expireDate = &#63;.
	*
	* @param expireDate the expire date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard fetchByExpireDate_First(
		java.util.Date expireDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpireDate_First(expireDate, orderByComparator);
	}

	/**
	* Returns the last web sites dashboard in the ordered set where expireDate = &#63;.
	*
	* @param expireDate the expire date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard findByExpireDate_Last(
		java.util.Date expireDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence()
				   .findByExpireDate_Last(expireDate, orderByComparator);
	}

	/**
	* Returns the last web sites dashboard in the ordered set where expireDate = &#63;.
	*
	* @param expireDate the expire date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard fetchByExpireDate_Last(
		java.util.Date expireDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExpireDate_Last(expireDate, orderByComparator);
	}

	/**
	* Returns the web sites dashboards before and after the current web sites dashboard in the ordered set where expireDate = &#63;.
	*
	* @param webId the primary key of the current web sites dashboard
	* @param expireDate the expire date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard[] findByExpireDate_PrevAndNext(
		long webId, java.util.Date expireDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence()
				   .findByExpireDate_PrevAndNext(webId, expireDate,
			orderByComparator);
	}

	/**
	* Removes all the web sites dashboards where expireDate = &#63; from the database.
	*
	* @param expireDate the expire date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByExpireDate(java.util.Date expireDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByExpireDate(expireDate);
	}

	/**
	* Returns the number of web sites dashboards where expireDate = &#63;.
	*
	* @param expireDate the expire date
	* @return the number of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByExpireDate(java.util.Date expireDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByExpireDate(expireDate);
	}

	/**
	* Returns all the web sites dashboards where active = &#63;.
	*
	* @param active the active
	* @return the matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByActive(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active);
	}

	/**
	* Returns a range of all the web sites dashboards where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of web sites dashboards
	* @param end the upper bound of the range of web sites dashboards (not inclusive)
	* @return the range of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByActive(
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActive(active, start, end);
	}

	/**
	* Returns an ordered range of all the web sites dashboards where active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param start the lower bound of the range of web sites dashboards
	* @param end the upper bound of the range of web sites dashboards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActive(active, start, end, orderByComparator);
	}

	/**
	* Returns the first web sites dashboard in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard findByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence().findByActive_First(active, orderByComparator);
	}

	/**
	* Returns the first web sites dashboard in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard fetchByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByActive_First(active, orderByComparator);
	}

	/**
	* Returns the last web sites dashboard in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard findByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence().findByActive_Last(active, orderByComparator);
	}

	/**
	* Returns the last web sites dashboard in the ordered set where active = &#63;.
	*
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard fetchByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByActive_Last(active, orderByComparator);
	}

	/**
	* Returns the web sites dashboards before and after the current web sites dashboard in the ordered set where active = &#63;.
	*
	* @param webId the primary key of the current web sites dashboard
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard[] findByActive_PrevAndNext(
		long webId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence()
				   .findByActive_PrevAndNext(webId, active, orderByComparator);
	}

	/**
	* Removes all the web sites dashboards where active = &#63; from the database.
	*
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActive(active);
	}

	/**
	* Returns the number of web sites dashboards where active = &#63;.
	*
	* @param active the active
	* @return the number of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActive(boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActive(active);
	}

	/**
	* Returns all the web sites dashboards where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the web sites dashboards where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of web sites dashboards
	* @param end the upper bound of the range of web sites dashboards (not inclusive)
	* @return the range of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the web sites dashboards where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of web sites dashboards
	* @param end the upper bound of the range of web sites dashboards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first web sites dashboard in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first web sites dashboard in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last web sites dashboard in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last web sites dashboard in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the web sites dashboards before and after the current web sites dashboard in the ordered set where groupId = &#63;.
	*
	* @param webId the primary key of the current web sites dashboard
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard[] findByGroupId_PrevAndNext(
		long webId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(webId, groupId, orderByComparator);
	}

	/**
	* Removes all the web sites dashboards where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of web sites dashboards where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Caches the web sites dashboard in the entity cache if it is enabled.
	*
	* @param webSitesDashboard the web sites dashboard
	*/
	public static void cacheResult(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard) {
		getPersistence().cacheResult(webSitesDashboard);
	}

	/**
	* Caches the web sites dashboards in the entity cache if it is enabled.
	*
	* @param webSitesDashboards the web sites dashboards
	*/
	public static void cacheResult(
		java.util.List<com.websites.dashboard.model.WebSitesDashboard> webSitesDashboards) {
		getPersistence().cacheResult(webSitesDashboards);
	}

	/**
	* Creates a new web sites dashboard with the primary key. Does not add the web sites dashboard to the database.
	*
	* @param webId the primary key for the new web sites dashboard
	* @return the new web sites dashboard
	*/
	public static com.websites.dashboard.model.WebSitesDashboard create(
		long webId) {
		return getPersistence().create(webId);
	}

	/**
	* Removes the web sites dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param webId the primary key of the web sites dashboard
	* @return the web sites dashboard that was removed
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard remove(
		long webId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence().remove(webId);
	}

	public static com.websites.dashboard.model.WebSitesDashboard updateImpl(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(webSitesDashboard);
	}

	/**
	* Returns the web sites dashboard with the primary key or throws a {@link com.websites.dashboard.NoSuchWebSitesDashboardException} if it could not be found.
	*
	* @param webId the primary key of the web sites dashboard
	* @return the web sites dashboard
	* @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard findByPrimaryKey(
		long webId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.websites.dashboard.NoSuchWebSitesDashboardException {
		return getPersistence().findByPrimaryKey(webId);
	}

	/**
	* Returns the web sites dashboard with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param webId the primary key of the web sites dashboard
	* @return the web sites dashboard, or <code>null</code> if a web sites dashboard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.websites.dashboard.model.WebSitesDashboard fetchByPrimaryKey(
		long webId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(webId);
	}

	/**
	* Returns all the web sites dashboards.
	*
	* @return the web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the web sites dashboards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.websites.dashboard.model.impl.WebSitesDashboardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of web sites dashboards
	* @param end the upper bound of the range of web sites dashboards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.websites.dashboard.model.WebSitesDashboard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the web sites dashboards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of web sites dashboards.
	*
	* @return the number of web sites dashboards
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WebSitesDashboardPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WebSitesDashboardPersistence)PortletBeanLocatorUtil.locate(com.websites.dashboard.service.ClpSerializer.getServletContextName(),
					WebSitesDashboardPersistence.class.getName());

			ReferenceRegistry.registerReference(WebSitesDashboardUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WebSitesDashboardPersistence persistence) {
	}

	private static WebSitesDashboardPersistence _persistence;
}