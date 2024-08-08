package application;

import edu.neu.csye7374.SingletonFactoryPattern.SmartDevice;
import edu.neu.csye7374.SingletonFactoryPattern.SmartDeviceFactory;
import edu.neu.csye7374.SingletonFactoryPattern.SmartFanEagerSingletonFactory;
import edu.neu.csye7374.SingletonFactoryPattern.SmartLightLazySingletonFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class FactoryDemoController {

    @FXML
    private TextArea outputTextArea;

    @FXML
    public void runFactoryDemo() {
        StringBuilder output = new StringBuilder();
        output.append("***** SINGLETON AND FACTORY DESIGN PATTERN DEMO *****\n");
        output.append("\nStarting...\n".toUpperCase());

        SmartDeviceFactory lightFactory = SmartLightLazySingletonFactory.getInstance();
        SmartDevice light = lightFactory.getObject();
        output.append(light.getObjectInfo()).append("\n");

        SmartDeviceFactory fanFactory = SmartFanEagerSingletonFactory.getInstance();
        SmartDevice fan = fanFactory.getObject();
        output.append(fan.getObjectInfo()).append("\n");

        output.append("Ending...\n".toUpperCase()).append("\n");

        outputTextArea.setText(output.toString());
    }
}
