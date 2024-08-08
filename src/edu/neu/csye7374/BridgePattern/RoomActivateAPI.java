package edu.neu.csye7374.BridgePattern;

public interface RoomActivateAPI extends SecurityAPI {
    String doorSecurity();
    String lightSecurity();
    String garageSecurity();
}
