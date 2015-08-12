package com.productmanagement.persistence.dao;

import com.productmanagement.filter.ProductFilter;
import com.productmanagement.model.collection.Products;


public interface IProductDao<Product> extends IGenericDao<Product> {
	
	/**
	 * Retrieves a product on the basis of id.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Product getById(String id) throws Exception;
	
	/**
	 * Retrieves a Products list on the basis of filter applied.
	 * @param filter
	 * @return
	 * @throws Exception
	 */
	public Products list(ProductFilter filter) throws Exception;
}
