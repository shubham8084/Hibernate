package com.nt.test;

import java.sql.Date;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class ObjectVersoningTest {

	public static void main(String[] args) {
		Session ses = null;
		BankAccount account = null;
		Transaction tx = null;
		boolean flag = false;
		// get session object
		ses = HibernateUtil.getSession();
		account = new BankAccount();
		account.setAccNo(35025);
		account.setHoloderName("Shubham");
		account.setBalance(55555.55f);
				try {
			tx = ses.beginTransaction();
			ses.save(account);
			flag = true;
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // catch
		catch (Exception e) {
			e.printStackTrace();
		} // catch
		finally {
			if (flag) {
				tx.commit();
				System.out.println("Object is Saved");
				System.out.println("Last Upadte::" + account.getLastUpdate());
			} // if
			else {
				tx.rollback();
				System.out.println("Object is not save");
			} // else
				// close Hibernate Connection
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();

		} // finally

	}// main

}// class
