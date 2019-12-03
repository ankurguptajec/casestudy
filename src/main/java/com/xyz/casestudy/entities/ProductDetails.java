package com.xyz.casestudy.entities;

import java.util.Map;

public class ProductDetails {
	
	private int sku_id;
	private String skuName;
	private String brand;
	private String colour;
	private String size;
	private String category;
	private double price;
	private Map<Seller,Integer> sellerMap;
	public int getSku_id() {
		return sku_id;
	}
	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Map<Seller, Integer> getSellerMap() {
		return sellerMap;
	}
	public void setSellerMap(Map<Seller, Integer> sellerMap) {
		this.sellerMap = sellerMap;
	}
	
}