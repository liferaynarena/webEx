
<%@ include file="/html/advancesearch/init.jsp" %>

<portlet:actionURL name="createSite" var="createSite"/>

<aui:form action="<%=createSite.toString()%>" method="post">
	<aui:input type="text" name="site-name" label="Site Name" inlineLabel="left" required="<%=true %>" showRequiredLabel="<%=false%>">
	  <aui:validator name="required" errorMessage="Site name is mandatory"></aui:validator>
	</aui:input>
	<aui:button type="submit" value="Create"/>
</aui:form>
