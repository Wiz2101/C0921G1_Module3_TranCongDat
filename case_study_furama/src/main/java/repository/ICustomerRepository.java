package repository;

import bean.Customer;
import bean.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    public void createCustomer(Customer customer) throws SQLException;
    public void deleteCustomer(int id) throws SQLException;
    public void updateCustomer(Customer customer) throws SQLException;
    public List<Customer> displayAllCustomer();
    public Customer selectCustomerById(int id);
    public List<CustomerType> selectCustomerType ();
    public List<Customer> searchByName(String keyword);
}
