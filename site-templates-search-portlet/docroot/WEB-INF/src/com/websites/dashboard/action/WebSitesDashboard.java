package com.websites.dashboard.action;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class WebSitesDashboard
 */
public class WebSitesDashboard extends MVCPortlet {
	
	public void successUrl(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		HttpServletRequest httpServletRequest=PortalUtil.getHttpServletRequest(actionRequest);
		HttpServletRequest request=PortalUtil.getOriginalServletRequest(httpServletRequest);
		String amount = request.getParameter("amount");
		String productinfo= request.getParameter("productinfo");
		String txnid = request.getParameter("txnid");
		String phone = request.getParameter("phone");
		String firstname = request.getParameter("firstname");
		String key = "gtKFFx";
		String salt = "eCwWELxi";
		String status = request.getParameter("status");
		String r_h =request.getParameter("hash");
		String hashString="";
		String udf1 =request.getParameter("udf1");
		String udf2 =request.getParameter("udf2");
		String udf3 =request.getParameter("udf3");
		String udf4 =request.getParameter("udf4");
		String udf5 =request.getParameter("udf5");
		String p_Id = request.getParameter("payuMoneyId");

		String additionalCharges = request.getParameter("additionalCharges");
		actionResponse.setRenderParameter("jspPage","/html/websitesdashboard/successRedirect.jsp");
	}
	
	
	public void shoppingUrl(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String webSiteID=ParamUtil.getString(actionRequest,"webSiteId");
	    PortletSession portletSession=actionRequest.getPortletSession();
	    portletSession.setAttribute("webSiteID", webSiteID);
        
	    
	    //PayU Redirection Code
        ThemeDisplay themeDisplay=(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String merchant_key="gtKFFx";
    	String salt="eCwWELxi";
    	String action1 ="";
    	String base_url=PropsUtil.get("base_url");
    	String productInfo="Sample Site";
    	
    	String price="5000";
    	int error=0;
    	String hashString="";
    	String txnid ="";
        Map<String, String> params=new HashMap<String, String>();
        Random rand = new Random();
    	String rndm = Integer.toString(rand.nextInt())+(System.currentTimeMillis() / 1000L);
    	txnid=hashCal("SHA-256",rndm).substring(0,20);
    	
        params.put("key", merchant_key);
    	params.put("txnid", txnid);
    	params.put("amount",price);
    	params.put("firstname", themeDisplay.getUser().getScreenName());
    	params.put("email",themeDisplay.getUser().getEmailAddress());
    	params.put("phone","9032433859");
    	params.put("productinfo",productInfo);
    	
    	
    	String hash="";
    	String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";
    	

		String[] hashVarSeq=hashSequence.split("\\|");
		
		for(String part : hashVarSeq)
		{
			hashString= (empty(params.get(part)))?hashString.concat(""):hashString.concat(params.get(part));
			hashString=hashString.concat("|");
		}
		hashString=hashString.concat(salt);
		
		hash=hashCal("SHA-512",hashString);
		action1=base_url.concat("/_payment");
		
		System.out.println("action1::>>>"+action1);
	
		System.out.println("hash============>>>>>"+hash);
		
		params.put("hash",hash);
		params.put("action1", action1);
		actionRequest.setAttribute("params", params);

	    
		actionResponse.setRenderParameter("jspPage","/html/websitesdashboard/shoppingCart.jsp");
	}
 
	
	public String hashCal(String type,String str){
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try{
		MessageDigest algorithm = MessageDigest.getInstance(type);
		algorithm.reset();
		algorithm.update(hashseq);
		byte messageDigest[] = algorithm.digest();
            
		
		for (int i=0;i<messageDigest.length;i++) {
			String hex=Integer.toHexString(0xFF & messageDigest[i]);
			if(hex.length()==1) hexString.append("0");
			hexString.append(hex);
		}
			
		}catch(NoSuchAlgorithmException nsae){ }
		
		return hexString.toString();
	}
   
    public boolean empty(String s)
	{
		if(s== null || s.trim().equals(""))
			return true;
		else
			return false;
	}
}
