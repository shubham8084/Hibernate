package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.entity.Product;

public class SaveObjTest {

	public static void main(String[] args) {
		// declaration
		Configuration cfg = null;
		SessionFactory factory = null;
		Session ses = null;
		Product prod = null;
		Transaction tx=null;
		boolean flag=false;
		// Activate HB f/w
		cfg = new Configuration();
		// supply cfg file
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		// loads hibernate Session factory
		factory = cfg.buildSessionFactory();
		// open session
		ses = factory.openSession();
        // crete Entity obj to save DB
		prod = new Product();
		//prod.setPid(124);// Without using generated value
		prod.setPname("Table");
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
		ses.close();
		//close factory
		factory.close();
		
	}//finally
		
		
		
		
	}

}
