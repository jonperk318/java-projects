public class Advisor extends UABPerson{

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    private String department, group;
    Advisor(String role, String firstName, String lastName, String blazerID, String department, String group) {
        super(role, firstName, lastName, blazerID);
        this.department = department;
        this.group = group;
    }

    @Override
    public String toString() {
        return ("Name: " + getFirstName() + " " + getLastName() + "  " + "BlazerID: " + getBlazerID() + "  " +
                "Department: " + getDepartment() + "  " + "Group: " + getGroup());
    }
}
