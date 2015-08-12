package com.productmanagement.logic;

import com.productmanagement.filter.ProductFilter;
import com.productmanagement.model.collection.Products;

public interface IProductService<Product> {
	/**
	 * Adds Product to database.
	 * @param product
	 * @return
	 */
	public Product addProduct(Product product) throws Exception;
	
	/**
	 * Edits the product.
	 * @param product
	 * @return
	 */
	public boolean editProduct(Product product) throws Exception;
	
	/**
	 * Deletes the product from database.
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public boolean deleteProduct(Product product) throws Exception;
	
	/**
	 * Retrieves a product on the basis of id.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Product getProductById(String id) throws Exception;
	
	/**
	 * Retrives a collection of products.
	 * @param filter
	 * @return
	 * @throws Exception
	 */
	public Products getProducts(ProductFilter filter) throws Exception;
}
