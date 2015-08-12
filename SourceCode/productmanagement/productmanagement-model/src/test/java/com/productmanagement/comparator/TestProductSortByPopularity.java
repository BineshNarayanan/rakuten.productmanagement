package com.productmanagement.comparator;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.productmanagement.model.Product;

public class TestProductSortByPopularity {
	
	@Test
	public void testDefaultSort(){
		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("P1");
		p1.setPopularity(10);
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("P2");
		p2.setPopularity(5);
		
		products.add(p1);
		products.add(p2);
		
		Collections.sort(products, new ProductSortByPopularity());
		
		assertTrue("Sort By Popularity for default sort failed", products.get(0).getPopularity() > products.get(1).getPopularity());
		
	}
	
	@Test
	public void testDescendingSort(){
		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("P1");
		p1.setPopularity(10);
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("P2");
		p2.setPopularity(5);
		
		products.add(p1);
		products.add(p2);
		
		Collections.sort(products, new ProductSortByPopularity(true));
		
		assertTrue("Sort By Popularity for ascending sort failed", products.get(0).getPopularity() < products.get(1).getPopularity());
		
	}
}
