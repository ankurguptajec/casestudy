package com.xyz.casestudy.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.casestudy.entities.*;

@Repository
public class ProductCatalogueRepository {
	
	private static String FIND_ALL_PRODUCTS_QUERY = "SELECT PD.SKU_ID,PD.SKUNAME,PD.CATEGORY,PD.BRAND,PD.COLOUR,PD.SELLER_ID,S.SELLERNAME\r\n" + 
			",PD.SIZE,PD.PRICE,PD.NOOFPRODUCTS FROM\r\n" + 
			"(SELECT P.SKU_ID,P.SKUNAME,P.CATEGORY,P.BRAND,P.COLOUR,PS.SELLER_ID\r\n" + 
			",P.SIZE,P.PRICE,PS.NOOFPRODUCTS FROM PRODUCTS P LEFT OUTER JOIN PRODUCTS_SELLERS PS ON P.SKU_ID = PS.SKU_ID) PD,\r\n" + 
			" SELLERS S WHERE PD.SELLER_ID = S.SELLER_ID";
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Map<Integer,ProductDetails> findAllProducts(){
			
		Map<Integer, ProductDetails> products = new HashMap<Integer, ProductDetails>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(FIND_ALL_PRODUCTS_QUERY);

        for (Map<String, Object> row : rows) {
        	Integer sku_id =(Integer) row.get("SKU_ID");
        	ProductDetails product = products.get(sku_id);
        	
        	Seller seller = new Seller();
    		seller.setSeller_id((int)row.get("SELLER_ID"));
    		seller.setSellerName((String)row.get("SELLERNAME"));
    		//seller.setNoOfProducts((int)row.get("NOOFPRODUCTS"));
        	if(product ==null) {
        		product = new	ProductDetails();
        		product.setSku_id(sku_id);
        		product.setSkuName((String)row.get("SKUNAME"));
        		product.setCategory((String)row.get("CATEGORY"));
        		product.setBrand((String)row.get("BRAND"));
        		product.setColour((String)row.get("COLOUR"));
        		product.setSize((String)row.get("SIZE"));
        		product.setPrice((double)row.get("PRICE"));
        		
        		Map<Seller,Integer> sellerMap = new HashMap<Seller,Integer>();
        		product.setSellerMap(sellerMap);
        		products.put(sku_id, product);
        		
        	}
        	
        	product.getSellerMap().put(seller, (Integer)row.get("NOOFPRODUCTS"));
        	
           }
        
		return products;
	}
	
	public void delete(ProductDetails product){
		
	}
	
	public void save(ProductDetails product){}
	
	//need to add a method to update the 

}


