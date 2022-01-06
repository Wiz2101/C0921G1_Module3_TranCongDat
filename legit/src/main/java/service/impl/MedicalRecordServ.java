package service.impl;

import bean.MedicalRecord;
import bean.Patient;
import repository.IMedicalRecordRepo;
import repository.impl.MedicalRecordRepo;
import service.IMedicalRecordServ;

import java.util.List;

public class MedicalRecordServ implements IMedicalRecordServ {

    IMedicalRecordRepo medicalRecordRepo = new MedicalRecordRepo();
    @Override
    public List<MedicalRecord> displayAllMedicalRecords() {
        return this.medicalRecordRepo.displayAllMedicalRecords();
    }

    @Override
    public void createMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecordRepo.createMedicalRecord(medicalRecord);
    }

    @Override
    public MedicalRecord selectMedicalRecordById(int id) {
        return this.medicalRecordRepo.selectMedicalRecordById(id);
    }

    @Override
    public void editMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecordRepo.editMedicalRecord(medicalRecord);
    }

    @Override
    public List<Patient> showPatientList() {
        return this.medicalRecordRepo.showPatientList();
    }

    @Override
    public void deleteMedicalRecord(int id) {
        this.medicalRecordRepo.deleteMedicalRecord(id);
    }
}
