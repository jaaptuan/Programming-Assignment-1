public class Listname {

    private String SID ;
    private String firstName ;
    private String lastName ;

    public Listname(String SID , String firstName , String lastName) {
        this.SID = SID ;
        this.firstName = firstName ;
        this.lastName = lastName ;
    }
    public String getSID() {
        return SID ;
    }

    public String getFirstName() {
        return firstName ;
    }

    public String getLastName() {
        return lastName ;
    }
    public String tostring() {
        return this.SID + " " + this.firstName + "" + this.lastName ;
    }
}
