package trng.springbean.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trng.springweb.model.Address;
import trng.springweb.model.Customer;
import trng.springweb.service.CustomerService;

public class RestServicesTest {
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
			trng.springweb.config.AppConfig.class);
	CustomerService cserv = applicationContext.getBean(CustomerService.class);

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void InsertTest() {
		Customer customer = new Customer();
		assertTrue(cserv.addCustomer(customer));
	}

	@Test
	public void InsertTest2() {
		Address address = new Address("street", "city", "state", "zip", "country", "street", "city", "state", "zip",
				"country");
		Customer customer = new Customer("cfname205", "cmname455", "clname756", address);
		assertTrue(cserv.addCustomer(customer));
	}

	@Test
	public void updateTest() {
		Customer customer = new Customer(1890, "test", "test2", "test3");
		assertFalse(cserv.updateCustomer(customer));
	}

	@Test
	public void updateTest2() {
		Address address = new Address("streettest", "city", "state", "zip", "country", "street", "city", "state", "zip",
				"country");
		Customer customer = new Customer("cfnametest", "cmname", "clname", address);
		assertFalse(cserv.updateCustomer(customer));
	}
	

	@Test
	public void loadTest2() {
		Customer c=cserv.loadCustomer(8000);
		assertEquals(null,c);

	}


	@Test
	public void deleteTest2() {

		assertFalse(cserv.deleteCustomer(8000));

	}

}
