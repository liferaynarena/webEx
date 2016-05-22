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

package com.websites.dashboard.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WebSitesDashboard}.
 * </p>
 *
 * @author liferay
 * @see WebSitesDashboard
 * @generated
 */
public class WebSitesDashboardWrapper implements WebSitesDashboard,
	ModelWrapper<WebSitesDashboard> {
	public WebSitesDashboardWrapper(WebSitesDashboard webSitesDashboard) {
		_webSitesDashboard = webSitesDashboard;
	}

	@Override
	public Class<?> getModelClass() {
		return WebSitesDashboard.class;
	}

	@Override
	public String getModelClassName() {
		return WebSitesDashboard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("webId", getWebId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("expireDate", getExpireDate());
		attributes.put("renewDate", getRenewDate());
		attributes.put("price", getPrice());
		attributes.put("active", getActive());
		attributes.put("transitionId", getTransitionId());
		attributes.put("status", getStatus());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long webId = (Long)attributes.get("webId");

		if (webId != null) {
			setWebId(webId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}

		Date renewDate = (Date)attributes.get("renewDate");

		if (renewDate != null) {
			setRenewDate(renewDate);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String transitionId = (String)attributes.get("transitionId");

		if (transitionId != null) {
			setTransitionId(transitionId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	/**
	* Returns the primary key of this web sites dashboard.
	*
	* @return the primary key of this web sites dashboard
	*/
	@Override
	public long getPrimaryKey() {
		return _webSitesDashboard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this web sites dashboard.
	*
	* @param primaryKey the primary key of this web sites dashboard
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_webSitesDashboard.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the web ID of this web sites dashboard.
	*
	* @return the web ID of this web sites dashboard
	*/
	@Override
	public long getWebId() {
		return _webSitesDashboard.getWebId();
	}

	/**
	* Sets the web ID of this web sites dashboard.
	*
	* @param webId the web ID of this web sites dashboard
	*/
	@Override
	public void setWebId(long webId) {
		_webSitesDashboard.setWebId(webId);
	}

	/**
	* Returns the group ID of this web sites dashboard.
	*
	* @return the group ID of this web sites dashboard
	*/
	@Override
	public long getGroupId() {
		return _webSitesDashboard.getGroupId();
	}

	/**
	* Sets the group ID of this web sites dashboard.
	*
	* @param groupId the group ID of this web sites dashboard
	*/
	@Override
	public void setGroupId(long groupId) {
		_webSitesDashboard.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this web sites dashboard.
	*
	* @return the company ID of this web sites dashboard
	*/
	@Override
	public long getCompanyId() {
		return _webSitesDashboard.getCompanyId();
	}

	/**
	* Sets the company ID of this web sites dashboard.
	*
	* @param companyId the company ID of this web sites dashboard
	*/
	@Override
	public void setCompanyId(long companyId) {
		_webSitesDashboard.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this web sites dashboard.
	*
	* @return the user ID of this web sites dashboard
	*/
	@Override
	public long getUserId() {
		return _webSitesDashboard.getUserId();
	}

	/**
	* Sets the user ID of this web sites dashboard.
	*
	* @param userId the user ID of this web sites dashboard
	*/
	@Override
	public void setUserId(long userId) {
		_webSitesDashboard.setUserId(userId);
	}

	/**
	* Returns the user uuid of this web sites dashboard.
	*
	* @return the user uuid of this web sites dashboard
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSitesDashboard.getUserUuid();
	}

	/**
	* Sets the user uuid of this web sites dashboard.
	*
	* @param userUuid the user uuid of this web sites dashboard
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_webSitesDashboard.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this web sites dashboard.
	*
	* @return the user name of this web sites dashboard
	*/
	@Override
	public java.lang.String getUserName() {
		return _webSitesDashboard.getUserName();
	}

	/**
	* Sets the user name of this web sites dashboard.
	*
	* @param userName the user name of this web sites dashboard
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_webSitesDashboard.setUserName(userName);
	}

	/**
	* Returns the create date of this web sites dashboard.
	*
	* @return the create date of this web sites dashboard
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _webSitesDashboard.getCreateDate();
	}

	/**
	* Sets the create date of this web sites dashboard.
	*
	* @param createDate the create date of this web sites dashboard
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_webSitesDashboard.setCreateDate(createDate);
	}

	/**
	* Returns the expire date of this web sites dashboard.
	*
	* @return the expire date of this web sites dashboard
	*/
	@Override
	public java.util.Date getExpireDate() {
		return _webSitesDashboard.getExpireDate();
	}

	/**
	* Sets the expire date of this web sites dashboard.
	*
	* @param expireDate the expire date of this web sites dashboard
	*/
	@Override
	public void setExpireDate(java.util.Date expireDate) {
		_webSitesDashboard.setExpireDate(expireDate);
	}

	/**
	* Returns the renew date of this web sites dashboard.
	*
	* @return the renew date of this web sites dashboard
	*/
	@Override
	public java.util.Date getRenewDate() {
		return _webSitesDashboard.getRenewDate();
	}

	/**
	* Sets the renew date of this web sites dashboard.
	*
	* @param renewDate the renew date of this web sites dashboard
	*/
	@Override
	public void setRenewDate(java.util.Date renewDate) {
		_webSitesDashboard.setRenewDate(renewDate);
	}

	/**
	* Returns the price of this web sites dashboard.
	*
	* @return the price of this web sites dashboard
	*/
	@Override
	public double getPrice() {
		return _webSitesDashboard.getPrice();
	}

	/**
	* Sets the price of this web sites dashboard.
	*
	* @param price the price of this web sites dashboard
	*/
	@Override
	public void setPrice(double price) {
		_webSitesDashboard.setPrice(price);
	}

	/**
	* Returns the active of this web sites dashboard.
	*
	* @return the active of this web sites dashboard
	*/
	@Override
	public boolean getActive() {
		return _webSitesDashboard.getActive();
	}

	/**
	* Returns <code>true</code> if this web sites dashboard is active.
	*
	* @return <code>true</code> if this web sites dashboard is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _webSitesDashboard.isActive();
	}

	/**
	* Sets whether this web sites dashboard is active.
	*
	* @param active the active of this web sites dashboard
	*/
	@Override
	public void setActive(boolean active) {
		_webSitesDashboard.setActive(active);
	}

	/**
	* Returns the transition ID of this web sites dashboard.
	*
	* @return the transition ID of this web sites dashboard
	*/
	@Override
	public java.lang.String getTransitionId() {
		return _webSitesDashboard.getTransitionId();
	}

	/**
	* Sets the transition ID of this web sites dashboard.
	*
	* @param transitionId the transition ID of this web sites dashboard
	*/
	@Override
	public void setTransitionId(java.lang.String transitionId) {
		_webSitesDashboard.setTransitionId(transitionId);
	}

	/**
	* Returns the status of this web sites dashboard.
	*
	* @return the status of this web sites dashboard
	*/
	@Override
	public java.lang.String getStatus() {
		return _webSitesDashboard.getStatus();
	}

	/**
	* Sets the status of this web sites dashboard.
	*
	* @param status the status of this web sites dashboard
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_webSitesDashboard.setStatus(status);
	}

	/**
	* Returns the comments of this web sites dashboard.
	*
	* @return the comments of this web sites dashboard
	*/
	@Override
	public java.lang.String getComments() {
		return _webSitesDashboard.getComments();
	}

	/**
	* Sets the comments of this web sites dashboard.
	*
	* @param comments the comments of this web sites dashboard
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_webSitesDashboard.setComments(comments);
	}

	@Override
	public boolean isNew() {
		return _webSitesDashboard.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_webSitesDashboard.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _webSitesDashboard.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_webSitesDashboard.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _webSitesDashboard.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _webSitesDashboard.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_webSitesDashboard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _webSitesDashboard.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_webSitesDashboard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_webSitesDashboard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_webSitesDashboard.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WebSitesDashboardWrapper((WebSitesDashboard)_webSitesDashboard.clone());
	}

	@Override
	public int compareTo(
		com.websites.dashboard.model.WebSitesDashboard webSitesDashboard) {
		return _webSitesDashboard.compareTo(webSitesDashboard);
	}

	@Override
	public int hashCode() {
		return _webSitesDashboard.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.websites.dashboard.model.WebSitesDashboard> toCacheModel() {
		return _webSitesDashboard.toCacheModel();
	}

	@Override
	public com.websites.dashboard.model.WebSitesDashboard toEscapedModel() {
		return new WebSitesDashboardWrapper(_webSitesDashboard.toEscapedModel());
	}

	@Override
	public com.websites.dashboard.model.WebSitesDashboard toUnescapedModel() {
		return new WebSitesDashboardWrapper(_webSitesDashboard.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _webSitesDashboard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _webSitesDashboard.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_webSitesDashboard.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WebSitesDashboardWrapper)) {
			return false;
		}

		WebSitesDashboardWrapper webSitesDashboardWrapper = (WebSitesDashboardWrapper)obj;

		if (Validator.equals(_webSitesDashboard,
					webSitesDashboardWrapper._webSitesDashboard)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WebSitesDashboard getWrappedWebSitesDashboard() {
		return _webSitesDashboard;
	}

	@Override
	public WebSitesDashboard getWrappedModel() {
		return _webSitesDashboard;
	}

	@Override
	public void resetOriginalValues() {
		_webSitesDashboard.resetOriginalValues();
	}

	private WebSitesDashboard _webSitesDashboard;
}