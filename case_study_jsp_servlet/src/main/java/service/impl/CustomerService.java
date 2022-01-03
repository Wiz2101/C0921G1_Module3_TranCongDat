package service.impl;

import bean.Customer;
import bean.CustomerType;
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
        List<Customer> customerList = iCustomerRepository.selectAllCustomers();
        for (Customer cu:customerList){
            if (cu.getCustomerGender().equals("1")){
                cu.setCustomerGender("Male");
            } else if (cu.getCustomerGender().equals("0")){
                cu.setCustomerGender("Female");
            }
        }

        for (Customer cuType:customerList){
            if (cuType.getCustomerTypeId().equals("1")){
                cuType.setCustomerTypeId("Diamond");
            } else if (cuType.getCustomerTypeId().equals("2")){
                cuType.setCustomerTypeId("Platinum");
            } else if (cuType.getCustomerTypeId().equals("3")){
                cuType.setCustomerTypeId("Gold");
            } else if (cuType.getCustomerTypeId().equals("4")){
                cuType.setCustomerTypeId("Silver");
            } else if (cuType.getCustomerTypeId().equals("5")){
                cuType.setCustomerTypeId("Member");
            }
        }
        return customerList;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return this.iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        this.iCustomerRepository.updateCustomer(customer);
    }

    public List<CustomerType> customerTypes() {
        return this.iCustomerRepository.customerTypes();
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
