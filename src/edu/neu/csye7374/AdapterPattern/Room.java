package edu.neu.csye7374.AdapterPattern;

import edu.neu.csye7374.BuilderPattern.Environment;

public interface Room {
    void setEnvironment(Environment environment);
    Environment getEnvironment();
}
