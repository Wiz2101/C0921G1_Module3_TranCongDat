package bean;

public class Patient {
    int patientId;
    String patientCode;
    String patientName;
    int patientDeleteStatus;

    public Patient() {
    }


    public Patient(int patientId) {
        this.patientId = patientId;
    }

    public Patient(String patientCode, String patientName) {
        this.patientCode = patientCode;
        this.patientName = patientName;
    }

    public Patient(int patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }

    public Patient(int patientId, String patientCode, String patientName) {
        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
    }

    public Patient(int patientId, String patientCode, String patientName, int patientDeleteStatus) {
        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.patientDeleteStatus = patientDeleteStatus;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientDeleteStatus() {
        return patientDeleteStatus;
    }

    public void setPatientDeleteStatus(int patientDeleteStatus) {
        this.patientDeleteStatus = patientDeleteStatus;
    }
}
