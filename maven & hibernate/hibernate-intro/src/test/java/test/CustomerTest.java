package test;

import java.util.List;

import org.junit.Test;

import dao.CustomerDao;
import model.Customer;

public class CustomerTest {

	@Test
	public void testAdd() {
		Customer c = new Customer();
		c.setName("aaa");
		c.setEmail("aaa.i@yahoo.com");
		c.setCity("aaa");
		// c.setDob(java.sql.Date.valueOf("1997-09-25"));
		CustomerDao dao = new CustomerDao();
		dao.fetch();
	}

	@Test
	public void fetch() {
		//Customer c = new Customer();
		CustomerDao dao = new CustomerDao();
		dao.fetch();
		List<Customer> cu=dao.fetchCustomerByEmail("yahoo");
		for (Customer q:cu) {
		System.out.println(q.getName());
		System.out.println(q.getCity());
		System.out.println(q.getEmail());
		System.out.println(q.getDob());
		}
	}
	@Test
	public void testUpdate() {
		
		CustomerDao dao = new CustomerDao();
		Customer c = (Customer) dao.fetch();
		c.setEmail("ssddd.i@gmail.com");
		c.setCity("Gujarat");
		
		dao.update(c);
	}

	@Test
	public void testDelete() {
		
		CustomerDao dao = new CustomerDao();
		List<Customer> c = dao.fetch();
		
		dao.delete(c);
	}

}
