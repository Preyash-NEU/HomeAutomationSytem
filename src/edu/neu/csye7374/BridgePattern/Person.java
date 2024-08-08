package edu.neu.csye7374.BridgePattern;

public class Person implements PersonAPI{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
