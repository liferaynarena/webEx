package com.liferay.portal.kernel.portlet;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class WebExFriendlyURLMapper extends DefaultFriendlyURLMapper {
	public WebExFriendlyURLMapper() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public String buildPath(LiferayPortletURL liferayPortletURL) {
		// TODO Auto-generated method stub
		//return super.buildPath(liferayPortletURL);
		Map<String, String> routeParameters = new HashMap<String, String>();

		buildRouteParameters(liferayPortletURL, routeParameters);

		String friendlyURLPath = router.parametersToUrl(routeParameters);

		if (Validator.isNull(friendlyURLPath)) {
			return null;
		}

		addParametersIncludedInPath(liferayPortletURL, routeParameters);

		friendlyURLPath = StringPool.SLASH.concat(getMapping()).concat(
			friendlyURLPath);
		
		System.out.println("Friendly URL ::: >>>"+friendlyURLPath);

		return friendlyURLPath;
	}
	
}
