<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portlet.asset.service.persistence.AssetCategoryFinderUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.assetpublisher.util.AssetPublisherUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portlet.asset.NoSuchVocabularyException"%>
<%@page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>

<%@ include file="/html/advancesearch/init.jsp" %>


<!-- Asset Start -->
<div class="span12" id="results">
   <c:choose>
	<c:when test="<%=assetDisplayStyle.length==2 %>">

		<%
		long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, assetDisplayStyle[1]);
		//asset entries 
		List<AssetEntry> ddmTemplateAssetEntries =null;
		if(Validator.isNotNull(request.getAttribute("entries"))){
			ddmTemplateAssetEntries = (List<AssetEntry>)request.getAttribute("entries");
	    %>
	      <%=PortletDisplayTemplateUtil.renderDDMTemplate(pageContext, portletDisplayDDMTemplateId, ddmTemplateAssetEntries)%>
	    <%
		}else{%>
		   
		  <div class="alert alert-warning">
			  <strong>Warning!</strong> No Results Found
		  </div>  
		<%}%>

		
		
	 </c:when>
     <c:otherwise>
	   
	 </c:otherwise>
  </c:choose>
</div> 
<!-- Asset End -->