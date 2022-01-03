package controller;

import bean.Customer;
import bean.CustomerType;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"","/customer"})
public class CustomerServlet extends HttpServlet {

    ICustomerService customerService = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createCustomer(request,response);
                    break;
                case "edit":
                    editCustomer(request,response);
                    break;
                default:
                    customerListDisplay(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
                    showCreateCustomer(request,response);
                    break;
                case "edit":
                    showEditCustomer(request,response);
                    break;
                case "delete":
                    deleteCustomer(request,response);
                    break;
                case "search":
                    searchByKeyWord(request,response);
                    break;
                default:
                    customerListDisplay(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void customerListDisplay(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Customer> customerList = customerService.displayAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/view.jsp");
        dispatcher.forward(request, response);
    }

    public void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<CustomerType> customerTypeList = customerService.selectCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request,response);
    }

    public void createCustomer (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String dOB = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String idCard = request.getParameter("idCard");
        String phoneNum = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(new CustomerType(customerType),fullName,dOB,gender,idCard,phoneNum,email,address);
        customerService.createCustomer(customer);
        response.sendRedirect("/customer");
    }

    public void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<CustomerType> customerTypeList = customerService.selectCustomerType();
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomerById(id);
        request.setAttribute("customerById",customer);
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request,response);
    }

    public void editCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullName = request.getParameter("fullName");
        String dOB = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String idCard = request.getParameter("idCard");
        String phoneNum = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id,new CustomerType(customerType),fullName,dOB,gender,idCard,phoneNum,email,address);
        customerService.updateCustomer(customer);
        response.sendRedirect("/customer");
    }

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
    }

    public void searchByKeyWord(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Customer> customerList = customerService.searchByName(keyword);
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/view.jsp");
        dispatcher.forward(request,response);
    }

}
