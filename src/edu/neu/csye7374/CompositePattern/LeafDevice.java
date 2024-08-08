package edu.neu.csye7374.CompositePattern;

public class LeafDevice extends SmartSpeakerDevices {

    int volume = 10;

    private String name;
    boolean on;

    public LeafDevice(String name) {
        this.name = name;
    }

    @Override
    public String getObjectInfo() {
        System.out.println("\t\tDevice name: "+name+", Volume: "+volume);
        return "\t\tDevice name: "+name+", Volume: "+volume;
    }

    @Override
    public String turnOn() {
        System.out.println(name + " turned on");
        on = true;
        return name + " turned on";
    }

    @Override
    public String turnOff() {
        System.out.println(name + " turned off");
        on = false;
        return name + " turned off";
    }

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return on;
	}
}
