package service.impl;

import bean.RentType;
import bean.Service;
import bean.ServiceType;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import service.IServiceService;
import validate.Validates;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceService implements IServiceService {

    IServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public Map<String,String> createService(Service service) throws SQLException {
        Map<String,String> msgMap = new HashMap<>();

        if (!Validates.serviceID(service.getServiceIdName())){
            msgMap.put("serviceIdName","Invalid Service ID Name");
        }
        if (msgMap.isEmpty()) {
            this.serviceRepository.createService(service);
        }
        return msgMap;
    }

    @Override
    public void deleteService(int id) throws SQLException {
        this.serviceRepository.deleteService(id);
    }

    @Override
    public Map<String,String> updateService(Service service) throws SQLException {
        Map<String,String> msgMap = new HashMap<>();

        if (!Validates.serviceID(service.getServiceIdName())){
            msgMap.put("serviceIdName","Invalid Service ID Name");
        }
        if (msgMap.isEmpty()) {
            this.serviceRepository.updateService(service);
        }
        return msgMap;
    }

    @Override
    public List<Service> displayAllService() {
        return this.serviceRepository.displayAllService();
    }

    @Override
    public List<RentType> selectRentType() {
        return this.serviceRepository.selectRentType();
    }

    @Override
    public List<ServiceType> selectServiceType() {
        return this.serviceRepository.selectServiceType();
    }

    @Override
    public Service selectServiceById(int id) {
        return this.serviceRepository.selectServiceById(id);
    }
}
