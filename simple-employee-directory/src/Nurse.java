public class Nurse extends MedicalStaff{

    public String getOnCall() {
        return onCall;
    }

    public void setOnCall(String onCall) {
        this.onCall = onCall;
    }

    private String onCall;
    Nurse(String role, String firstName, String lastName, String blazerID, String medicalRole, String department, String onCall) {
        super(role, firstName, lastName, blazerID, medicalRole, department);
        this.onCall = onCall;
    }

    @Override
    public String toString() {
        return ("Name: " + getFirstName() + " " + getLastName() + "  " + "BlazerID: " + getBlazerID() + "  " +
                "Role: " + getMedicalRole() + "  " + "Department: " + getDepartment() + "  " + "On Call: " + getOnCall());
    }
}
