package service;

import bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomers();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer user) throws SQLException;

    public List<Customer> searchByCountry(String country);

    public List<Customer> sortList(String sortValue);
}
