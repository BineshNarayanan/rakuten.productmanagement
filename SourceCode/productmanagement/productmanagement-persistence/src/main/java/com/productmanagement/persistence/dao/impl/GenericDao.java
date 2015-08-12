package com.productmanagement.persistence.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.productmanagement.persistence.dao.IGenericDao;
import com.productmanagement.utils.LoggerUtils;

public class GenericDao<T> implements IGenericDao<T> {
	
	private LoggerUtils logger = new LoggerUtils(GenericDao.class);
	private HibernateTemplate hibernateTemplate;
	
	public GenericDao(HibernateTemplate objHibernateTemplate){
		this.hibernateTemplate = objHibernateTemplate;
	}

	public T save(final T obj) throws Exception {
		logger.log("In save");
		HibernateCallback callback = new HibernateCallback()
		{

			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				session.save(obj);
				return obj;
			}
		};
		T object = (T) hibernateTemplate.execute(callback);
		return object;
	}

	public boolean delete(final T obj) throws Exception {
		logger.log("In delete");
		boolean isDeleted = true;
		HibernateCallback callback = new HibernateCallback()
		{

			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				session.delete(obj);
				return obj;
			}
		};
		try {
			hibernateTemplate.execute(callback);	
		} catch (Exception e) {
			//No Rows Deleted
			isDeleted = false;
		}
		return isDeleted;
	}

	public boolean update(final T obj) throws Exception {
		logger.log("In update");
		HibernateCallback callback = new HibernateCallback()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				session.update(obj);
				return obj;
			}
		};
		try {
			hibernateTemplate.execute(callback);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

}
