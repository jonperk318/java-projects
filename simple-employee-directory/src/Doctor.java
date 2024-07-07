public class Doctor extends MedicalStaff{
    Doctor(String role, String firstName, String lastName, String blazerID, String medicalRole, String department) {
        super(role, firstName, lastName, blazerID, medicalRole, department);
    }

    @Override
    public String toString() {
        return ("Name: " + getFirstName() + " " + getLastName() + "  " + "BlazerID: " + getBlazerID() + "  " +
                "Role: " + getMedicalRole() + "  " + "Department: " + getDepartment());
    }
}
