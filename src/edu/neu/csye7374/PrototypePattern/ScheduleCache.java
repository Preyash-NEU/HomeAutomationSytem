package edu.neu.csye7374.PrototypePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class ScheduleCache {

    private static Hashtable<String, Schedule> scheduleHashtable = new Hashtable<>();

    public static Schedule getSchedule(String roomName) {
        Schedule cachedSchedule = scheduleHashtable.get(roomName);
        return (Schedule) cachedSchedule.clone();
    }

    public static void loadCache() {

        Schedule lightSchedule = new LightSchedule("Living Room", new ArrayList<String>(Arrays.asList("10:30AM", "5:30PM")));
        scheduleHashtable.put(lightSchedule.getRoomName(), lightSchedule);

        Schedule fanSchedule = new FanSchedule("Bedroom", new ArrayList<String>(Arrays.asList("12:30AM", "2:30PM")));
        scheduleHashtable.put(fanSchedule.getRoomName(), fanSchedule);

    }
}
