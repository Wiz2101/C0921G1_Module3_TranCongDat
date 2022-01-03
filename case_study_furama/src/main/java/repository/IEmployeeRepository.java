package repository;

import bean.*;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository {
    public void createEmployee(Employee employee) throws SQLException;
    public void deleteEmployee(int id) throws SQLException;
    public void updateEmployee(Employee employee) throws SQLException;
    public List<Employee> displayAllEmployee();
    public Employee selectEmployeeById(int id);
    public List<Position> selectPosition();
    public List<EducationDegree> selectEducationDegree();
    public List<Division> selectDivision();
    public List<User> selectUser();
    public List<Employee> searchByName(String keyword);
}
