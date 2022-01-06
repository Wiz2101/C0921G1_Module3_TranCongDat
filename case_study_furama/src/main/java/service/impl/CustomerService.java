package service.impl;

import bean.Customer;
import bean.CustomerType;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;
import validate.Validates;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {

    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public Map<String, String> createCustomer(Customer customer) throws SQLException {
        Map<String, String> messageMap = new HashMap<>();

        if (!Validates.customerIdName(customer.getCustomerIdName())) {
            messageMap.put("customerIdName", "Invalid! Customer Name ID must be KH-XXXXX");
        }
        if (!Validates.phoneNumber(customer.getCustomerPhone())) {
            messageMap.put("customerPhoneNumber", "Invalid! PhoneNumber must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if (!Validates.idCard(customer.getCustomerIdCard())){
            messageMap.put("customerIdCard", "Invalid! CustomerIdCard must have 9 or 12 digits");
        }
        if (!Validates.email(customer.getCustomerEmail())){
            messageMap.put("customerEmail","Invalid! CustomerEmail must follow the format: example@domain.com");
        }

        if (messageMap.isEmpty()) {
            this.customerRepository.createCustomer(customer);
        }
        return messageMap;
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        this.customerRepository.deleteCustomer(id);
    }

    @Override
    public Map<String, String> updateCustomer(Customer customer) throws SQLException {
        Map<String, String> messageMap = new HashMap<>();

        if (!Validates.customerIdName(customer.getCustomerIdName())) {
            messageMap.put("customerIdName", "Invalid Customer Name ID");
        }
        if (!Validates.phoneNumber(customer.getCustomerPhone())) {
            messageMap.put("customerPhoneNumber", "Invalid! PhoneNumber must be 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if (!Validates.idCard(customer.getCustomerIdCard())){
            messageMap.put("customerIdCard", "Invalid! CustomerIdCard must have 9 or 12 digits");
        }
        if (!Validates.email(customer.getCustomerEmail())){
            messageMap.put("customerEmail","Invalid! CustomerEmail must follow the format: example@domain.com");
        }
        if (messageMap.isEmpty()) {
            this.customerRepository.updateCustomer(customer);
        }
        return messageMap;
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
