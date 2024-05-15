public class ITProfessional extends UABPerson{

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    private String team;
    ITProfessional(String role, String firstName, String lastName, String blazerID, String team) {
        super(role, firstName, lastName, blazerID);
        this.team = team;
    }

    @Override
    public String toString() {
        return ("Name: " + getFirstName() + " " + getLastName() + "  " + "BlazerID: " + getBlazerID() + "  " +
                "Team: " + getTeam());
    }
}
