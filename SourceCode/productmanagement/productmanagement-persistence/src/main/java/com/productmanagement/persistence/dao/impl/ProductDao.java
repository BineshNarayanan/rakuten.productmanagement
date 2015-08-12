package com.productmanagement.persistence.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.productmanagement.filter.ProductFilter;
import com.productmanagement.model.collection.Products;
import com.productmanagement.persistence.dao.IProductDao;
import com.productmanagement.utils.LoggerUtils;

public class ProductDao<Product> extends GenericDao<Product> implements IProductDao<Product> {
	
	private LoggerUtils logger = new LoggerUtils(ProductDao.class);
	
	public ProductDao(HibernateTemplate objHibernateTemplate) {
		super(objHibernateTemplate);
	}

	public Product getById(final String id) throws Exception {
		logger.log("In getById");
		HibernateCallback callback = new HibernateCallback()
		{

			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				String queryString = " from Product where Id = "+id;
				Query query = session.createQuery(queryString);
				return query.list().get(0);
			}
		};
		Product product = (Product) super.getHibernateTemplate().execute(callback);
		product = (null == product) ? (Product)(new com.productmanagement.model.Product()) : product;
		return product;
	}

	public Products list(final ProductFilter filter) throws Exception {
		logger.log("In list");
		HibernateCallback callback = new HibernateCallback()
		{

			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				String queryString = " from Product";
				if(null != filter){
					// add filtering criteria
				}
				Query query = session.createQuery(queryString);
				return new Products(query.list());
			}
		};
		return (Products)super.getHibernateTemplate().execute(callback);
	}

}
