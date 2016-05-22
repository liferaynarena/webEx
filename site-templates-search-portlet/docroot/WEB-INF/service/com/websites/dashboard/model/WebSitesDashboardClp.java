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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.websites.dashboard.service.ClpSerializer;
import com.websites.dashboard.service.WebSitesDashboardLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liferay
 */
public class WebSitesDashboardClp extends BaseModelImpl<WebSitesDashboard>
	implements WebSitesDashboard {
	public WebSitesDashboardClp() {
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
	public long getPrimaryKey() {
		return _webId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWebId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _webId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getWebId() {
		return _webId;
	}

	@Override
	public void setWebId(long webId) {
		_webId = webId;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setWebId", long.class);

				method.invoke(_webSitesDashboardRemoteModel, webId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_webSitesDashboardRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_webSitesDashboardRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_webSitesDashboardRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_webSitesDashboardRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_webSitesDashboardRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpireDate() {
		return _expireDate;
	}

	@Override
	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setExpireDate", Date.class);

				method.invoke(_webSitesDashboardRemoteModel, expireDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRenewDate() {
		return _renewDate;
	}

	@Override
	public void setRenewDate(Date renewDate) {
		_renewDate = renewDate;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setRenewDate", Date.class);

				method.invoke(_webSitesDashboardRemoteModel, renewDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setPrice", double.class);

				method.invoke(_webSitesDashboardRemoteModel, price);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_webSitesDashboardRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTransitionId() {
		return _transitionId;
	}

	@Override
	public void setTransitionId(String transitionId) {
		_transitionId = transitionId;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setTransitionId", String.class);

				method.invoke(_webSitesDashboardRemoteModel, transitionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_webSitesDashboardRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_webSitesDashboardRemoteModel != null) {
			try {
				Class<?> clazz = _webSitesDashboardRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_webSitesDashboardRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWebSitesDashboardRemoteModel() {
		return _webSitesDashboardRemoteModel;
	}

	public void setWebSitesDashboardRemoteModel(
		BaseModel<?> webSitesDashboardRemoteModel) {
		_webSitesDashboardRemoteModel = webSitesDashboardRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _webSitesDashboardRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_webSitesDashboardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WebSitesDashboardLocalServiceUtil.addWebSitesDashboard(this);
		}
		else {
			WebSitesDashboardLocalServiceUtil.updateWebSitesDashboard(this);
		}
	}

	@Override
	public WebSitesDashboard toEscapedModel() {
		return (WebSitesDashboard)ProxyUtil.newProxyInstance(WebSitesDashboard.class.getClassLoader(),
			new Class[] { WebSitesDashboard.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WebSitesDashboardClp clone = new WebSitesDashboardClp();

		clone.setWebId(getWebId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setExpireDate(getExpireDate());
		clone.setRenewDate(getRenewDate());
		clone.setPrice(getPrice());
		clone.setActive(getActive());
		clone.setTransitionId(getTransitionId());
		clone.setStatus(getStatus());
		clone.setComments(getComments());

		return clone;
	}

	@Override
	public int compareTo(WebSitesDashboard webSitesDashboard) {
		int value = 0;

		value = DateUtil.compareTo(getExpireDate(),
				webSitesDashboard.getExpireDate());

		if (value != 0) {
			return value;
		}

		if (getUserId() < webSitesDashboard.getUserId()) {
			value = -1;
		}
		else if (getUserId() > webSitesDashboard.getUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getActive() == webSitesDashboard.getActive()) {
			value = -1;
		}
		else if (getActive() != webSitesDashboard.getActive()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getStatus().compareTo(webSitesDashboard.getStatus());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WebSitesDashboardClp)) {
			return false;
		}

		WebSitesDashboardClp webSitesDashboard = (WebSitesDashboardClp)obj;

		long primaryKey = webSitesDashboard.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{webId=");
		sb.append(getWebId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", expireDate=");
		sb.append(getExpireDate());
		sb.append(", renewDate=");
		sb.append(getRenewDate());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", transitionId=");
		sb.append(getTransitionId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.websites.dashboard.model.WebSitesDashboard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>webId</column-name><column-value><![CDATA[");
		sb.append(getWebId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expireDate</column-name><column-value><![CDATA[");
		sb.append(getExpireDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewDate</column-name><column-value><![CDATA[");
		sb.append(getRenewDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transitionId</column-name><column-value><![CDATA[");
		sb.append(getTransitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _webId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _expireDate;
	private Date _renewDate;
	private double _price;
	private boolean _active;
	private String _transitionId;
	private String _status;
	private String _comments;
	private BaseModel<?> _webSitesDashboardRemoteModel;
}