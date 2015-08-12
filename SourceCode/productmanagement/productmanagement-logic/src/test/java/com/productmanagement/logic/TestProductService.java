package com.productmanagement.logic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productmanagement.model.Product;

public class TestProductService {
	
	private IProductService<Product> productService;
	private Product productToBeDeleted;
	private Product productToBeSaved;
	private Product productToBeUpdated;
	private Product productToBeSearched;
	
	private Product addProduct(String name) throws Exception{
		Product product = new Product();
		product.setName(name);
		Product savedProduct = productService.addProduct(product);
		return savedProduct;
	}

	
	@Before
	public void init() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("productmanagement-logic.xml");
		productService = (IProductService<Product>)context.getBean("productService");
	}
	
	@Test
	public void testAddProduct(){
		Product p = new Product();
		p.setName("TestProduct");
		try {
			productToBeSaved = productService.addProduct(p);
			assertNotNull("AddProduct failed in ProductService", productToBeSaved);
		} catch (Exception e) {
			assertFalse("AddProduct failed in ProductService", true);
		}
	}
	
	@Test
	public void testEditProduct(){
		try {
			productToBeUpdated = addProduct("Update");
			productToBeUpdated.setName("TestUpdate");
			boolean isEdited = productService.editProduct(productToBeUpdated);
			assertTrue("EditProduct failed in ProductService", isEdited);
		} catch (Exception e) {
			assertFalse("EditProduct failed in ProductService", true);
		}
	}
	
	@Test
	public void testDeleteProduct(){
		try {
			productToBeDeleted = addProduct("TestDelete");
			boolean isDeleted = productService.deleteProduct(productToBeDeleted);
			assertTrue("DeleteProduct failed in ProductService", isDeleted);
		} catch (Exception e) {
			assertFalse("DeleteProduct failed in ProductService", true);
		}
	}
	
	@Test
	public void testGetProductById(){
		try {
			productToBeSearched = addProduct("forSearch");
			Product product = productService.getProductById(String.valueOf(productToBeSearched.getId()));
			assertNotNull("GetProductById failed in ProductService", product);
		} catch (IndexOutOfBoundsException e) {
			assertFalse("GetProductById failed in ProductService",true);
		} catch (Exception e){
			assertFalse("GetProductById failed in ProductService",true);
		}
		
	}
	
	@After
	public void tearDown() throws Exception{
		productService.deleteProduct(productToBeSaved);
		productService.deleteProduct(productToBeUpdated);
		productService.deleteProduct(productToBeSearched);
	}
}
