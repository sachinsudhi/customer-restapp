package trng.springweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trng.springweb.model.Customer;
import trng.springweb.bean.ReportBean;
import trng.springweb.repository.CustomerDao;


@Service
public class CustomerServiceImplementation implements CustomerService {
	@Autowired
	CustomerDao cdao;
	public CustomerServiceImplementation() {
	 super();
	}

	@Override
	public boolean addCustomer(Customer customer) {
		return cdao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return cdao.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return cdao.updateCustomer(customer);
	}

	@Override
	public Customer loadCustomer(int customerId) {
		return cdao.loadCustomer(customerId);
	}

	@Override
	public List<Customer> getCustomers(String zipCode) {
		return cdao.getCustomers(zipCode);
	}

	@Override
	public Map<String, Double> getMonthlySales(int year) {
		return cdao.getMonthlySales(year);
	}

	@Override
	public List<ReportBean> getReport(int month) {
		return cdao.getReport(month);
	}

}