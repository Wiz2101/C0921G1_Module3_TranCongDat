package controller;

import bean.MedicalRecord;
import bean.Patient;
import repository.BaseRepository;
import service.IMedicalRecordServ;
import service.impl.MedicalRecordServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MedicalRecordServlet", urlPatterns = "/medical_records")
public class MedicalRecordServlet extends HttpServlet {

    IMedicalRecordServ medicalRecordServ = new MedicalRecordServ();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "home":
                    goToHomepage(request, response);
                    break;
                case "create":
                    createMedicalRecord(request, response);
                    break;
                case "edit":
                    editMedicalRecord(request, response);
                    break;
                default:
                    displayAllMedicalRecords(request, response);
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
                case "home":
                    goToHomepage(request, response);
                    break;
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteMedicalRecord(request,response);
                    break;
                default:
                    displayAllMedicalRecords(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void goToHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    public void displayAllMedicalRecords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<MedicalRecord> medicalRecordslList = medicalRecordServ.displayAllMedicalRecords();
        request.setAttribute("medicalRecordslList", medicalRecordslList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/medical_records/display.jsp");
        dispatcher.forward(request, response);
    }

    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/medical_records/create.jsp");
        dispatcher.forward(request, response);
    }

    public void createMedicalRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String medicalRecordCode = request.getParameter("medicalRecordCode");
        String patientName = request.getParameter("patientName");
        String patientCode = request.getParameter("patientCode");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String reason = request.getParameter("reason");
        int patientId = 0;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("SELECT MAX(patient_id) FROM patient;");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                patientId = rs.getInt("MAX(patient_id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        MedicalRecord medicalRecord = new MedicalRecord(medicalRecordCode, new Patient(patientId,patientCode, patientName), startDate, endDate, reason);
        medicalRecordServ.createMedicalRecord(medicalRecord);
        response.sendRedirect("/medical_records");
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MedicalRecord medicalRecord = medicalRecordServ.selectMedicalRecordById(id);
        List<Patient> patientList = medicalRecordServ.showPatientList();
        request.setAttribute("medicalRecord", medicalRecord);
        request.setAttribute("patientList", patientList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/medical_records/edit.jsp");
        dispatcher.forward(request, response);
    }

    public void editMedicalRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int medicalRecordId = Integer.parseInt(request.getParameter("medicalRecordId"));
        String medicalRecordCode = request.getParameter("medicalRecordCode");
        String patientName = request.getParameter("patientName");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String reason = request.getParameter("reason");
        MedicalRecord medicalRecord = new MedicalRecord(medicalRecordId, medicalRecordCode, new Patient(patientId, patientName), startDate, endDate, reason);
        medicalRecordServ.editMedicalRecord(medicalRecord);
        response.sendRedirect("/medical_records");
    }

    public void deleteMedicalRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int medicalRecordId = Integer.parseInt(request.getParameter("id"));
        medicalRecordServ.deleteMedicalRecord(medicalRecordId);
        response.sendRedirect("/medical_records");
    }
}
