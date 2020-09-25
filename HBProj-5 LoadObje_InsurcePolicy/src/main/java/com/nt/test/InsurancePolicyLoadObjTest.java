package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class InsurancePolicyLoadObjTest {

	public static void main(String[] args) {
		
		Session ses=null;
		InsurancePolicy ip=null;
		Transaction tx=null;
	  boolean flag =false;
		
		//get Session obj
		ses=HibernateUtil.getSession();
		//create Entity obj to save DB record
		ip=new InsurancePolicy();
		//set value to DB
		ip.setPolicyId(121);
		ip.setPolicyName("JevanBema");
		ip.setTenure(5);ip.setCompany("LIC"); 
		ip.setType("LifeInsurance");
  try {
	  tx=ses.beginTransaction();
	  
	  ses.save(ip);
	// InsurancePolicy policy=ses.get(InsurancePolicy.class,9001);
	// InsurancePolicy policy=ses.load(InsurancePolicy.class, 121);
	 // System.out.println(policy);
	  flag=true;
	  
  }//try
  catch(HibernateException he)
  {
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
