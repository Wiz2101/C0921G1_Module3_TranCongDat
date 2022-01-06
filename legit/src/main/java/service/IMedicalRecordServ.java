package service;

import bean.MedicalRecord;
import bean.Patient;

import java.util.List;

public interface IMedicalRecordServ {
    public List<MedicalRecord> displayAllMedicalRecords();
    public void createMedicalRecord(MedicalRecord medicalRecord);
    public MedicalRecord selectMedicalRecordById(int id);
    public void editMedicalRecord(MedicalRecord medicalRecord);
    public List<Patient> showPatientList();
    public void deleteMedicalRecord(int id);
}
