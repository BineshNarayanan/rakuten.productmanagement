package com.productmanagement.comparator;

import java.util.Comparator;

import com.productmanagement.model.Product;

public class ProductSortByPopularity implements Comparator<Product> {
	
	private boolean isAscending = false;
	
	public ProductSortByPopularity(){
		
	}
	
	public ProductSortByPopularity(boolean isAscending){
		this.isAscending = isAscending;
	}
	
	public int compare(Product p1, Product p2) {
		if(null != p1 && null != p2) {
			if(isAscending){
				return (p1.getPopularity() > p2.getPopularity()) ? 1 : (p1.getPopularity() < p2.getPopularity()) ? -1 : 0;
			}
			return (p1.getPopularity() > p2.getPopularity()) ? -1 : (p1.getPopularity() < p2.getPopularity()) ? 1 : 0;
		}
		return 0;
	}

}
