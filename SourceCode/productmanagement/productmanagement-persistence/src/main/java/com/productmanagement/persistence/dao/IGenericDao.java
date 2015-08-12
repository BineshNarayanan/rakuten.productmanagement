package com.productmanagement.persistence.dao;

public interface IGenericDao<T> {
	/**
	 * Saves the instance passed. 
	 * @param obj
	 */
	public T save(T obj) throws Exception;
	
	/**
	 * Saves the instance passed. 
	 * @param obj
	 */
	public boolean update(T obj) throws Exception;
	
	/**
	 * Deletes the object from database.
	 * @param obj
	 */
	public boolean delete(T obj) throws Exception;
}
