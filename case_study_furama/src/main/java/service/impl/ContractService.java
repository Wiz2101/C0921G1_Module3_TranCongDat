package service.impl;

import bean.Contract;
import bean.Customer;
import bean.Employee;
import bean.Service;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractService implements IContractService {

    IContractRepository contractRepository = new ContractRepository();
    @Override
    public void createContract(Contract contract) throws SQLException {
        this.contractRepository.createContract(contract);
    }

    @Override
    public List<Contract> displayAllContract() {
        return this.contractRepository.displayAllContract();
    }

    @Override
    public List<Employee> selectEmployee() {
        return this.contractRepository.selectEmployee();
    }

    @Override
    public List<Customer> selectCustomer() {
        return this.contractRepository.selectCustomer();
    }

    @Override
    public List<Service> selectService() {
        return this.contractRepository.selectService();
    }
}
