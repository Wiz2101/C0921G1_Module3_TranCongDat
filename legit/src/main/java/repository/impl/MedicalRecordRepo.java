package repository.impl;

import bean.MedicalRecord;
import bean.Patient;
import repository.BaseRepository;
import repository.IMedicalRecordRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordRepo implements IMedicalRecordRepo {

    private static final String SELECT_ALL_MEDICAL_RECORDS_SQL = "SELECT * FROM medical_record JOIN patient ON patient.patient_id = medical_record.patient_id  WHERE medical_record_delete_status = 1;";
    private static final String INSERT_MEDICAL_RECORD_SQL = "INSERT INTO medical_record (medical_record_code,start_date,end_date,reason,patient_id) VALUES (?,?,?,?,?);";
    private static final String INSERT_PATIENT_SQL = "INSERT INTO patient (patient_code,patient_name) VALUES (?,?);";
    private static final String SELECT_MEDICAL_RECORD_BY_ID_SQL = "SELECT * FROM medical_record JOIN patient ON patient.patient_id = medical_record.patient_id WHERE medical_record_id = ?;";
    private static final String UPDATE_MEDICAL_RECORD_BY_ID_SQL = "UPDATE medical_record SET start_date= ?,end_date= ?,reason= ? WHERE medical_record_id = ?;";
    private static final String UPDATE_PATIENT_BY_ID_SQL = "UPDATE patient SET patient_name = ? WHERE patient_id = ?;";
    private static final String SELECT_ALL_PATIENT_SQL = "SELECT * FROM patient;";
    private static final String DELETE_MEDICAL_RECORD_BY_ID = "UPDATE medical_record SET medical_record_delete_status = 0 WHERE medical_record_id = ?;";

    @Override
    public List<MedicalRecord> displayAllMedicalRecords() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_MEDICAL_RECORDS_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                medicalRecordList.add(new MedicalRecord(rs.getInt("medical_record_id"), rs.getString("medical_record_code"), new Patient(rs.getInt("patient_id"),rs.getString("patient_code"),rs.getString("patient_name")), rs.getString("start_date"), rs.getString("end_date"), rs.getString("reason"), rs.getInt("medical_record_delete_status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecordList;
    }

    @Override
    public void createMedicalRecord(MedicalRecord medicalRecord) {
        try {
            PreparedStatement preparedStatement1 = BaseRepository.getConnection().prepareStatement(INSERT_MEDICAL_RECORD_SQL);
            PreparedStatement preparedStatement2 = BaseRepository.getConnection().prepareStatement(INSERT_PATIENT_SQL);
            preparedStatement1.setString(1, medicalRecord.getMedicalRecordCode());
            preparedStatement1.setString(2, medicalRecord.getStartDate());
            preparedStatement1.setString(3, medicalRecord.getEndDate());
            preparedStatement1.setString(4, medicalRecord.getReason());
            preparedStatement1.setInt(5, medicalRecord.getPatient().getPatientId());
            preparedStatement2.setString(1,medicalRecord.getPatient().getPatientCode());
            preparedStatement2.setString(2,medicalRecord.getPatient().getPatientName());
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MedicalRecord selectMedicalRecordById(int id) {
        MedicalRecord medicalRecord = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_MEDICAL_RECORD_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                medicalRecord = new MedicalRecord(rs.getInt("medical_record_id"), rs.getString("medical_record_code"), new Patient(rs.getInt("patient_id"), rs.getString("patient_code"), rs.getString("patient_name")), rs.getString("start_date"), rs.getString("end_date"), rs.getString("reason"), rs.getInt("medical_record_delete_status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecord;
    }

    @Override
    public void editMedicalRecord(MedicalRecord medicalRecord) {
        try {
            PreparedStatement preparedStatement1 = BaseRepository.getConnection().prepareStatement(UPDATE_PATIENT_BY_ID_SQL);
            PreparedStatement preparedStatement2 = BaseRepository.getConnection().prepareStatement(UPDATE_MEDICAL_RECORD_BY_ID_SQL);
            preparedStatement1.setString(1,medicalRecord.getPatient().getPatientName());
            preparedStatement1.setInt(2,medicalRecord.getPatient().getPatientId());
            preparedStatement2.setString(1,medicalRecord.getStartDate());
            preparedStatement2.setString(2,medicalRecord.getEndDate());
            preparedStatement2.setString(3,medicalRecord.getReason());
            preparedStatement2.setInt(4,medicalRecord.getMedicalRecordId());
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> showPatientList() {
        List<Patient> patientList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(SELECT_ALL_PATIENT_SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                patientList.add(new Patient(rs.getInt("patient_id"), rs.getString("patient_code"), rs.getString("patient_name"), rs.getInt("patient_delete_status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;
    }

    @Override
    public void deleteMedicalRecord(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(DELETE_MEDICAL_RECORD_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
