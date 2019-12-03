package com.xyz.casestudy.cache;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.xyz.casestudy.entities.*;

import com.xyz.casestudy.repositories.ProductCatalogueRepository;

@Service
public class ProductsCatalogueService {
	
    @Autowired
    private ProductCatalogueRepository productCatalogueRepository;

    @Cacheable(value="products")          
    public Map<Integer,ProductDetails> findAll() {
        return productCatalogueRepository.findAllProducts();
    }

    @CacheEvict(value = "products",allEntries = true)     
    public void delete(ProductDetails product) {
    	productCatalogueRepository.delete(product);
    }

    @CacheEvict(value = "products", allEntries=true)     
    public void save(ProductDetails product) {
         productCatalogueRepository.save(product);
    }
    
    @Scheduled(fixedRate = (2*60*60*1000))
    @CacheEvict(value = "products",allEntries = true)
    public void clearCache() {      
    }

}
