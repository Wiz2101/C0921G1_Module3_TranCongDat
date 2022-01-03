package service;

import bean.RentType;
import bean.Service;
import bean.ServiceType;

import java.sql.SQLException;
import java.util.List;

public interface IServiceService {
    public void createService(Service service) throws SQLException;
    public void deleteService(int id) throws SQLException;
    public void updateService(Service service) throws SQLException;
    public List<Service> displayAllService();
    public List<RentType> selectRentType();
    public List<ServiceType> selectServiceType();
    public Service selectServiceById(int id);
}
