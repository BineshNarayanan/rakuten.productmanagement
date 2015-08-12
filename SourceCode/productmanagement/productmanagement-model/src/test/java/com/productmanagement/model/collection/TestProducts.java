package com.productmanagement.model.collection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.productmanagement.model.Product;

public class TestProducts {
	
	private Products products = null;
	
	@Before
	public void init(){
		List<Product> listOfProducts = new ArrayList<Product>();
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("P1");
		p1.setPopularity(10);
		p1.setPrice(10.11);
		
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("P2");
		p2.setPopularity(5);
		p1.setPrice(5.11);
		
		listOfProducts.add(p1);
		listOfProducts.add(p2);
		products = new Products(listOfProducts);
	}
	
	@Test
	public void testProductsList(){
		assertTrue("Getting list of Products test failed", products.list().size() > 0);
	}
	
	@Test
	public void testProductsSort(){
		products.sortByPopularity();
		assertTrue("Sorting Product list by popularity fails", products.list().get(0).getPopularity() > products.list().get(1).getPopularity());
	}
	
	@Test
	public void testProductsSortByPriceHighToLow(){
		products.sortByPriceHighToLow();
		assertTrue("Sorting Product list by Price High-Low fails", products.list().get(0).getPrice() > products.list().get(1).getPrice());
	}
	
	@Test
	public void testProductsSortByPriceLowToHigh(){
		products.sortByPriceLowToHigh();
		assertTrue("Sorting Product list by Price Low-High fails", products.list().get(0).getPrice() < products.list().get(1).getPrice());
	}
	
}
