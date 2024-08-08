package edu.neu.csye7374.PrototypePattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Schedule implements Cloneable{

    private String roomName;

    private String type;
    private List<String> schedule;

    public Schedule(String roomName, List<String> schedule, String type) {
        this.roomName = roomName;
        this.schedule = schedule;
        this.type = type;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getType() {
        return type;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void addSchedule(String time) {
        schedule.add(time);
        Collections.sort(schedule);
    }

    @Override
    protected Schedule clone() {

        Schedule cloned = null;

        try {
            cloned = (Schedule) super.clone();
            cloned.schedule = new ArrayList<>(this.schedule);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return cloned;
    }

    @Override
    public String toString() {
        return "Schedule{" +
//                "Type of Device='" + this.getClass() + '\'' +
                "roomName='" + roomName + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
