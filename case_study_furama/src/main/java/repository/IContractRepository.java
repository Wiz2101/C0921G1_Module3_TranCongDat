package repository;

import bean.Contract;
import bean.Customer;
import bean.Employee;
import bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface IContractRepository {
    public void createContract(Contract contract) throws SQLException;
    public List<Contract> displayAllContract();
    public List<Employee> selectEmployee();
    public List<Customer> selectCustomer();
    public List<Service> selectService();

}
