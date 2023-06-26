package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {
	
	String name = "amazon";
	By cart = By.id("cart");
	
	public void addCart() {
		System.out.println("cart is added");
	}

}
