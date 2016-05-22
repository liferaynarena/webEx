
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="java.util.*" %>
<%@ page import="java.security.*" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<portlet:renderURL var="successUrl" name="successUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">

</portlet:renderURL>

<portlet:renderURL var="failureUrl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
   <portlet:param name="jspPage" value="/html/websitesdashboard/failureRedirect.jsp"/>
</portlet:renderURL>


<%!
public boolean empty(String s)
	{
		if(s== null || s.trim().equals(""))
			return true;
		else
			return false;
	}
%>

<%
Map<String,String> params=(Map<String,String>)request.getAttribute("params");
String hash=params.get("hash");
String action1=params.get("action1");
%>
<form action="<%= action1 %>" method="post" name="payuForm">
      <input type="hidden" name="key" value="<%= (empty(params.get("key"))) ? "" : params.get("key") %>" />
      <input type="hidden" name="hash" value="<%= (empty(params.get("hash"))) ? "" : params.get("hash") %>"/>
      <input type="hidden" name="txnid" value="<%= (empty(params.get("txnid"))) ? "" : params.get("txnid") %>" />
      <input type="hidden" name="furl" value="<%=failureUrl.toString()%>"/>
      <input type="hidden" name="surl" value="<%=successUrl.toString()%>" />
      <input type="hidden" name="productinfo" value="<%= (empty(params.get("productinfo"))) ? "" : params.get("productinfo") %>" size="64" />
      <table>
        <tr>
          <td><b>Billing Details</b></td>
        </tr>
        <tr>
          <td style="padding: 10px;">Amount: </td>
          <td style="padding: 10px;"><input readonly="readonly" type="text" name="amount" value="<%= (empty(params.get("amount"))) ? "" : params.get("amount") %>" /></td>
          <td style="padding: 10px;">First Name: </td>
          <td style="padding: 10px;"><input readonly="readonly" type="text" name="firstname" id="firstname" value="<%= (empty(params.get("firstname"))) ? "" : params.get("firstname") %>" /></td>
        </tr>
        <tr>
          <td style="padding: 10px;">Email: </td>
          <td style="padding: 10px;"><input type="text" name="email" id="email" value="<%= (empty(params.get("email"))) ? "" : params.get("email") %>" /></td>
          <td style="padding: 10px;">Phone: </td>
          <td style="padding: 10px;"><input type="text" name="phone" value="<%= (empty(params.get("phone"))) ? "" : params.get("phone") %>" /></td>
        </tr>
                
        <tr>
          <% if(empty(hash)){ %>
            <td colspan="4"><input type="submit" value="Submit" /></td>
          <% } %>
        </tr>
        
        <tr>
          
            <td colspan="4"><input type="submit" value="Proceed" /></td>
         
        </tr>
      </table>
    </form>
    
    
<script>
var hash='<%= hash %>';
function submitPayuForm() {
	//if (hash == '')
		return;
      var payuForm = document.forms.payuForm;
      payuForm.submit();
    }
</script>
