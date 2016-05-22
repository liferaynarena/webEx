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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.websites.dashboard.NoSuchWebSitesDashboardException;
import com.websites.dashboard.model.WebSitesDashboard;
import com.websites.dashboard.model.impl.WebSitesDashboardImpl;
import com.websites.dashboard.model.impl.WebSitesDashboardModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the web sites dashboard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see WebSitesDashboardPersistence
 * @see WebSitesDashboardUtil
 * @generated
 */
public class WebSitesDashboardPersistenceImpl extends BasePersistenceImpl<WebSitesDashboard>
	implements WebSitesDashboardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WebSitesDashboardUtil} to access the web sites dashboard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WebSitesDashboardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED,
			WebSitesDashboardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED,
			WebSitesDashboardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPIREDATE =
		new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED,
			WebSitesDashboardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExpireDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIREDATE =
		new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED,
			WebSitesDashboardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExpireDate",
			new String[] { Date.class.getName() },
			WebSitesDashboardModelImpl.EXPIREDATE_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.USERID_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.ACTIVE_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EXPIREDATE = new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExpireDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the web sites dashboards where expireDate = &#63;.
	 *
	 * @param expireDate the expire date
	 * @return the matching web sites dashboards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebSitesDashboard> findByExpireDate(Date expireDate)
		throws SystemException {
		return findByExpireDate(expireDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<WebSitesDashboard> findByExpireDate(Date expireDate, int start,
		int end) throws SystemException {
		return findByExpireDate(expireDate, start, end, null);
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
	@Override
	public List<WebSitesDashboard> findByExpireDate(Date expireDate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIREDATE;
			finderArgs = new Object[] { expireDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXPIREDATE;
			finderArgs = new Object[] { expireDate, start, end, orderByComparator };
		}

		List<WebSitesDashboard> list = (List<WebSitesDashboard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WebSitesDashboard webSitesDashboard : list) {
				if (!Validator.equals(expireDate,
							webSitesDashboard.getExpireDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WEBSITESDASHBOARD_WHERE);

			boolean bindExpireDate = false;

			if (expireDate == null) {
				query.append(_FINDER_COLUMN_EXPIREDATE_EXPIREDATE_1);
			}
			else {
				bindExpireDate = true;

				query.append(_FINDER_COLUMN_EXPIREDATE_EXPIREDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WebSitesDashboardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindExpireDate) {
					qPos.add(CalendarUtil.getTimestamp(expireDate));
				}

				if (!pagination) {
					list = (List<WebSitesDashboard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebSitesDashboard>(list);
				}
				else {
					list = (List<WebSitesDashboard>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public WebSitesDashboard findByExpireDate_First(Date expireDate,
		OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = fetchByExpireDate_First(expireDate,
				orderByComparator);

		if (webSitesDashboard != null) {
			return webSitesDashboard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("expireDate=");
		msg.append(expireDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebSitesDashboardException(msg.toString());
	}

	/**
	 * Returns the first web sites dashboard in the ordered set where expireDate = &#63;.
	 *
	 * @param expireDate the expire date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard fetchByExpireDate_First(Date expireDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<WebSitesDashboard> list = findByExpireDate(expireDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WebSitesDashboard findByExpireDate_Last(Date expireDate,
		OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = fetchByExpireDate_Last(expireDate,
				orderByComparator);

		if (webSitesDashboard != null) {
			return webSitesDashboard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("expireDate=");
		msg.append(expireDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebSitesDashboardException(msg.toString());
	}

	/**
	 * Returns the last web sites dashboard in the ordered set where expireDate = &#63;.
	 *
	 * @param expireDate the expire date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard fetchByExpireDate_Last(Date expireDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByExpireDate(expireDate);

		if (count == 0) {
			return null;
		}

		List<WebSitesDashboard> list = findByExpireDate(expireDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WebSitesDashboard[] findByExpireDate_PrevAndNext(long webId,
		Date expireDate, OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = findByPrimaryKey(webId);

		Session session = null;

		try {
			session = openSession();

			WebSitesDashboard[] array = new WebSitesDashboardImpl[3];

			array[0] = getByExpireDate_PrevAndNext(session, webSitesDashboard,
					expireDate, orderByComparator, true);

			array[1] = webSitesDashboard;

			array[2] = getByExpireDate_PrevAndNext(session, webSitesDashboard,
					expireDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WebSitesDashboard getByExpireDate_PrevAndNext(Session session,
		WebSitesDashboard webSitesDashboard, Date expireDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBSITESDASHBOARD_WHERE);

		boolean bindExpireDate = false;

		if (expireDate == null) {
			query.append(_FINDER_COLUMN_EXPIREDATE_EXPIREDATE_1);
		}
		else {
			bindExpireDate = true;

			query.append(_FINDER_COLUMN_EXPIREDATE_EXPIREDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WebSitesDashboardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindExpireDate) {
			qPos.add(CalendarUtil.getTimestamp(expireDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(webSitesDashboard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WebSitesDashboard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the web sites dashboards where expireDate = &#63; from the database.
	 *
	 * @param expireDate the expire date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByExpireDate(Date expireDate) throws SystemException {
		for (WebSitesDashboard webSitesDashboard : findByExpireDate(
				expireDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(webSitesDashboard);
		}
	}

	/**
	 * Returns the number of web sites dashboards where expireDate = &#63;.
	 *
	 * @param expireDate the expire date
	 * @return the number of matching web sites dashboards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByExpireDate(Date expireDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EXPIREDATE;

		Object[] finderArgs = new Object[] { expireDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBSITESDASHBOARD_WHERE);

			boolean bindExpireDate = false;

			if (expireDate == null) {
				query.append(_FINDER_COLUMN_EXPIREDATE_EXPIREDATE_1);
			}
			else {
				bindExpireDate = true;

				query.append(_FINDER_COLUMN_EXPIREDATE_EXPIREDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindExpireDate) {
					qPos.add(CalendarUtil.getTimestamp(expireDate));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EXPIREDATE_EXPIREDATE_1 = "webSitesDashboard.expireDate IS NULL";
	private static final String _FINDER_COLUMN_EXPIREDATE_EXPIREDATE_2 = "webSitesDashboard.expireDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE = new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED,
			WebSitesDashboardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE =
		new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED,
			WebSitesDashboardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActive",
			new String[] { Boolean.class.getName() },
			WebSitesDashboardModelImpl.ACTIVE_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.EXPIREDATE_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.USERID_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the web sites dashboards where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching web sites dashboards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebSitesDashboard> findByActive(boolean active)
		throws SystemException {
		return findByActive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<WebSitesDashboard> findByActive(boolean active, int start,
		int end) throws SystemException {
		return findByActive(active, start, end, null);
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
	@Override
	public List<WebSitesDashboard> findByActive(boolean active, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVE;
			finderArgs = new Object[] { active, start, end, orderByComparator };
		}

		List<WebSitesDashboard> list = (List<WebSitesDashboard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WebSitesDashboard webSitesDashboard : list) {
				if ((active != webSitesDashboard.getActive())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WEBSITESDASHBOARD_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WebSitesDashboardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				if (!pagination) {
					list = (List<WebSitesDashboard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebSitesDashboard>(list);
				}
				else {
					list = (List<WebSitesDashboard>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public WebSitesDashboard findByActive_First(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = fetchByActive_First(active,
				orderByComparator);

		if (webSitesDashboard != null) {
			return webSitesDashboard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebSitesDashboardException(msg.toString());
	}

	/**
	 * Returns the first web sites dashboard in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard fetchByActive_First(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<WebSitesDashboard> list = findByActive(active, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WebSitesDashboard findByActive_Last(boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = fetchByActive_Last(active,
				orderByComparator);

		if (webSitesDashboard != null) {
			return webSitesDashboard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebSitesDashboardException(msg.toString());
	}

	/**
	 * Returns the last web sites dashboard in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard fetchByActive_Last(boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActive(active);

		if (count == 0) {
			return null;
		}

		List<WebSitesDashboard> list = findByActive(active, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WebSitesDashboard[] findByActive_PrevAndNext(long webId,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = findByPrimaryKey(webId);

		Session session = null;

		try {
			session = openSession();

			WebSitesDashboard[] array = new WebSitesDashboardImpl[3];

			array[0] = getByActive_PrevAndNext(session, webSitesDashboard,
					active, orderByComparator, true);

			array[1] = webSitesDashboard;

			array[2] = getByActive_PrevAndNext(session, webSitesDashboard,
					active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WebSitesDashboard getByActive_PrevAndNext(Session session,
		WebSitesDashboard webSitesDashboard, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBSITESDASHBOARD_WHERE);

		query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WebSitesDashboardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(webSitesDashboard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WebSitesDashboard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the web sites dashboards where active = &#63; from the database.
	 *
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActive(boolean active) throws SystemException {
		for (WebSitesDashboard webSitesDashboard : findByActive(active,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(webSitesDashboard);
		}
	}

	/**
	 * Returns the number of web sites dashboards where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching web sites dashboards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByActive(boolean active) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVE;

		Object[] finderArgs = new Object[] { active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBSITESDASHBOARD_WHERE);

			query.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 = "webSitesDashboard.active = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED,
			WebSitesDashboardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED,
			WebSitesDashboardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			WebSitesDashboardModelImpl.GROUPID_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.EXPIREDATE_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.USERID_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.ACTIVE_COLUMN_BITMASK |
			WebSitesDashboardModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the web sites dashboards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching web sites dashboards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebSitesDashboard> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<WebSitesDashboard> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<WebSitesDashboard> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<WebSitesDashboard> list = (List<WebSitesDashboard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WebSitesDashboard webSitesDashboard : list) {
				if ((groupId != webSitesDashboard.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WEBSITESDASHBOARD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WebSitesDashboardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<WebSitesDashboard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebSitesDashboard>(list);
				}
				else {
					list = (List<WebSitesDashboard>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public WebSitesDashboard findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = fetchByGroupId_First(groupId,
				orderByComparator);

		if (webSitesDashboard != null) {
			return webSitesDashboard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebSitesDashboardException(msg.toString());
	}

	/**
	 * Returns the first web sites dashboard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WebSitesDashboard> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WebSitesDashboard findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (webSitesDashboard != null) {
			return webSitesDashboard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWebSitesDashboardException(msg.toString());
	}

	/**
	 * Returns the last web sites dashboard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching web sites dashboard, or <code>null</code> if a matching web sites dashboard could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<WebSitesDashboard> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WebSitesDashboard[] findByGroupId_PrevAndNext(long webId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = findByPrimaryKey(webId);

		Session session = null;

		try {
			session = openSession();

			WebSitesDashboard[] array = new WebSitesDashboardImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, webSitesDashboard,
					groupId, orderByComparator, true);

			array[1] = webSitesDashboard;

			array[2] = getByGroupId_PrevAndNext(session, webSitesDashboard,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WebSitesDashboard getByGroupId_PrevAndNext(Session session,
		WebSitesDashboard webSitesDashboard, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WEBSITESDASHBOARD_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WebSitesDashboardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(webSitesDashboard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WebSitesDashboard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the web sites dashboards where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (WebSitesDashboard webSitesDashboard : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(webSitesDashboard);
		}
	}

	/**
	 * Returns the number of web sites dashboards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching web sites dashboards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WEBSITESDASHBOARD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "webSitesDashboard.groupId = ?";

	public WebSitesDashboardPersistenceImpl() {
		setModelClass(WebSitesDashboard.class);
	}

	/**
	 * Caches the web sites dashboard in the entity cache if it is enabled.
	 *
	 * @param webSitesDashboard the web sites dashboard
	 */
	@Override
	public void cacheResult(WebSitesDashboard webSitesDashboard) {
		EntityCacheUtil.putResult(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardImpl.class, webSitesDashboard.getPrimaryKey(),
			webSitesDashboard);

		webSitesDashboard.resetOriginalValues();
	}

	/**
	 * Caches the web sites dashboards in the entity cache if it is enabled.
	 *
	 * @param webSitesDashboards the web sites dashboards
	 */
	@Override
	public void cacheResult(List<WebSitesDashboard> webSitesDashboards) {
		for (WebSitesDashboard webSitesDashboard : webSitesDashboards) {
			if (EntityCacheUtil.getResult(
						WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
						WebSitesDashboardImpl.class,
						webSitesDashboard.getPrimaryKey()) == null) {
				cacheResult(webSitesDashboard);
			}
			else {
				webSitesDashboard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all web sites dashboards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WebSitesDashboardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WebSitesDashboardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the web sites dashboard.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WebSitesDashboard webSitesDashboard) {
		EntityCacheUtil.removeResult(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardImpl.class, webSitesDashboard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WebSitesDashboard> webSitesDashboards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WebSitesDashboard webSitesDashboard : webSitesDashboards) {
			EntityCacheUtil.removeResult(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
				WebSitesDashboardImpl.class, webSitesDashboard.getPrimaryKey());
		}
	}

	/**
	 * Creates a new web sites dashboard with the primary key. Does not add the web sites dashboard to the database.
	 *
	 * @param webId the primary key for the new web sites dashboard
	 * @return the new web sites dashboard
	 */
	@Override
	public WebSitesDashboard create(long webId) {
		WebSitesDashboard webSitesDashboard = new WebSitesDashboardImpl();

		webSitesDashboard.setNew(true);
		webSitesDashboard.setPrimaryKey(webId);

		return webSitesDashboard;
	}

	/**
	 * Removes the web sites dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param webId the primary key of the web sites dashboard
	 * @return the web sites dashboard that was removed
	 * @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard remove(long webId)
		throws NoSuchWebSitesDashboardException, SystemException {
		return remove((Serializable)webId);
	}

	/**
	 * Removes the web sites dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the web sites dashboard
	 * @return the web sites dashboard that was removed
	 * @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard remove(Serializable primaryKey)
		throws NoSuchWebSitesDashboardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WebSitesDashboard webSitesDashboard = (WebSitesDashboard)session.get(WebSitesDashboardImpl.class,
					primaryKey);

			if (webSitesDashboard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWebSitesDashboardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(webSitesDashboard);
		}
		catch (NoSuchWebSitesDashboardException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected WebSitesDashboard removeImpl(WebSitesDashboard webSitesDashboard)
		throws SystemException {
		webSitesDashboard = toUnwrappedModel(webSitesDashboard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(webSitesDashboard)) {
				webSitesDashboard = (WebSitesDashboard)session.get(WebSitesDashboardImpl.class,
						webSitesDashboard.getPrimaryKeyObj());
			}

			if (webSitesDashboard != null) {
				session.delete(webSitesDashboard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (webSitesDashboard != null) {
			clearCache(webSitesDashboard);
		}

		return webSitesDashboard;
	}

	@Override
	public WebSitesDashboard updateImpl(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard)
		throws SystemException {
		webSitesDashboard = toUnwrappedModel(webSitesDashboard);

		boolean isNew = webSitesDashboard.isNew();

		WebSitesDashboardModelImpl webSitesDashboardModelImpl = (WebSitesDashboardModelImpl)webSitesDashboard;

		Session session = null;

		try {
			session = openSession();

			if (webSitesDashboard.isNew()) {
				session.save(webSitesDashboard);

				webSitesDashboard.setNew(false);
			}
			else {
				session.merge(webSitesDashboard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WebSitesDashboardModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((webSitesDashboardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIREDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						webSitesDashboardModelImpl.getOriginalExpireDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXPIREDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIREDATE,
					args);

				args = new Object[] { webSitesDashboardModelImpl.getExpireDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXPIREDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXPIREDATE,
					args);
			}

			if ((webSitesDashboardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						webSitesDashboardModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);

				args = new Object[] { webSitesDashboardModelImpl.getActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVE,
					args);
			}

			if ((webSitesDashboardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						webSitesDashboardModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { webSitesDashboardModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
			WebSitesDashboardImpl.class, webSitesDashboard.getPrimaryKey(),
			webSitesDashboard);

		return webSitesDashboard;
	}

	protected WebSitesDashboard toUnwrappedModel(
		WebSitesDashboard webSitesDashboard) {
		if (webSitesDashboard instanceof WebSitesDashboardImpl) {
			return webSitesDashboard;
		}

		WebSitesDashboardImpl webSitesDashboardImpl = new WebSitesDashboardImpl();

		webSitesDashboardImpl.setNew(webSitesDashboard.isNew());
		webSitesDashboardImpl.setPrimaryKey(webSitesDashboard.getPrimaryKey());

		webSitesDashboardImpl.setWebId(webSitesDashboard.getWebId());
		webSitesDashboardImpl.setGroupId(webSitesDashboard.getGroupId());
		webSitesDashboardImpl.setCompanyId(webSitesDashboard.getCompanyId());
		webSitesDashboardImpl.setUserId(webSitesDashboard.getUserId());
		webSitesDashboardImpl.setUserName(webSitesDashboard.getUserName());
		webSitesDashboardImpl.setCreateDate(webSitesDashboard.getCreateDate());
		webSitesDashboardImpl.setExpireDate(webSitesDashboard.getExpireDate());
		webSitesDashboardImpl.setRenewDate(webSitesDashboard.getRenewDate());
		webSitesDashboardImpl.setPrice(webSitesDashboard.getPrice());
		webSitesDashboardImpl.setActive(webSitesDashboard.isActive());
		webSitesDashboardImpl.setTransitionId(webSitesDashboard.getTransitionId());
		webSitesDashboardImpl.setStatus(webSitesDashboard.getStatus());
		webSitesDashboardImpl.setComments(webSitesDashboard.getComments());

		return webSitesDashboardImpl;
	}

	/**
	 * Returns the web sites dashboard with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the web sites dashboard
	 * @return the web sites dashboard
	 * @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWebSitesDashboardException, SystemException {
		WebSitesDashboard webSitesDashboard = fetchByPrimaryKey(primaryKey);

		if (webSitesDashboard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWebSitesDashboardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return webSitesDashboard;
	}

	/**
	 * Returns the web sites dashboard with the primary key or throws a {@link com.websites.dashboard.NoSuchWebSitesDashboardException} if it could not be found.
	 *
	 * @param webId the primary key of the web sites dashboard
	 * @return the web sites dashboard
	 * @throws com.websites.dashboard.NoSuchWebSitesDashboardException if a web sites dashboard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard findByPrimaryKey(long webId)
		throws NoSuchWebSitesDashboardException, SystemException {
		return findByPrimaryKey((Serializable)webId);
	}

	/**
	 * Returns the web sites dashboard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the web sites dashboard
	 * @return the web sites dashboard, or <code>null</code> if a web sites dashboard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WebSitesDashboard webSitesDashboard = (WebSitesDashboard)EntityCacheUtil.getResult(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
				WebSitesDashboardImpl.class, primaryKey);

		if (webSitesDashboard == _nullWebSitesDashboard) {
			return null;
		}

		if (webSitesDashboard == null) {
			Session session = null;

			try {
				session = openSession();

				webSitesDashboard = (WebSitesDashboard)session.get(WebSitesDashboardImpl.class,
						primaryKey);

				if (webSitesDashboard != null) {
					cacheResult(webSitesDashboard);
				}
				else {
					EntityCacheUtil.putResult(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
						WebSitesDashboardImpl.class, primaryKey,
						_nullWebSitesDashboard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WebSitesDashboardModelImpl.ENTITY_CACHE_ENABLED,
					WebSitesDashboardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return webSitesDashboard;
	}

	/**
	 * Returns the web sites dashboard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param webId the primary key of the web sites dashboard
	 * @return the web sites dashboard, or <code>null</code> if a web sites dashboard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WebSitesDashboard fetchByPrimaryKey(long webId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)webId);
	}

	/**
	 * Returns all the web sites dashboards.
	 *
	 * @return the web sites dashboards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WebSitesDashboard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<WebSitesDashboard> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<WebSitesDashboard> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<WebSitesDashboard> list = (List<WebSitesDashboard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WEBSITESDASHBOARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WEBSITESDASHBOARD;

				if (pagination) {
					sql = sql.concat(WebSitesDashboardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WebSitesDashboard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WebSitesDashboard>(list);
				}
				else {
					list = (List<WebSitesDashboard>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the web sites dashboards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WebSitesDashboard webSitesDashboard : findAll()) {
			remove(webSitesDashboard);
		}
	}

	/**
	 * Returns the number of web sites dashboards.
	 *
	 * @return the number of web sites dashboards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WEBSITESDASHBOARD);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the web sites dashboard persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.websites.dashboard.model.WebSitesDashboard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WebSitesDashboard>> listenersList = new ArrayList<ModelListener<WebSitesDashboard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WebSitesDashboard>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WebSitesDashboardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WEBSITESDASHBOARD = "SELECT webSitesDashboard FROM WebSitesDashboard webSitesDashboard";
	private static final String _SQL_SELECT_WEBSITESDASHBOARD_WHERE = "SELECT webSitesDashboard FROM WebSitesDashboard webSitesDashboard WHERE ";
	private static final String _SQL_COUNT_WEBSITESDASHBOARD = "SELECT COUNT(webSitesDashboard) FROM WebSitesDashboard webSitesDashboard";
	private static final String _SQL_COUNT_WEBSITESDASHBOARD_WHERE = "SELECT COUNT(webSitesDashboard) FROM WebSitesDashboard webSitesDashboard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "webSitesDashboard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WebSitesDashboard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WebSitesDashboard exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WebSitesDashboardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static WebSitesDashboard _nullWebSitesDashboard = new WebSitesDashboardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WebSitesDashboard> toCacheModel() {
				return _nullWebSitesDashboardCacheModel;
			}
		};

	private static CacheModel<WebSitesDashboard> _nullWebSitesDashboardCacheModel =
		new CacheModel<WebSitesDashboard>() {
			@Override
			public WebSitesDashboard toEntityModel() {
				return _nullWebSitesDashboard;
			}
		};
}