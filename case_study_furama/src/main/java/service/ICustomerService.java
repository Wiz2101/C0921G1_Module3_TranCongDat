package service;

import bean.Customer;
import bean.CustomerType;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerService {
    public Map<String, String> createCustomer(Customer customer) throws SQLException;
    public void deleteCustomer (int id) throws SQLException;
    public Map<String,String> updateCustomer (Customer customer) throws SQLException;
    public List<Customer> displayAllCustomer();
    public Customer selectCustomerById(int id);
    public List<CustomerType> selectCustomerType ();
    public List<Customer> searchByName(String keyword);
}
