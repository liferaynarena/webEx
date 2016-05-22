
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

<%-- <portlet:actionURL var="createSite" name="createSite"></portlet:actionURL>
<aui:a href="<%=createSite%>">Create Site</aui:a> --%>

<%

portletSession.setAttribute("pagecontext", pageContext);
boolean hidePortletWhenEmpty = true;

long[] vocabularyIds = null;

if(allAssetVocabularies) {
  vocabularyIds = availableAssetVocabularyIds;
} else {
  vocabularyIds = assetVocabularyIds;
}

%>

<portlet:actionURL var="actionurl" name="siteDetails">
<portlet:param name="siteId" value="11232"/>
</portlet:actionURL>


<%-- <aui:a href="<%=actionurl.toString()%>">Click Me</aui:a> --%>

<!-- Vocablaries Start -->
<div class="span2">
<c:choose>
	<c:when test="<%=assetDisplayStyle.length==2%>">

		<%
		long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, assetDisplayStyle[0]);
		
		List<AssetVocabulary> ddmTemplateAssetVocabularies = new ArrayList<AssetVocabulary>();

		if (allAssetVocabularies) {
			ddmTemplateAssetVocabularies = assetVocabularies;
		}
		else {
			for (long assetVocabularyId : assetVocabularyIds) {
				try {
					ddmTemplateAssetVocabularies.add(AssetVocabularyServiceUtil.getVocabulary(assetVocabularyId));
				}
				catch (NoSuchVocabularyException nsve) {
				}
			}
		}
		%>

		<%= PortletDisplayTemplateUtil.renderDDMTemplate(pageContext, portletDisplayDDMTemplateId, ddmTemplateAssetVocabularies) %>
	 </c:when>
     <c:otherwise>
	    <liferay-ui:asset-categories-navigation vocabularyIds="<%=vocabularyIds%>"></liferay-ui:asset-categories-navigation>
	   	
	 </c:otherwise>
  </c:choose>

</div>
<!-- Vocablaries End -->

<!-- Asset Start -->
<div class="span10" id="results">
   <c:choose>
	<c:when test="<%=assetDisplayStyle.length==2 %>">

		<%
		long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, assetDisplayStyle[1]);
        
		//asset entries 
		List<AssetEntry> ddmTemplateAssetEntries =null;
		if(Validator.isNotNull(renderRequest.getAttribute("entries"))){
			ddmTemplateAssetEntries = (List<AssetEntry>)renderRequest.getAttribute("entries");
		}else{
		    ddmTemplateAssetEntries = AssetEntryLocalServiceUtil.getAssetEntries(0,AssetEntryLocalServiceUtil.getAssetEntriesCount());
		}
		%>

		<%=PortletDisplayTemplateUtil.renderDDMTemplate(pageContext, portletDisplayDDMTemplateId, ddmTemplateAssetEntries)%>
		
	 </c:when>
     <c:otherwise>
	   
	 </c:otherwise>
  </c:choose>
</div> 
<!-- Asset End -->
