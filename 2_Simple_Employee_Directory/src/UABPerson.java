abstract class UABPerson {

    private String role, firstName, lastName, blazerID;

    UABPerson(String role, String firstName, String lastName, String blazerID) {

        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blazerID = blazerID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBlazerID() {
        return blazerID;
    }

    public void setBlazerID(String blazerID) {
        this.blazerID = blazerID;
    }
}
