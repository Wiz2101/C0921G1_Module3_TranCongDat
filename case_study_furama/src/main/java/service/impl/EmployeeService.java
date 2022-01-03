package service.impl;

import bean.*;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public void createEmployee(Employee employee) throws SQLException {
        this.employeeRepository.createEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        this.employeeRepository.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        this.employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> displayAllEmployee() {
        return this.employeeRepository.displayAllEmployee();
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return this.employeeRepository.selectEmployeeById(id);
    }

    @Override
    public List<Position> selectPosition() {
        return this.employeeRepository.selectPosition();
    }

    @Override
    public List<EducationDegree> selectEducationDegree() {
        return this.employeeRepository.selectEducationDegree();
    }

    @Override
    public List<Division> selectDivision() {
        return this.employeeRepository.selectDivision();
    }

    @Override
    public List<User> selectUser() {
        return this.employeeRepository.selectUser();
    }

    @Override
    public List<Employee> searchByName(String keyword) {
        return this.searchByName(keyword);
    }
}
