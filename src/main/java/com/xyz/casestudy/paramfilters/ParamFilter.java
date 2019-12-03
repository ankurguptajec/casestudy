package com.xyz.casestudy.paramfilters;

import java.util.Map;

import com.xyz.casestudy.entities.ProductDetails;

public interface ParamFilter {
	
	public Map<Integer,ProductDetails> filter(Map<Integer, ProductDetails>products, Object value);

}
