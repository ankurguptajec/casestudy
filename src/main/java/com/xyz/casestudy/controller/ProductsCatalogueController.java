package com.xyz.casestudy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.casestudy.bo.ProuctsCatalogueBO;
import com.xyz.casestudy.entities.ProductDetails;

@RestController
public class ProductsCatalogueController {
	
	@Autowired
	ProuctsCatalogueBO prouctsCatalogueBO;
	
	@RequestMapping("/")
	public Map<Integer,ProductDetails> findAllProducts(){
		return prouctsCatalogueBO.findAllProducts();
	}
	
	@RequestMapping("/findBySKU/skuId/{skuId}")
	public ProductDetails findBySKU(@PathVariable Integer skuId ){
		return prouctsCatalogueBO.findBySKU(skuId);
	}
	
	@RequestMapping("/findProductsByCategory/category/{category}")
	public Map<Integer,ProductDetails> findProductsByCategory(@PathVariable String category ){
		return prouctsCatalogueBO.findProductsByCategory(category);
	}
	
	@RequestMapping("/findAvailableNoOfProductBySeller/skuId/{skuId}/sellerId/{sellerId}")
	public Integer findAvailableNoOfProductBySeller(@PathVariable Integer skuId,@PathVariable Integer sellerId ){
		return prouctsCatalogueBO.findAvailableNoOfProductBySeller(skuId,sellerId);
	}
	
	@RequestMapping("/findProductsByCategoryGroupByParams/category/{category}")
	public Map<Integer,ProductDetails> findProductsByCategoryGroupByParams(@PathVariable String category,@RequestBody Map<String,Object> groupParams){
		return prouctsCatalogueBO.findProductsByCategoryGroupByParams(category, groupParams);
	}
}
