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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"","/customer"})
public class CustomerServlet extends HttpServlet {
    ICustomerService iCustomerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);
        try {
            switch (action) {
                case "create":
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
                case "delete":
//                    deleteUser(request, response);
                    break;
                case "search":
//                    searchByCountry(request,response);
                    break;
                case "sort":
//                    sortList(request,response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
//                    deleteUser(request, response);
                    break;
                case "search":
//                    searchByCountry(request,response);
                    break;
                case "sort":
//                    sortList(request,response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        List<CustomerType> customerTypes = iCustomerService.customerTypes();
        request.setAttribute("listCustomerType",customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = iCustomerService.selectCustomer(id);
        List<CustomerType> customerTypes = iCustomerService.customerTypes();
        request.setAttribute("listCustomerType",customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        List<Customer> customerList = iCustomerService.selectAllCustomers();
        request.setAttribute("listCustomer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        String name = request.getParameter("fullName");
        String dOB = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String customerType = request.getParameter("customerType");
        String idCard = request.getParameter("idCard");
        String phoneNum = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(name,dOB,gender,customerType,idCard,phoneNum,email,address);
        iCustomerService.insertCustomer(customer);
        response.sendRedirect("/customer");
    }

    public void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("customerId"));
        String name = request.getParameter("fullName");
        String dOB = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String customerType = request.getParameter("customerType");
        String idCard = request.getParameter("idCard");
        String phoneNum = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id,customerType,name,dOB,gender,idCard,phoneNum,email,address);
        customer.setCustomerTypeId(customerType);
        iCustomerService.updateCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }

}
