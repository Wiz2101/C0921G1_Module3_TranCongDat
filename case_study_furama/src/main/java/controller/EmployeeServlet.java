package controller;

import bean.*;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        try {
            switch (action){
                case "create":
                    createEmployee(request,response);
                    break;
                case "edit":
                    editEmployee(request,response);
                    break;
                default:
                    displayAllEmployee(request,response);
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
        try{
            switch (action){
                case "create":
                    showCreateForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "delete":
                    deleteEmployee(request,response);
                default:
                    displayAllEmployee(request,response);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void displayAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Employee> employeeList = employeeService.displayAllEmployee();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/view.jsp");
        dispatcher.forward(request,response);
    }

    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Position> positionList = employeeService.selectPosition();
        List<EducationDegree> educationDegreeList = employeeService.selectEducationDegree();
        List<Division> divisionList = employeeService.selectDivision();
        List<User> userList = employeeService.selectUser();
        request.setAttribute("positionList",positionList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("userList",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/create.jsp");
        dispatcher.forward(request,response);
    }

    public void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int position = Integer.parseInt(request.getParameter("position"));
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        int division = Integer.parseInt(request.getParameter("division"));
        String user = request.getParameter("user");

        Employee employee = new Employee(employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail,employeeAddress,new Position(position),new EducationDegree(educationDegree),new Division(division),new User(user));
        employeeService.createEmployee(employee);
        response.sendRedirect("/employee");
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.selectEmployeeById(id);
        List<Position> positionList = employeeService.selectPosition();
        List<EducationDegree> educationDegreeList = employeeService.selectEducationDegree();
        List<Division> divisionList = employeeService.selectDivision();
        List<User> userList = employeeService.selectUser();
        request.setAttribute("employee",employee);
        request.setAttribute("positionList",positionList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("userList",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/edit.jsp");
        dispatcher.forward(request,response);
    }

    public void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int position = Integer.parseInt(request.getParameter("position"));
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        int division = Integer.parseInt(request.getParameter("division"));
        String user = request.getParameter("user");

        Employee employee = new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail,employeeAddress,new Position(position),new EducationDegree(educationDegree),new Division(division),new User(user));
        employeeService.updateEmployee(employee);
        response.sendRedirect("/employee");
    }

    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
    }
}
