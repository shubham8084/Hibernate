package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public Product getProductDetails(int pid) {
		Session ses=null;
		Product prod=null;
		//get HB Session
		ses=HibernateUtil.getSession();
		//get product
		System.out.println(pid);
		System.out.println(ses);
		prod=ses.get(Product.class,pid);
		System.out.println(prod);
		
		return prod;
	}

}
