package controller;

import bean.RentType;
import bean.Service;
import bean.ServiceType;
import service.IServiceService;
import service.impl.ServiceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {

    IServiceService serviceService = new ServiceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    createService(request, response);
                    break;
                case "edit":
                    editService(request, response);
                    break;
                default:
                    serviceList(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteService(request, response);
                default:
                    serviceList(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void serviceList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceService.displayAllService();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/service/view.jsp");
        dispatcher.forward(request, response);
    }

    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ServiceType> serviceTypeList = serviceService.selectServiceType();
        List<RentType> rentTypeList = serviceService.selectRentType();
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/service/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String serviceIdName = request.getParameter("serviceIdName");
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        String standardRoom = request.getParameter("standardRoom");
        String otherDescription = request.getParameter("otherDiscription");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(serviceIdName, serviceName, serviceArea, serviceCost, serviceMaxPeople, new RentType(rentType), new ServiceType(serviceType), standardRoom, otherDescription, poolArea, numberOfFloors);
        Map<String, String> msgMap = serviceService.createService(service);
        request.setAttribute("serviceIdName", msgMap.get("serviceIdName"));
        if (msgMap.isEmpty()) {
            serviceService.createService(service);
            response.sendRedirect("/service");
        } else {
            showCreateForm(request, response);
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceService.selectServiceById(id);
        List<ServiceType> serviceTypeList = serviceService.selectServiceType();
        List<RentType> rentTypeList = serviceService.selectRentType();
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("service", service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/service/edit.jsp");
        dispatcher.forward(request, response);
    }

    public void editService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        String serviceIdName = request.getParameter("serviceIdName");
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentType = Integer.parseInt(request.getParameter("rentType"));
        int serviceType = Integer.parseInt(request.getParameter("serviceType"));
        String standardRoom = request.getParameter("standardRoom");
        String otherDiscription = request.getParameter("otherDiscription");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(serviceId, serviceIdName, serviceName, serviceArea, serviceCost, serviceMaxPeople, new RentType(rentType), new ServiceType(serviceType), standardRoom, otherDiscription, poolArea, numberOfFloors);
        Map<String, String> msgMap = serviceService.createService(service);
        request.setAttribute("serviceIdName", msgMap.get("serviceIdName"));
        if (msgMap.isEmpty()) {
            serviceService.updateService(service);
            response.sendRedirect("/service");
        } else {
            showEditForm(request, response);
        }

    }

    public void deleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceService.deleteService(id);
    }
}
