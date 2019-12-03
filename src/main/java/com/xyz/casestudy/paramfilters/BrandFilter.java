package com.xyz.casestudy.paramfilters;

import java.util.Map;
import java.util.stream.Collectors;

import com.xyz.casestudy.entities.ProductDetails;

public class BrandFilter implements ParamFilter {
	
private BrandFilter() {
		
	}
	
	private static BrandFilter filter = null;
	
	public static ParamFilter getInstance() {
		if(filter == null)
			filter= new BrandFilter();
		return filter;
	}

	@Override
	public Map<Integer, ProductDetails> filter(Map<Integer, ProductDetails>products,Object value) {
		String brand = (String) value;
		return products.entrySet().stream()
    			.filter(x -> x.getValue().getBrand().equals(brand))
    			.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	}

}
