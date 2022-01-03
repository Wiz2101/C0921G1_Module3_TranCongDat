package service.impl;

import bean.Customer;
import bean.CustomerType;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {

    ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public void createCustomer(Customer customer) throws SQLException {
        this.customerRepository.createCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        this.customerRepository.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        this.customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> displayAllCustomer() {
        return this.customerRepository.displayAllCustomer();
    }

    @Override
    public Customer selectCustomerById(int id) {
        return this.customerRepository.selectCustomerById(id);
    }

    @Override
    public List<CustomerType> selectCustomerType() {
        return this.customerRepository.selectCustomerType();
    }

    @Override
    public List<Customer> searchByName(String keyword) {
        return this.customerRepository.searchByName(keyword);
    }
}
