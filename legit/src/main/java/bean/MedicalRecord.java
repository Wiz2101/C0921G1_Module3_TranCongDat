package bean;

public class MedicalRecord {
    int medicalRecordId;
    String medicalRecordCode;
    Patient patient;
    String startDate;
    String endDate;
    String reason;
    int medicalRecordDeleteStatus;

    public MedicalRecord() {
    }

    public MedicalRecord(Patient patient, String startDate, String endDate, String reason) {
        this.patient = patient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public MedicalRecord(int medicalRecordId, String medicalRecordCode, Patient patient, String startDate, String endDate, String reason) {
        this.medicalRecordId = medicalRecordId;
        this.medicalRecordCode = medicalRecordCode;
        this.patient = patient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public MedicalRecord(int medicalRecordId, String medicalRecordCode, Patient patient, String startDate, String endDate, String reason, int medicalRecordDeleteStatus) {
        this.medicalRecordId = medicalRecordId;
        this.medicalRecordCode = medicalRecordCode;
        this.patient = patient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.medicalRecordDeleteStatus = medicalRecordDeleteStatus;
    }

    public MedicalRecord(String medicalRecordCode, Patient patient, String startDate, String endDate, String reason) {
        this.medicalRecordCode = medicalRecordCode;
        this.patient = patient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public String getMedicalRecordCode() {
        return medicalRecordCode;
    }

    public void setMedicalRecordCode(String medicalRecordCode) {
        this.medicalRecordCode = medicalRecordCode;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getMedicalRecordDeleteStatus() {
        return medicalRecordDeleteStatus;
    }

    public void setMedicalRecordDeleteStatus(int medicalRecordDeleteStatus) {
        this.medicalRecordDeleteStatus = medicalRecordDeleteStatus;
    }
}
