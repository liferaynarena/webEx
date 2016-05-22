<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%@page import="java.security.MessageDigest"%>
<%@page import="java.security.NoSuchAlgorithmException"%>
<html>
<body>
<%
HttpServletRequest servletRequest=PortalUtil.getOriginalServletRequest(request);
String amount = servletRequest.getParameter("amount");
String productinfo= servletRequest.getParameter("productinfo");
String txnid = servletRequest.getParameter("txnid");
String phone = servletRequest.getParameter("phone");
String firstname = servletRequest.getParameter("firstname");
String key = "gtKFFx";
String salt = "eCwWELxi";
String status = servletRequest.getParameter("status");
String r_h =servletRequest.getParameter("hash");
String hashString="";
String udf1 =servletRequest.getParameter("udf1");
String udf2 =servletRequest.getParameter("udf2");
String udf3 =servletRequest.getParameter("udf3");
String udf4 =servletRequest.getParameter("udf4");
String udf5 =servletRequest.getParameter("udf5");
String p_Id = servletRequest.getParameter("payuMoneyId");

String additionalCharges = servletRequest.getParameter("additionalCharges");

%>
</body>
</html>