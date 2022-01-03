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
    private static final String SELECT_ALL_CUSTOMER_SQL = "SELECT * FROM customer JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id WHERE customer_status = 1";
    private static final String INSERT_NEW_CUSTOMER_SQL = "INSERT INTO customer (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_status) VALUES (?,?,?,?,?,?,?,?,1)";
    private static final String SELECT_CUSTOMER_TYPE_SQL = "SELECT * FROM customer_type";
    private static final String SELECT_CUSTOMER_BY_ID_SQL = "SELECT * FROM customer JOIN customer_type ON customer_type.customer_type_id = customer.customer_type_id WHERE customer_id=?";
    private static final String UPDATE_CUSTOMER_BY_ID_SQL = "UPDATE customer SET customer_type_id= ?, customer_name= ?, customer_birthday= ?, customer_gender= ?, customer_id_card= ?, customer_phone= ?, customer_email= ?, customer_address= ? WHERE customer_id = ?";
    private static final String DELETE_CUSTOMER_BY_ID_SQL = "UPDATE customer SET customer_status = 0 WHERE customer_id = ?";
    private static final String SEARCH_CUSTOMER_BY_NAME_SQL = "SELECT * FROM customer WHERE customer_name LIKE ?";

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_NEW_CUSTOMER_SQL);
            preparedStatement.setInt(1, customer.getCustomerType().getCustomerTypeId());
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
    public void deleteCustomer(int id) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(DELETE_CUSTOMER_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(UPDATE_CUSTOMER_BY_ID_SQL);
            preparedStatement.setInt(1, customer.getCustomerType().getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, Integer.parseInt(customer.getCustomerGender()));
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Customer> displayAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_CUSTOMER_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customerList.add(new Customer(rs.getInt("customer_id"), new CustomerType(rs.getInt("customer_type_id"), rs.getString("customer_type_name")), rs.getString("customer_name"), rs.getString("customer_birthday"), rs.getString("customer_gender"), rs.getString("customer_id_card"), rs.getString("customer_phone"), rs.getString("customer_email"), rs.getString("customer_address")));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;
    }

    @Override
    public Customer selectCustomerById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getInt("customer_id"), new CustomerType(rs.getInt("customer_type_id"), rs.getString("customer_type_name")), rs.getString("customer_name"), rs.getString("customer_birthday"), rs.getString("customer_gender"), rs.getString("customer_id_card"), rs.getString("customer_phone"), rs.getString("customer_email"), rs.getString("customer_address"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    public List<CustomerType> selectCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_TYPE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customerTypeList.add(new CustomerType(rs.getInt("customer_type_id"), rs.getString("customer_type_name")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerTypeList;
    }

    @Override
    public List<Customer> searchByName(String keyword) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SEARCH_CUSTOMER_BY_NAME_SQL);
            preparedStatement.setString(1,"%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                customerList.add(new Customer(rs.getInt("customer_id"),new CustomerType(rs.getInt("customer_type_id")),rs.getString("customer_name"),rs.getString("customer_birthday"),rs.getString("customer_gender"),rs.getString("customer_id_card"),rs.getString("customer_phone"),rs.getString("customer_email"),rs.getString("customer_address")));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return customerList;
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
