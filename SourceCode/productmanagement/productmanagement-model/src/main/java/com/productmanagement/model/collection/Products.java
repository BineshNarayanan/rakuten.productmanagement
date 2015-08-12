package com.productmanagement.model.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.productmanagement.comparator.ProductSortByPopularity;
import com.productmanagement.comparator.ProductSortByPrice;
import com.productmanagement.model.Product;


public class Products {
	
	private List<Product> listOfProducts = new ArrayList<Product>();

	public Products(List<Product> list) {
		this.listOfProducts = list;
	}
	
	public List<Product> list(){
		return (List<Product>) new ArrayList<Product>(listOfProducts).clone();
	}
	
	/**
	 * This will sort the collection in ascending order.
	 */
	public void sortByPriceLowToHigh(){
		ProductSortByPrice comparator = new ProductSortByPrice();
		Collections.sort(listOfProducts,comparator);
	}
	
	/**
	 * This method will sort the collection on the price in descending order.
	 */
	public void sortByPriceHighToLow(){
		ProductSortByPrice comparator = new ProductSortByPrice(false);
		Collections.sort(listOfProducts,comparator);
	}
	
	/**
	 * Default Sort by Popularity.
	 */
	public void sortByPopularity(){
		ProductSortByPopularity comparator = new ProductSortByPopularity();
		Collections.sort(listOfProducts,comparator);
	}
}
