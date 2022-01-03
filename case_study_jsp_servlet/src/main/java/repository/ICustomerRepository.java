package repository;

import bean.Customer;
import bean.Customer;
import bean.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomers();

    public boolean deleteCustomer(int id) throws SQLException;

    public void updateCustomer(Customer customer) throws SQLException;

    public List<Customer> searchByCountry(String country);

    public List<Customer> sortList(String sortValue);

    public List<CustomerType> customerTypes();
}

