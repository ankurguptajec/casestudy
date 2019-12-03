package com.xyz.casestudy.paramfilters;

import java.util.Map;
import java.util.stream.Collectors;

import com.xyz.casestudy.entities.ProductDetails;

public class PriceFilter implements ParamFilter {

    private PriceFilter() {
		
	}
	
	private static PriceFilter filter = null;
	
	public static PriceFilter getInstance() {
		if(filter == null)
			filter= new PriceFilter();
		return filter;
	}
	@Override
	public Map<Integer, ProductDetails> filter(Map<Integer, ProductDetails>products,Object value) {
		double price =  (Double) value;
		return products.entrySet().stream()
    			.filter(x -> x.getValue().getPrice() <= price)
    			.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	}

}
