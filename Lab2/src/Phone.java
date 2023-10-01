public class Phone {
    private int ID;
    private String lastName;
    private String firstName;
    private String fatherName;
    private int number;
    private int timeCity;
    private int timeLongDistance;

    public Phone(int ID, String lastName, String firstName, String fatherName, int number, int timeCity, int timeLongDistance) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.number = number;
        this.timeCity = timeCity;
        this.timeLongDistance = timeLongDistance;
    }

    public Phone(Phone Copy) {
        this.ID = Copy.ID;
        this.lastName = Copy.lastName;
        this.firstName = Copy.firstName;
        this.fatherName = Copy.fatherName;
        this.number = Copy.number;
        this.timeCity = Copy.timeCity;
        this.timeLongDistance = Copy.timeLongDistance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTimeCity() {
        return timeCity;
    }

    public void setTimeCity(int timeCity) {
        this.timeCity = timeCity;
    }

    public int getTimeLongDistance() {
        return timeLongDistance;
    }

    public void setTimeLongDistance(int timeLongDistance) {
        this.timeLongDistance = timeLongDistance;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ID=" + ID +"\n"+
                ", lastName='" + lastName + "'\n"+
                ", firstName='" + firstName + '\'' +"\n"+
                ", fatherName='" + fatherName + '\'' +"\n"+
                ", number=" + number +"\n"+
                ", timeCity=" + timeCity +"\n"+
                ", timeLongDistance=" + timeLongDistance +
                '}';
    }



}
