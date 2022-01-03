package service.impl;

import bean.RentType;
import bean.Service;
import bean.ServiceType;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import service.IServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceService implements IServiceService {

    IServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public void createService(Service service) throws SQLException {
        this.serviceRepository.createService(service);
    }

    @Override
    public void deleteService(int id) throws SQLException {
        this.serviceRepository.deleteService(id);
    }

    @Override
    public void updateService(Service service) throws SQLException {
        this.serviceRepository.updateService(service);
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
