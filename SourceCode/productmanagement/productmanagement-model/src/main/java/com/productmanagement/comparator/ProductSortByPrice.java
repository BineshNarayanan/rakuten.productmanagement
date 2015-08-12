package com.productmanagement.comparator;

import java.util.Comparator;

import com.productmanagement.model.Product;

public class ProductSortByPrice implements Comparator<Product> {
	
	private boolean isAscending = true;
	
	/**
	 * Default Constructor. Default Value of isAscending is true;
	 */
	public ProductSortByPrice(){
		
	}
	
	public ProductSortByPrice(boolean isAscending){
		this.isAscending = isAscending;
	}
	
	//default sort
	public int compare(Product p1, Product p2) {
		if(null != p1 && null != p2) {
			if(!isAscending){
				return (p1.getPrice() < p2.getPrice()) ? 1 : (p1.getPrice() > p2.getPrice()) ? -1 : 0;
			}
			return (p1.getPrice() > p2.getPrice()) ? 1 : (p1.getPrice() < p2.getPrice()) ? -1 : 0;
		}
		return 0;
	}

}
