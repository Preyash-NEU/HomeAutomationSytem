package edu.neu.csye7374.PrototypePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class ScheduleCache {

    private static Hashtable<String, Schedule> scheduleTable = new Hashtable<>();

    public static Schedule getSchedule(String locationName) {
        Schedule cachedSchedule = scheduleTable.get(locationName);
        return (Schedule) cachedSchedule.clone();
    }

    public static void loadCache() {

        Schedule lightSchedule = new LightSchedule("Living Room", new ArrayList<>(Arrays.asList("9:30AM", "4:30PM")));
        scheduleTable.put(lightSchedule.getRoomName(), lightSchedule);

        Schedule fanSchedule = new FanSchedule("Bedroom", new ArrayList<>(Arrays.asList("12:00AM", "1:30PM")));
        scheduleTable.put(fanSchedule.getRoomName(), fanSchedule);

    }
}
