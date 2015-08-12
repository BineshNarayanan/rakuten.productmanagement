package com.productmanagement.logic;

import com.productmanagement.persistence.dao.IGenericDao;

public abstract class AbstractService<T> {
	
	private IGenericDao<T> genericDao;
	
	public AbstractService(IGenericDao<T> genericDaoObj){
		this.genericDao = genericDaoObj;
	}

	public IGenericDao<T> getGenericDao() {
		return genericDao;
	}
}
