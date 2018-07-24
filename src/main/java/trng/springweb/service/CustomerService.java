package trng.springweb.service;

import java.util.List;
import java.util.Map;

import trng.springweb.model.Customer;
import trng.springweb.bean.ReportBean;

public interface CustomerService {
	boolean addCustomer(Customer customer);

	boolean deleteCustomer(int customerId);

	boolean updateCustomer(Customer customer);

	Customer loadCustomer(int customerId);

	List<Customer> getCustomers(String zipCode); 

	Map<String, Double> getMonthlySales(int year);

	List<ReportBean> getReport(int month);

}
