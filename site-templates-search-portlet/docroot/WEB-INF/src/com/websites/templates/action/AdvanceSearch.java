package com.websites.templates.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.FacetedSearcher;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.facet.AssetEntriesFacet;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.search.facet.MultiValueFacet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.GroupServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.service.LayoutSetServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.persistence.JournalArticleUtil;
import com.liferay.portlet.sites.util.SitesUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.websites.dashboard.helper.util.DashboardUtil;
import com.websites.dashboard.model.WebSitesDashboard;
import com.websites.dashboard.service.WebSitesDashboardLocalServiceUtil;

/**
 * Portlet implementation class AdvanceSearch
 */
public class AdvanceSearch extends MVCPortlet {

	public void enterSiteDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		actionResponse.setRenderParameter("mvcPath",
				"/html/advancesearch/siteDetails.jsp");
	}

	public void createSite(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			PortletSession portletSession = actionRequest.getPortletSession();
			String customSiteName = ParamUtil.getString(actionRequest,
					"site-name");
			// String
			// defaultSite=ParamUtil.getString(actionRequest,"template-name");
			long resourcePK = GetterUtil.getLong(portletSession
					.getAttribute("journalPk"));
			System.out.println("===============>>>" + resourcePK);
			JournalArticle journalArticle = JournalArticleLocalServiceUtil
					.getArticle(resourcePK);
			String defaultSite = journalArticle.getTitle(Locale.US);
			createSiteByTemplate(customSiteName, defaultSite, actionRequest,
					actionResponse,journalArticle);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "site-exists");
		}
	}

	public void fullArticle(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub

		long classPk = ParamUtil.getLong(actionRequest, "articleId");
		actionRequest.setAttribute("classPk", classPk);
		actionResponse.setRenderParameter("mvcPath",
				"/html/advancesearch/fullAsset.jsp");

	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		long categoryId = ParamUtil.getLong(renderRequest, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		long groupId = themeDisplay.getScopeGroupId();
		long[] groupIds = { groupId };
		String allAssetStructure = renderRequest.getPreferences().getValue(
				"allAssetStructure", StringPool.BLANK);
		AssetEntryQuery entryQuery = new AssetEntryQuery();
		entryQuery.setClassName(JournalArticle.class.getName());
		entryQuery.setGroupIds(groupIds);
		// Asserts Based on Structure Id
		if (!allAssetStructure.isEmpty()) {
			long[] classTypeIds = { GetterUtil.getLong(allAssetStructure) };
			entryQuery.setClassTypeIds(classTypeIds);
		}
		try {
			List<AssetEntry> assetEntries = null;
			if (Validator.isNotNull(categoryId) && categoryId > 0) {
				long[] anyCategoryIds = { categoryId };
				entryQuery.setAnyCategoryIds(anyCategoryIds);
				assetEntries = AssetEntryLocalServiceUtil
						.getEntries(entryQuery);
			} else {
				assetEntries = AssetEntryLocalServiceUtil
						.getEntries(entryQuery);
			}
			renderRequest.setAttribute("entries", assetEntries);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}

	private void createSiteByTemplate(String siteName, String templateName,
			ActionRequest actionRequest, ActionResponse actionResponse, JournalArticle journalArticle) {

		int publicLayoutSetPrototypeId = 0;
		int privateLayoutSetPrototypeId = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Group.class.getName(), actionRequest);

			Group grp = null;
			try {
				grp = GroupServiceUtil.getGroup(serviceContext
						.getThemeDisplay().getCompanyId(), siteName);
			} catch (Exception e) {

			}

			if (grp == null) {

				grp = GroupServiceUtil.addGroup(
						groupId,
						GroupConstants.DEFAULT_LIVE_GROUP_ID, siteName,
						siteName + " description",
						GroupConstants.TYPE_SITE_OPEN, true,
						GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, "/"
								+ siteName, true, true, serviceContext);

				long companyId = serviceContext.getThemeDisplay()
						.getCompanyId();
				List<LayoutSetPrototype> layoutSetPrototypes = LayoutSetPrototypeLocalServiceUtil
						.getLayoutSetPrototypes(companyId);
				for (LayoutSetPrototype layoutSetPrototype : layoutSetPrototypes) {

					if (layoutSetPrototype.getName("").equals(templateName)) {

						publicLayoutSetPrototypeId = (int) layoutSetPrototype
								.getLayoutSetPrototypeId();
					}
				}

				
				MethodKey methodKey = new MethodKey(SitesUtil.class,
						"updateLayoutSetPrototypesLinks", Group.class,
						long.class, long.class, boolean.class, boolean.class);
				PortalClassInvoker.invoke(true, methodKey, grp,
						publicLayoutSetPrototypeId,
						privateLayoutSetPrototypeId, true, true);

				LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(
						grp.getGroupId(), true);

				MethodKey _mergeLayoutSetPrototypeLayoutsMethodKey = new MethodKey(
						SitesUtil.class, "mergeLayoutSetPrototypeLayouts",
						Group.class, LayoutSet.class);

				PortalClassInvoker.invoke(true,
						_mergeLayoutSetPrototypeLayoutsMethodKey, grp,
						layoutSet);

				// System.out.println("success");

				java.io.File file = new java.io.File(getPortletContext()
						.getRealPath("/icon.png"));

				LayoutSetServiceUtil.updateLogo(grp.getGroupId(), false, true,
						file);

				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DATE, 31);

				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String expireDate = df.format(calendar.getTime());

				grp.getExpandoBridge().setAttribute("expire-date", expireDate);

				GroupLocalServiceUtil.updateGroup(grp);
				
				//Adding Group to Dashboard
				DashboardUtil dashboardUtil=new DashboardUtil();
				dashboardUtil.addDashboard(grp, themeDisplay,layoutSet,journalArticle);

				SessionMessages.add(actionRequest, "site.created");

			} else {
				SessionErrors.add(actionRequest, "site-exists");
				SessionMessages
						.add(actionRequest,
								PortalUtil.getPortletId(actionRequest)
										+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setRenderParameter("mvcPath",
						"/html/advancesearch/siteDetails.jsp");
			}

		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void viewSites(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String urlTitle = ParamUtil.getString(actionRequest, "urlTitle");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		PortletSession portletSession = actionRequest.getPortletSession();
		try {
			JournalArticle journalArticle = JournalArticleLocalServiceUtil
					.getArticleByUrlTitle(groupId, urlTitle);
			SessionMessages
					.add(actionRequest,
							PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setRenderParameter("mvcPath",
					"/html/advancesearch/fullAsset.jsp");
			portletSession.setAttribute("journalPk", journalArticle.getId());
			actionResponse.setRenderParameter("classPk",
					String.valueOf(journalArticle.getResourcePrimKey()));
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
}
