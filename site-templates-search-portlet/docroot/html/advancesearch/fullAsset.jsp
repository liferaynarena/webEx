
<%@ include file="/html/advancesearch/init.jsp" %>


<%
 long classPk=GetterUtil.getLong(renderRequest.getParameter("classPk"));
%>


<liferay-ui:journal-article articleResourcePrimKey="<%=classPk%>" showTitle="<%=false%>" ></liferay-ui:journal-article>