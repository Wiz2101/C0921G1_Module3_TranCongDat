package repository.impl;

import bean.Contract;
import bean.Customer;
import bean.Employee;
import bean.Service;
import repository.IContractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {

    private static final String SELECT_ALL_CONTRACT_SQL = "SELECT * FROM contract JOIN employee ON contract.employee_id = employee.employee_id JOIN customer ON contract.customer_id = customer.customer_id JOIN service ON contract.service_id = service.service_id WHERE contract_status = 1";
    private static final String INSERT_CONTRACT_SQL = "INSERT INTO contract (contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) VALUES (?,?,?,?,?,?,?)";
    private static final String SELECT_EMPLOYEE_SQL = "SELECT * FROM employee";
    private static final String SELECT_CUSTOMER_SQL = "SELECT * FROM customer";
    private static final String SELECT_SERVICE_SQL = "SELECT * FROM service";

    @Override
    public void createContract(Contract contract) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_CONTRACT_SQL);
            preparedStatement.setString(1,contract.getContractStartDate());
            preparedStatement.setString(2,contract.getContractEndDate());
            preparedStatement.setDouble(3,contract.getContractDeposit());
            preparedStatement.setDouble(4,contract.getContractTotalMoney());
            preparedStatement.setInt(5,contract.getEmployee().getEmployeeId());
            preparedStatement.setInt(6,contract.getCustomer().getCustomerId());
            preparedStatement.setInt(7,contract.getService().getServiceId());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public List<Contract> displayAllContract() {
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_CONTRACT_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                contractList.add(new Contract(rs.getString("contract_start_date"),rs.getString("contract_end_date"),rs.getDouble("contract_deposit"),rs.getDouble("contract_total_money"),new Employee(rs.getInt("employee_id"),rs.getString("employee_name")),new Customer(rs.getInt("customer_id"),rs.getString("customer_name")),new Service(rs.getInt("service_id"),rs.getString("service_name"))));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return contractList;
    }

    @Override
    public List<Employee> selectEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_EMPLOYEE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                employeeList.add(new Employee(rs.getInt("employee_id"),rs.getString("employee_name")));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return employeeList;
    }

    @Override
    public List<Customer> selectCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                customerList.add(new Customer(rs.getInt("customer_id"),rs.getString("customer_name")));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return customerList;
    }

    @Override
    public List<Service> selectService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_SERVICE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                serviceList.add(new Service(rs.getInt("service_id"),rs.getString("service_name")));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return serviceList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
