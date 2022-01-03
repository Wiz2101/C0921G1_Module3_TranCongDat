package repository.impl;

import bean.Customer;
import bean.CustomerType;
import repository.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SELECT_CUSTOMER_SQL = "SELECT * FROM customer JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id WHERE customer_id = ?;";
    private static final String SELECT_ALL_CUSTOMER_SQL = "SELECT * FROM customer";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customer WHERE id=?";
    private static final String UPDATE_CUSTOMER_SQL = "UPDATE customer SET customer_type_id=?, customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? WHERE id=?" ;
    private static final String SELECT_CUSTOMER_TYPE_SQL = "SELECT * FROM customer_type";

    public CustomerRepository() {
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setInt(1,Integer.parseInt(customer.getCustomerTypeId()));
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, Integer.parseInt(customer.getCustomerGender()));
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getInt("customer_id"), rs.getString("customer_type_id"), rs.getString("customer_name"), rs.getString("customer_birthday"), rs.getString("customer_gender"), rs.getString("customer_id_card"), rs.getString("customer_phone"), rs.getString("customer_email"), rs.getString("customer_address"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_CUSTOMER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customerList.add(new Customer(rs.getInt("customer_id"), rs.getString("customer_type_id"), rs.getString("customer_name"), rs.getString("customer_birthday"), rs.getString("customer_gender"), rs.getString("customer_id_card"), rs.getString("customer_phone"), rs.getString("customer_email"), rs.getString("customer_address")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(UPDATE_CUSTOMER_SQL);
            preparedStatement.setInt(1, Integer.parseInt(customer.getCustomerTypeId()));
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, Integer.parseInt(customer.getCustomerGender()));
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9,customer.getCustomerId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<CustomerType> customerTypes() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_TYPE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                customerTypes.add(new CustomerType(rs.getInt("customer_type_id"), rs.getString("customer_type_name")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerTypes;
    }

    @Override
    public List<Customer> searchByCountry(String country) {
        return null;
    }

    @Override
    public List<Customer> sortList(String sortValue) {
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
