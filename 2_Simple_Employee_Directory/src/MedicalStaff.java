abstract class MedicalStaff extends UABPerson{

    public String getMedicalRole() {
        return medicalRole;
    }

    public void setMedicalRole(String medicalRole) {
        this.medicalRole = medicalRole;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String medicalRole, department;
    MedicalStaff(String role, String firstName, String lastName, String blazerID, String medicalRole, String department) {
        super(role, firstName, lastName, blazerID);
        this.medicalRole = medicalRole;
        this.department = department;
    }
}
