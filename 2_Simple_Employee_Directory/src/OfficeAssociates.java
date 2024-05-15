public class OfficeAssociates extends UABPerson{

    public String getOfficeRole() {
        return officeRole;
    }

    public void setOfficeRole(String officeRole) {
        this.officeRole = officeRole;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String officeRole, department;
    OfficeAssociates(String role, String firstName, String lastName, String blazerID, String officeRole, String department) {
        super(role, firstName, lastName, blazerID);
        this.officeRole = officeRole;
        this.department = department;
    }

    @Override
    public String toString() {
        return ("Name: " + getFirstName() + " " + getLastName() + "  " + "BlazerID: " + getBlazerID() + "  " +
                "Role: " + getOfficeRole() + "  " + "Department: " + getDepartment());
    }
}
