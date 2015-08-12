package com.productmanagement.logic.impl;

import com.productmanagement.filter.ProductFilter;
import com.productmanagement.logic.AbstractService;
import com.productmanagement.logic.IProductService;
import com.productmanagement.model.collection.Products;
import com.productmanagement.persistence.dao.IProductDao;
import com.productmanagement.utils.LoggerUtils;

public class ProductService<Product> extends AbstractService<Product> implements IProductService<Product> {
	
	private IProductDao<Product> productDao;
	private LoggerUtils logger = new LoggerUtils(ProductService.class);
	
	public ProductService(IProductDao<Product> productDao) {
		super(productDao);
		this.productDao = productDao;
	}

	public Product addProduct(Product product) throws Exception {
		logger.log("In addProduct");
		Product addedProduct = productDao.save(product);
		return addedProduct;
	}

	public boolean editProduct(Product product) throws Exception {
		logger.log("In editProduct");
		boolean isEdited = productDao.update(product);
		return isEdited;
	}

	public boolean deleteProduct(Product product) throws Exception {
		logger.log("In deleteProduct");
		boolean isDeleted = productDao.delete(product);
		return isDeleted;
	}

	public Product getProductById(String id) throws Exception {
		logger.log("In getProductById");
		Product retrievedProduct = productDao.getById(id);
		return retrievedProduct;
	}

	public Products getProducts(ProductFilter filter) throws Exception {
		logger.log("In getProducts");
		return productDao.list(filter);
	}

}
