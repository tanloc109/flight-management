package dto;

public class Crew {
    private Staff captain, co_pilot, flightAttendant1, flightAttendant2, flightAttendant3;

    public Crew() {
    }

    public Crew(Staff captain, Staff co_pilot, Staff flightAttendant1, Staff flightAttendant2, Staff flightAttendant3) {
        this.captain = captain;
        this.co_pilot = co_pilot;
        this.flightAttendant1 = flightAttendant1;
        this.flightAttendant2 = flightAttendant2;
        this.flightAttendant3 = flightAttendant3;
    }

    public Staff getCaptain() {
        return captain;
    }

    public void setCaptain(Staff captain) {
        this.captain = captain;
    }

    public Staff getCo_pilot() {
        return co_pilot;
    }

    public void setCo_pilot(Staff co_pilot) {
        this.co_pilot = co_pilot;
    }

    public Staff getFlightAttendant1() {
        return flightAttendant1;
    }

    public void setFlightAttendant1(Staff flightAttendant1) {
        this.flightAttendant1 = flightAttendant1;
    }

    public Staff getFlightAttendant2() {
        return flightAttendant2;
    }

    public void setFlightAttendant2(Staff flightAttendant2) {
        this.flightAttendant2 = flightAttendant2;
    }

    public Staff getFlightAttendant3() {
        return flightAttendant3;
    }

    public void setFlightAttendant3(Staff flightAttendant3) {
        this.flightAttendant3 = flightAttendant3;
    }

    @Override
    public String toString() {
        return captain + ", " + co_pilot + ", " + flightAttendant1 + ", " + flightAttendant2 + ", " + flightAttendant3;
    }
    
    
    
}
