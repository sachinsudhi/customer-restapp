package trng.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trng.springweb.model.Customer;
import trng.springweb.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService cserv;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST)
	public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
		boolean res = cserv.addCustomer(customer);
		if (res)
			return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
		else
			return new ResponseEntity<Customer>(customer, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@RequestMapping(value = "/delete/{customerId}", method = RequestMethod.DELETE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId) {
		boolean res = cserv.deleteCustomer(customerId);
		if (res)
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		boolean res = cserv.updateCustomer(customer);
		if (res)
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<Customer> loadCustomer(@PathVariable int customerId) {
		Customer customer = cserv.loadCustomer(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
