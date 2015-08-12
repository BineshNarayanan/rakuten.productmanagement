package com.productmanagement.comparator;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.productmanagement.model.Product;

public class TestProductSortByPrice {
	
	@Test
	public void testPriceLowToHighSort(){
		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("P1");
		p1.setPrice(10.11);
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("P2");
		p1.setPrice(5.11);
		
		products.add(p1);
		products.add(p2);
		
		Collections.sort(products, new ProductSortByPrice());
		
		assertTrue("Sort by Price is ascending order failed!", products.get(0).getPrice() < products.get(1).getPrice());
	}
	
	@Test
	public void testPriceHighToLowSort(){
		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("P1");
		p1.setPrice(10.11);
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("P2");
		p1.setPrice(5.11);
		
		products.add(p1);
		products.add(p2);
		
		Collections.sort(products, new ProductSortByPrice(false));
		
		assertTrue("Sort by Price is descending order failed!", products.get(0).getPrice() > products.get(1).getPrice());
	}
}
