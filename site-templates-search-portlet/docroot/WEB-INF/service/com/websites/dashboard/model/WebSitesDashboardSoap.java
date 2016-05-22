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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.websites.dashboard.service.http.WebSitesDashboardServiceSoap}.
 *
 * @author liferay
 * @see com.websites.dashboard.service.http.WebSitesDashboardServiceSoap
 * @generated
 */
public class WebSitesDashboardSoap implements Serializable {
	public static WebSitesDashboardSoap toSoapModel(WebSitesDashboard model) {
		WebSitesDashboardSoap soapModel = new WebSitesDashboardSoap();

		soapModel.setWebId(model.getWebId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setExpireDate(model.getExpireDate());
		soapModel.setRenewDate(model.getRenewDate());
		soapModel.setPrice(model.getPrice());
		soapModel.setActive(model.getActive());
		soapModel.setTransitionId(model.getTransitionId());
		soapModel.setStatus(model.getStatus());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static WebSitesDashboardSoap[] toSoapModels(
		WebSitesDashboard[] models) {
		WebSitesDashboardSoap[] soapModels = new WebSitesDashboardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WebSitesDashboardSoap[][] toSoapModels(
		WebSitesDashboard[][] models) {
		WebSitesDashboardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WebSitesDashboardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WebSitesDashboardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WebSitesDashboardSoap[] toSoapModels(
		List<WebSitesDashboard> models) {
		List<WebSitesDashboardSoap> soapModels = new ArrayList<WebSitesDashboardSoap>(models.size());

		for (WebSitesDashboard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WebSitesDashboardSoap[soapModels.size()]);
	}

	public WebSitesDashboardSoap() {
	}

	public long getPrimaryKey() {
		return _webId;
	}

	public void setPrimaryKey(long pk) {
		setWebId(pk);
	}

	public long getWebId() {
		return _webId;
	}

	public void setWebId(long webId) {
		_webId = webId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getExpireDate() {
		return _expireDate;
	}

	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;
	}

	public Date getRenewDate() {
		return _renewDate;
	}

	public void setRenewDate(Date renewDate) {
		_renewDate = renewDate;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public String getTransitionId() {
		return _transitionId;
	}

	public void setTransitionId(String transitionId) {
		_transitionId = transitionId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private long _webId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _expireDate;
	private Date _renewDate;
	private double _price;
	private boolean _active;
	private String _transitionId;
	private String _status;
	private String _comments;
}