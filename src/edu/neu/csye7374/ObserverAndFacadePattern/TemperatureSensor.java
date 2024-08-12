package edu.neu.csye7374.ObserverAndFacadePattern;
import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor {
    private int temperature;
    private List<TemperatureObserver> observers = new ArrayList<>();

    public int getTemperature() {
        return temperature;
    }

    public String setTemperature(int temperature) {
        this.temperature = temperature;
        return notifyObservers();
    }

    public void attach(TemperatureObserver observer) {
        observers.add(observer);
    }

    public void detach(TemperatureObserver observer) {
        observers.remove(observer);
    }

    public String notifyObservers() {
    	String output = "";
        for (TemperatureObserver observer : observers) {
            output = observer.update(temperature) + "\n";
        }
        return output;
    }
}
