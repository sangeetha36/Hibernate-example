package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Customer;

public class CustomerDao {

	public void addInDatabase(Customer customer) {
		//Step 1.Load /create EntityManagerFactory object
		//In this step, META-INF/persistence.xml is read
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		
		//Step 2.Load/create EntityManager object
		EntityManager em=emf.createEntityManager();
		
		//Step 3.Start/Participate in a transaction
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		//Now we can insert/update/delete/select as we want
		em.persist(customer); //persist method generates insert query
		et.commit();
		
		//below code should be in finally block
		em.close();
		emf.close();
		
	}
	public  List<Customer> fetch() {   //fetch all the records in the table
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		//Customer c=em.find(Customer.class, id); // find method generates select query
		
		
		//introducing the JP-QL/HQL
		Query q =  em.createQuery("select  c from Customer as c");
				List<Customer> list = q.getResultList();
		
				em.close();
		emf.close();
		return list;
	}
		
		public  List<Customer> fetchCustomerByEmail(String email) {   
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		Query q =  em.createQuery("select  c from Customer as c where c.email like :em");
		q.setParameter("em","%" +email +"%");
		//q.setParameter(1,email);       //instead of :em use ? in the above query 
		
	    List<Customer> list = q.getResultList();
		
	    em.close();
		emf.close();
		return list;
		
		
		
	}
	public void update(Customer cust) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		em.merge(cust);
		et.commit();
		
		em.close();
		emf.close();
		
	}
	public void delete(List<Customer> c) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		em.remove(c);
		et.commit();
		
		em.close();
		emf.close();
		
	}
}
