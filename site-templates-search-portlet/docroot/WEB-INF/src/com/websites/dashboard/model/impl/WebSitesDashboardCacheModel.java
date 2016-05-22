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

package com.websites.dashboard.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.websites.dashboard.model.WebSitesDashboard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WebSitesDashboard in entity cache.
 *
 * @author liferay
 * @see WebSitesDashboard
 * @generated
 */
public class WebSitesDashboardCacheModel implements CacheModel<WebSitesDashboard>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{webId=");
		sb.append(webId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", expireDate=");
		sb.append(expireDate);
		sb.append(", renewDate=");
		sb.append(renewDate);
		sb.append(", price=");
		sb.append(price);
		sb.append(", active=");
		sb.append(active);
		sb.append(", transitionId=");
		sb.append(transitionId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WebSitesDashboard toEntityModel() {
		WebSitesDashboardImpl webSitesDashboardImpl = new WebSitesDashboardImpl();

		webSitesDashboardImpl.setWebId(webId);
		webSitesDashboardImpl.setGroupId(groupId);
		webSitesDashboardImpl.setCompanyId(companyId);
		webSitesDashboardImpl.setUserId(userId);

		if (userName == null) {
			webSitesDashboardImpl.setUserName(StringPool.BLANK);
		}
		else {
			webSitesDashboardImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			webSitesDashboardImpl.setCreateDate(null);
		}
		else {
			webSitesDashboardImpl.setCreateDate(new Date(createDate));
		}

		if (expireDate == Long.MIN_VALUE) {
			webSitesDashboardImpl.setExpireDate(null);
		}
		else {
			webSitesDashboardImpl.setExpireDate(new Date(expireDate));
		}

		if (renewDate == Long.MIN_VALUE) {
			webSitesDashboardImpl.setRenewDate(null);
		}
		else {
			webSitesDashboardImpl.setRenewDate(new Date(renewDate));
		}

		webSitesDashboardImpl.setPrice(price);
		webSitesDashboardImpl.setActive(active);

		if (transitionId == null) {
			webSitesDashboardImpl.setTransitionId(StringPool.BLANK);
		}
		else {
			webSitesDashboardImpl.setTransitionId(transitionId);
		}

		if (status == null) {
			webSitesDashboardImpl.setStatus(StringPool.BLANK);
		}
		else {
			webSitesDashboardImpl.setStatus(status);
		}

		if (comments == null) {
			webSitesDashboardImpl.setComments(StringPool.BLANK);
		}
		else {
			webSitesDashboardImpl.setComments(comments);
		}

		webSitesDashboardImpl.resetOriginalValues();

		return webSitesDashboardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		webId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		expireDate = objectInput.readLong();
		renewDate = objectInput.readLong();
		price = objectInput.readDouble();
		active = objectInput.readBoolean();
		transitionId = objectInput.readUTF();
		status = objectInput.readUTF();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(webId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(expireDate);
		objectOutput.writeLong(renewDate);
		objectOutput.writeDouble(price);
		objectOutput.writeBoolean(active);

		if (transitionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(transitionId);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public long webId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long expireDate;
	public long renewDate;
	public double price;
	public boolean active;
	public String transitionId;
	public String status;
	public String comments;
}