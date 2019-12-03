package com.xyz.casestudy.paramfilters;

public class ParamFilterFactoy {
	
	public static ParamFilter getParamFilter(String param) {
		if("COLOR".equals(param)) {
			return ColourFilter.getInstance();
		}else if("SIZE".equals(param)) {
			return SizeFilter.getInstance();
		}else if("BRAND".equals(param)) {
			return BrandFilter.getInstance();
		}else if("PRICE".equals(param)) {
			return PriceFilter.getInstance();
		}
		return null;
	}

}
