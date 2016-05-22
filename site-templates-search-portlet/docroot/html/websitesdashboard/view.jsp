<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.websites.dashboard.helper.util.DashboardUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.websites.dashboard.model.WebSitesDashboard"%>
<%@page import="com.websites.dashboard.service.WebSitesDashboardLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />

<liferay-ui:search-container emptyResultsMessage="there-are-no-students"
	headerNames="Site Name,User Name,Create Date,Expire Date,Renew Date,Price,Status,Action"
	delta="5" deltaConfigurable="true" >
	<liferay-ui:search-container-results>
		<%
			total = WebSitesDashboardLocalServiceUtil.getWebSitesDashboardsCount();
					results = WebSitesDashboardLocalServiceUtil.getWebSitesDashboards(
							searchContainer.getStart(),
							searchContainer.getEnd());
					searchContainer.setTotal(total);
					searchContainer.setResults(results);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row
		className="com.websites.dashboard.model.WebSitesDashboard" keyProperty="webId"
		modelVar="currentSite">
		
		<liferay-ui:search-container-column-text 
			name="Site Name">
			<%=GroupLocalServiceUtil.getGroup(currentSite.getGroupId()).getName()%>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text 
			name="User Name" property="userName" orderable="<%=true%>"/>

		<liferay-ui:search-container-column-text 
			name="Create Date"  orderable="<%=true%>" value="<%=DashboardUtil.formateDateHealper(currentSite.getCreateDate()) %>"/>
			
		<liferay-ui:search-container-column-text 
			name="Expire Date" orderable="<%=true%>" value="<%=DashboardUtil.formateDateHealper(currentSite.getExpireDate()) %>"/>
	   
		<liferay-ui:search-container-column-text 
			name="Renew Date"  orderable="<%=true%>" value="<%=DashboardUtil.formateDateHealper(currentSite.getRenewDate()) %>"/>
			
		<liferay-ui:search-container-column-text 
			name="Price" property="price"/>
			
		<liferay-ui:search-container-column-text 
			name="Status" property="status" orderable="<%=true%>"/>
			
			<portlet:actionURL var="shoppingUrl" name="shoppingUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			   <portlet:param name="webSiteId" value="<%=String.valueOf(currentSite.getWebId())%>"/>
			</portlet:actionURL>
			
		<liferay-ui:search-container-column-text 
			name="Action">
			<liferay-ui:icon-menu>
			  <liferay-ui:icon-list >
				   <liferay-ui:icon useDialog="<%=true%>"  src="/template-001-theme/images/shopping/cart.png" message="Pay"  url="<%=shoppingUrl.toString()%>" />
		      </liferay-ui:icon-list>
		      <liferay-ui:icon-list>
				  <liferay-ui:icon image="edit" useDialog="<%=true%>" url="http://url.com"/>
			  </liferay-ui:icon-list>
			  <liferay-ui:icon-list>
				  <liferay-ui:icon image="delete" useDialog="<%=true%>" url="http://url.com"/>
			  </liferay-ui:icon-list>
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>	
			
			
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>



