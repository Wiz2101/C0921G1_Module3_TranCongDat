package controller;

import bean.AttachService;
import bean.Contract;
import bean.ContractDetail;
import service.IContractDetailService;
import service.impl.ContractDetailService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contract_detail")
public class ContractDetailServlet extends HttpServlet {

    IContractDetailService contractDetailService = new ContractDetailService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        try {
            switch (action){
                case "create":
                    createContractDetail(request,response);
                    break;
                default:
                    displayAllContractDetail(request,response);
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
                    displayAllContractDetail(request,response);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void displayAllContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<ContractDetail> contractDetailList = contractDetailService.displayAllContractDetail();
        request.setAttribute("contractDetailList",contractDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract_detail/view.jsp");
        dispatcher.forward(request,response);
    }

    public void showCreateForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Contract> contractList = contractDetailService.selectAllContract();
        List<AttachService> attachServices = contractDetailService.selectAttachService();
        request.setAttribute("contractList",contractList);
        request.setAttribute("attachServices",attachServices);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contract_detail/create.jsp");
        dispatcher.forward(request,response);
    }

    public void createContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int attachServiceId = Integer.parseInt(request.getParameter("attachServiceId"));
        int quality = Integer.parseInt(request.getParameter("quality"));

        ContractDetail contractDetail = new ContractDetail(new Contract(contractId),new AttachService(attachServiceId),quality);
        contractDetailService.createContractDetail(contractDetail);
        response.sendRedirect("/contract_detail");
    }
}
