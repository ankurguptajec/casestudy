package com.xyz.casestudy.paramfilters;

import java.util.Map;
import java.util.stream.Collectors;

import com.xyz.casestudy.entities.ProductDetails;

public class ColourFilter implements ParamFilter{
	
	private ColourFilter() {
		
	}
	
	private static ColourFilter filter = null;
	
	public static ParamFilter getInstance() {
		if(filter == null)
			filter= new ColourFilter();
		return filter;
	}

	@Override
	public Map<Integer, ProductDetails> filter(Map<Integer, ProductDetails>products,Object value) {
		String color = (String) value;
		return products.entrySet().stream()
    			.filter(x -> x.getValue().getColour().equals(color))
    			.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	}

}
