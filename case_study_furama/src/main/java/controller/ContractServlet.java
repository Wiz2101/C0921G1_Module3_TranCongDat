package controller;

import bean.Contract;
import bean.Customer;
import bean.Employee;
import bean.Service;
import service.IContractService;
import service.impl.ContractService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {

    IContractService contractService = new ContractService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        try {
            switch (action){
                case "create":
                    createContract(request,response);
                    break;
                default:
                    displayAllContract(request,response);
                    break;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        try {
            switch (action){
                case "create":
                    showCreateForm(request,response);
                    break;
                default:
                    displayAllContract(request,response);
                    break;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayAllContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Contract> contractList = contractService.displayAllContract();
        List<Employee> employeeList = contractService.selectEmployee();
        List<Customer> customerList = contractService.selectCustomer();
        List<Service> serviceList = contractService.selectService();
        request.setAttribute("contractList",contractList);
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract/view.jsp");
        dispatcher.forward(request,response);
    }

    public void showCreateForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee> employeeList = contractService.selectEmployee();
        List<Customer> customerList = contractService.selectCustomer();
        List<Service> serviceList = contractService.selectService();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("customerList",customerList);
        request.setAttribute("serviceList",serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract/create.jsp");
        dispatcher.forward(request,response);
    }

    public void createContract (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String contractStartDate = request.getParameter("contractStartDate");
        String contractEndDate = request.getParameter("contractEndDate");
        double contractDeposit = Double.parseDouble(request.getParameter("contractDeposit"));
        double contractTotalMoney = Double.parseDouble(request.getParameter("contractTotalMoney"));
        int employee = Integer.parseInt(request.getParameter("employee"));
        int customer = Integer.parseInt(request.getParameter("customer"));
        int service = Integer.parseInt(request.getParameter("service"));

        Contract contract = new Contract(contractStartDate,contractEndDate,contractDeposit,contractTotalMoney,new Employee(employee),new Customer(customer),new Service(service));
        contractService.createContract(contract);
        response.sendRedirect("/contract");
    }
}
