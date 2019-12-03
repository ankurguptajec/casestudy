package com.xyz.casestudy.paramfilters;

import java.util.Map;
import java.util.stream.Collectors;

import com.xyz.casestudy.entities.ProductDetails;

public class SizeFilter implements ParamFilter {
	
	private SizeFilter() {
		
	}
	
	private static SizeFilter filter = null;
	
	public static SizeFilter getInstance() {
		if(filter == null)
			filter= new SizeFilter();
		return filter;
	}

	@Override
	public Map<Integer, ProductDetails> filter(Map<Integer, ProductDetails>products,Object value) {
		String size = (String) value;
		return products.entrySet().stream()
    			.filter(x -> x.getValue().getSize().equals(size))
    			.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	}

}
