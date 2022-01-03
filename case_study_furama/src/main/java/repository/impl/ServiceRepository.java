package repository.impl;

import bean.RentType;
import bean.Service;
import bean.ServiceType;
import repository.IServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {

    private static final String SELECT_ALL_SERVICE_SQL = "SELECT * FROM service LEFT JOIN rent_type ON rent_type.rent_type_id = service.rent_type_id LEFT JOIN service_type ON service_type.service_type_id = service.service_type_id WHERE service_status = 1";
    private static final String SELECT_RENT_TYPE_SQL = "SELECT * FROM rent_type";
    private static final String SELECT_SERVICE_TYPE_SQL = "SELECT * FROM service_type";
    private static final String INSERT_INTO_SERVICE_SQL = "INSERT INTO service (service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_SERVICE_BY_ID_SQL = "SELECT * FROM service LEFT JOIN rent_type ON rent_type.rent_type_id = service.rent_type_id LEFT JOIN service_type ON service_type.service_type_id = service.service_type_id WHERE service_id=?";
    private static final String UPDATE_SERVICE_BY_ID_SQL = "UPDATE service SET service_name = ?,service_area = ?,service_cost = ?,service_max_people = ?,rent_type_id = ?,service_type_id = ?,standard_room = ?,description_other_convenience = ?,pool_area = ?,number_of_floors = ? WHERE service_id = ?";
    private static final String DELETE_SERVICE_BY_ID_SQL = "UPDATE service SET service_status = 0 WHERE service_id = ?";


    @Override
    public void createService(Service service) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(INSERT_INTO_SERVICE_SQL);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServiceArea());
            preparedStatement.setDouble(3, service.getServiceCost());
            preparedStatement.setInt(4, service.getServiceMaxPeople());
            preparedStatement.setInt(5, service.getRentType().getRentTypeId());
            preparedStatement.setInt(6, service.getServiceType().getServiceTypeId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloors());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void deleteService(int id) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(DELETE_SERVICE_BY_ID_SQL);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public void updateService(Service service) throws SQLException {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(UPDATE_SERVICE_BY_ID_SQL);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServiceArea());
            preparedStatement.setDouble(3, service.getServiceCost());
            preparedStatement.setInt(4, service.getServiceMaxPeople());
            preparedStatement.setInt(5, service.getRentType().getRentTypeId());
            preparedStatement.setInt(6, service.getServiceType().getServiceTypeId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloors());
            preparedStatement.setInt(11, service.getServiceId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Service> displayAllService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_SERVICE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                serviceList.add(new Service(rs.getInt("service_id"), rs.getString("service_name"), rs.getInt("service_area"), rs.getDouble("service_cost"), rs.getInt("service_max_people"), new RentType(rs.getInt("rent_type_id"), rs.getString("rent_type_name")), new ServiceType(rs.getInt("service_type_id"), rs.getString("service_type_name")), rs.getString("standard_room"), rs.getString("description_other_convenience"), rs.getDouble("pool_area"), rs.getInt("number_of_floors")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return serviceList;
    }

    @Override
    public List<RentType> selectRentType() {
        List<RentType> rentTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_RENT_TYPE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                rentTypeList.add(new RentType(rs.getInt("rent_type_id"), rs.getString("rent_type_name"), rs.getDouble("rent_cost")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rentTypeList;
    }

    @Override
    public List<ServiceType> selectServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_SERVICE_TYPE_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                serviceTypeList.add(new ServiceType(rs.getInt("service_type_id"), rs.getString("service_type_name")));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return serviceTypeList;
    }

    @Override
    public Service selectServiceById(int id) {
        Service service = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_SERVICE_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                service = new Service(rs.getInt("service_id"),rs.getString("service_name"),rs.getInt("service_area"),rs.getDouble("service_cost"),rs.getInt("service_max_people"),new RentType(rs.getInt("rent_type_id"),rs.getString("rent_type_name")),new ServiceType(rs.getInt("service_type_id"),rs.getString("service_type_name")),rs.getString("standard_room"),rs.getString("description_other_convenience"),rs.getDouble("pool_area"),rs.getInt("number_of_floors"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return service;
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
