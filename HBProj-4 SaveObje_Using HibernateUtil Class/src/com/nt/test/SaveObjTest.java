package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.comp.HibernateUtil;
import com.nt.entity.Product;

public class SaveObjTest {

	public static void main(String[] args) {
		
		Session ses = null;
		Product prod = null;
		Transaction tx=null;
		boolean flag=false;
		
		// get session obj
		ses = HibernateUtil.getSession();
        // crete Entity obj to save DB
		prod = new Product();
		//prod.setPid(124);// Without using generated value
		prod.setPname("Chair");
		//prod.setPrice(5500);
		//prod.setQty(15);
try {
	tx=ses.beginTransaction();
	
	int Idval=(int)ses.save(prod);
	System.out.println("Generated IdVal::"+Idval);
	flag=true;
	
	
}//try
  catch(HibernateException he){
	he.printStackTrace();
	flag=false;
}//catch
	finally {
		//commit aur rollback transection
		if(flag==true) {
			tx.commit();
			System.out.println("obj saved to DB.....");
		}else {
			tx.rollback();
			System.out.println("Internal problem obj not save...");
		}
		//cloase session
		HibernateUtil.closeSession(ses);
		
		//close factory
		HibernateUtil.closeSessionFactory();
		
	}//finally
		
		
		
		
	}

}
