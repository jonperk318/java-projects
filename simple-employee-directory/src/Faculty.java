public class Faculty extends UABPerson{

    private String department;
    private int courses;

    Faculty(String role, String firstName, String lastName, String blazerID, String department, int courses) {
        super(role, firstName, lastName, blazerID);
        this.department = department;
        this.courses = courses;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCourses() {
        return courses;
    }

    public void setCourses(int courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return ("Name: " + getFirstName() + " " + getLastName() + "  " + "BlazerID: " + getBlazerID() + "  " +
                "Department: " + getDepartment() + "  " + "Courses: " + getCourses());
    }
}
