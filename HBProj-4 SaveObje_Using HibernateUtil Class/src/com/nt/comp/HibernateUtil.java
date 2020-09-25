package com.nt.comp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory = null;
	static {
		Configuration cfg = null;
		try {
			// bootstrap hibernate
			cfg = new Configuration();
			// input to HB config file
			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			// craeate session factory obj
			factory = cfg.buildSessionFactory();

		}// try
		catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}// catch
	}
	
	public static Session getSession() {
		if(factory!=null) 
			return factory.openSession();
		else
			return null;
	}//get session method
	
	public static void closeSession(Session ses){
		if(ses!=null)
			ses.close();
	}//close session
		
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}//close factory

}
