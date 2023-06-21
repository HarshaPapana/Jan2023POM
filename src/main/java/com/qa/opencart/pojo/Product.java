package com.qa.opencart.pojo;

public class Product {
	
	private String searchKey;
	private String productName;
	private int productImages;
	
	//adding constructor , right click-->Source-->generate constructor using fields
	public Product(String searchKey, String productName, int productImages) {
		
		this.searchKey = searchKey;
		this.productName = productName;
		this.productImages = productImages;
		 
	}
	
	//adding getters and setters right click-->Source-->generate getters and setters
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductImages() {
		return productImages;
	}
	public void setProductImages(int productImages) {
		this.productImages = productImages;
	}
	
	//adding generate tostring(), right click-->Source-->generate tostring
	@Override
	public String toString() {
		return "Product [searchKey=" + searchKey + ", productName=" + productName + ", productImages=" + productImages
				+ "]";
	}
	
	
	
	
	
	
	
}
