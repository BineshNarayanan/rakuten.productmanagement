package com.productmanagement.persistence.dao;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productmanagement.model.Product;
import com.productmanagement.persistence.dao.impl.ProductDao;

public class TestProductDao {
	
	private IProductDao<Product> productDao;
	private Product productToBeDeleted;
	private Product productToBeUpdated;
	private Product productToBeSaved;
	
	
	private Product addProduct(String name) throws Exception{
		Product product = new Product();
		product.setName(name);
		Product savedProduct = productDao.save(product);
		return savedProduct;
	}
	
	@Before
	public void init() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("productmanagement-persistence.xml");
		productDao = (ProductDao<Product>)context.getBean("productDao");
	}
	
	@Test
	public void testDelete() {
		try {
			productToBeDeleted = addProduct("TestDelete");
			productDao.delete(productToBeDeleted);
		} catch (Exception e) {
			assertFalse("ProductDao Delete fails", true);
		}
	}
	
	@Test
	public void testSave(){
		try {
			Product productObj = addProduct("TestSave");
			productToBeSaved = productDao.save(productObj);
		} catch (Exception e) {
			assertFalse("ProductDao Save fails", true);
		}
	}
	
	@Test
	public void testUpdate(){
		try {
			Product productObj = addProduct("TestingUpdate");
			productToBeUpdated = productDao.save(productObj);

			Product product = productDao.getById(String.valueOf(productToBeUpdated.getId()));
			if(null != product){
				product.setName("P2");
				productDao.update(product);	
			}
		} catch (Exception e) {
			assertFalse("ProductDao Update fails", true);
		}
	}
	
	@After
	public void tearDown() throws Exception {
		productDao.delete(productToBeSaved);
		productDao.delete(productToBeUpdated);
	}
	
}
