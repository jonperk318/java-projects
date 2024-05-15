public class Student extends UABPerson{

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    private String level, major;
    private double GPA;
    Student(String role, String firstName, String lastName, String blazerID, String level, String major, double GPA) {
        super(role, firstName, lastName, blazerID);
        this.level = level;
        this.major = major;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return ("Name: " + getFirstName() + " " + getLastName() + "  " + "BlazerID: " + getBlazerID() + "  " +
                "Level: " + getLevel() + "  " + "Major: " + getMajor() + "  " + "GPA: " + getGPA());
    }
}
