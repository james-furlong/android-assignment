package au.com.jamesfurlong.assignment_1.Activities.Classes;

public class WorldTime {

    private String Location;
    private String Time;
    private String TimeDifference;

    public WorldTime(String location, String time, String timeDifference ) {
        Location = location;
        Time = time;
        TimeDifference = timeDifference;
    }

    public String getLocation() {
        return Location;
    }

    public String getTime() {
        return Time;
    }

    public String getTimeDifference() {
        return TimeDifference;
    }

}
