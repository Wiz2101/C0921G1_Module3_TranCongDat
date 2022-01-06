package service;

import bean.RentType;
import bean.Service;
import bean.ServiceType;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IServiceService {
    public Map<String,String> createService(Service service) throws SQLException;
    public void deleteService(int id) throws SQLException;
    public Map<String,String> updateService(Service service) throws SQLException;
    public List<Service> displayAllService();
    public List<RentType> selectRentType();
    public List<ServiceType> selectServiceType();
    public Service selectServiceById(int id);
}
