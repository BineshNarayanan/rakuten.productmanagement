package com.productmanagement.filter;

import java.util.List;

public class ProductFilter {
	private int lowestPrice;
	private int highestPrice;
	private List<String> brands;
	
	public int getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(int lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public int getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(int highestPrice) {
		this.highestPrice = highestPrice;
	}
	public List<String> getBrands() {
		return brands;
	}
	public void setBrands(List<String> brands) {
		this.brands = brands;
	}
}
