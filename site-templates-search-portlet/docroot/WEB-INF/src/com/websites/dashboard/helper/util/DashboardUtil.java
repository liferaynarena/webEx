package com.websites.dashboard.helper.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.websites.dashboard.model.WebSitesDashboard;
import com.websites.dashboard.service.WebSitesDashboardLocalServiceUtil;


public class DashboardUtil {

	public void addDashboard(Group grp, ThemeDisplay themeDisplay, LayoutSet layoutSet, JournalArticle journalArticle) {
		// TODO Auto-generated method stub
		try{
			String price=fetchPrice(journalArticle);
			WebSitesDashboard sitesDashboard=WebSitesDashboardLocalServiceUtil.createWebSitesDashboard(grp.getPrimaryKey());
			sitesDashboard.setGroupId(grp.getGroupId());
			sitesDashboard.setCompanyId(grp.getCompanyId());
			sitesDashboard.setUserId(themeDisplay.getUserId());
			sitesDashboard.setUserName(themeDisplay.getUser().getEmailAddress());
			Calendar calendar=Calendar.getInstance();
		    sitesDashboard.setCreateDate(calendar.getTime());
		    calendar.set(Calendar.MONTH,1);
		    sitesDashboard.setExpireDate(calendar.getTime());
		    
		    sitesDashboard.setPrice(GetterUtil.getDouble(price));
		    sitesDashboard.setActive(true);
		    
		    WebSitesDashboardLocalServiceUtil.addWebSitesDashboard(sitesDashboard);
		    
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private String fetchPrice(JournalArticle journalArticle) throws DocumentException {
		Document document = SAXReaderUtil.read(journalArticle.getContentByLocale(Locale.ENGLISH.toString()));
		Node priceNode = document.selectSingleNode("/root/dynamic-element[@name='Text6156']/dynamic-content"); 
		String price = priceNode.getText(); 
		return price;
	}
	
	  public static String formateDateHealper(Date date){
		  SimpleDateFormat dateFormat=new SimpleDateFormat("EEE, MMM dd, ''yy");
		  String formatDate="";
		  if(Validator.isNotNull(date)){
		   formatDate=dateFormat.format(date);
		  }
		  return formatDate;
	  }

	
}
