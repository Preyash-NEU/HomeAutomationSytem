package application;
	
import edu.neu.csye7374.AutomationAssistant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
	        primaryStage.setTitle("Design Patterns Demo");
	        primaryStage.setScene(new Scene(root, 624, 809));
	        primaryStage.show();
//			System.out.println("******Design Patterns project for Home Automation******\n\n");
//	        AutomationAssistant.demo();
//	        System.out.println("******Thank You******");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
