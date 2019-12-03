package com.xyz.casestudy.bo;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyz.casestudy.cache.ProductsCatalogueService;
import com.xyz.casestudy.entities.ProductDetails;
import com.xyz.casestudy.entities.Seller;
import com.xyz.casestudy.paramfilters.ParamFilter;
import com.xyz.casestudy.paramfilters.ParamFilterFactoy;

@Component
public class ProuctsCatalogueBO {

	@Autowired
	ProductsCatalogueService productsCatalogueService;
	
    public Map<Integer,ProductDetails> findAllProducts(){
		return productsCatalogueService.findAll();
	}
    
    public ProductDetails findBySKU(Integer sku_id){
		return productsCatalogueService.findAll().get(sku_id);
	}
    
    public Map<Integer,ProductDetails> findProductsByCategory(String category){
    	Map<Integer,ProductDetails> products = productsCatalogueService.findAll();
    	return filterProductsMapByCategory(products, category);
    }
    
	public Integer findAvailableNoOfProductBySeller(Integer skuId, Integer sellerId){
    	ProductDetails product = productsCatalogueService.findAll().get(skuId);
    	if(product != null) {
    		for (Map.Entry<Seller, Integer> entry : product.getSellerMap().entrySet()) {
    			if(sellerId == entry.getKey().getSeller_id()){
    				return entry.getValue();
    			}
    		}
    	}
    	
    	return 0;
    }
	
	public Map<Integer,ProductDetails> findProductsByCategoryGroupByParams(String category, Map<String,Object> groupParams){
		Map<Integer,ProductDetails> products = productsCatalogueService.findAll();
		Map<Integer,ProductDetails> filteredProducts =filterProductsMapByCategory(products, category);
		
		for (Map.Entry<String,Object> entry : groupParams.entrySet()) {
			ParamFilter filter= ParamFilterFactoy.getParamFilter(entry.getKey());
			if(filter  != null) {
				filteredProducts = filter.filter(filteredProducts, entry.getValue());
			}
			}
		return filteredProducts;
		
	}
	
	private Map<Integer,ProductDetails> filterProductsMapByCategory(Map<Integer,ProductDetails> products,String category){
		Map<Integer, ProductDetails> filteredProducts = products.entrySet().stream()
    			.filter(x -> x.getValue().getCategory().equals(category))
    			.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		
    	return filteredProducts;
	}
		
}
