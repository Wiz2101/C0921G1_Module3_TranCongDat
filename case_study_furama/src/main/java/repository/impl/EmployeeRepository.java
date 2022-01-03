package repository.impl;

import bean.*;
import repository.IEmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE_SQL = "SELECT * FROM employee JOIN `position` ON `position`.position_id = employee.position_id JOIN education_degree ON education_degree.education_degree_id = employee.education_degree_id JOIN division ON division.division_id = employee.division_id JOIN `user` ON `user`.username = employee.username WHERE employee_status = 1;";
    private static final String SELECT_POSITION_SQL = "SELECT * FROM `position`";
    private static final String SELECT_EDUCATION_DEGREE_SQL = "SELECT * FROM education_degree";
    private static final String SELECT_DIVISION_SQL = "SELECT * FROM division";
    private static final String SELECT_USER_SQL = "SELECT * FROM `user`";
    private static final String INSERT_INTO_EMPLOYEE_SQL = "INSERT INTO employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_INTO_EMPLOYEE_SQL);
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeBirthday());
            preparedStatement.setString(3,employee.getEmployeeIdCard());
            preparedStatement.setDouble(4,employee.getEmployeeSalary());
            preparedStatement.setString(5,employee.getEmployeePhone());
            preparedStatement.setString(6,employee.getEmployeeEmail());
            preparedStatement.setString(7,employee.getEmployeeAddress());
            preparedStatement.setInt(8,employee.getPosition().getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegree().getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivision().getDivisionId());
            preparedStatement.setString(11,employee.getUser().getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {

    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {

    }

    @Override
    public List<Employee> displayAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_EMPLOYEE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employeeList.add(new Employee(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getString("employee_birthday"), rs.getString("employee_id_card"), rs.getDouble("employee_salary"), rs.getString("employee_phone"), rs.getString("employee_email"), rs.getString("employee_address"), new Position(rs.getInt("position_id"),rs.getString("position_name")), new EducationDegree(rs.getInt("education_degree_id"),rs.getString("education_degree_name")), new Division(rs.getInt("division_id"),rs.getString("division_name")), new User("username")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return null;
    }

    @Override
    public List<Position> selectPosition() {
        List<Position> positionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_POSITION_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                positionList.add(new Position(rs.getInt("position_id"),rs.getString("position_name")));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return positionList;
    }

    @Override
    public List<EducationDegree> selectEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_EDUCATION_DEGREE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                educationDegreeList.add(new EducationDegree(rs.getInt("education_degree_id"),rs.getString("education_degree_name")));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return educationDegreeList;
    }

    @Override
    public List<Division> selectDivision() {
        List<Division> divisionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_DIVISION_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                divisionList.add(new Division(rs.getInt("division_id"),rs.getString("division_name")));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return divisionList;
    }

    @Override
    public List<User> selectUser() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_USER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                userList.add(new User(rs.getString("username"),rs.getString("password")));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return userList;
    }

    @Override
    public List<Employee> searchByName(String keyword) {
        return null;
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
