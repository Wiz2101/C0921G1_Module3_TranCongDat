package service.impl;

import bean.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        this.iCustomerRepository.insertCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return this.iCustomerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return this.iCustomerRepository.selectAllCustomers();
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return this.iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return this.iCustomerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> searchByCountry(String country) {
        return null;
    }

    @Override
    public List<Customer> sortList(String sortValue) {
        return null;
    }
}
