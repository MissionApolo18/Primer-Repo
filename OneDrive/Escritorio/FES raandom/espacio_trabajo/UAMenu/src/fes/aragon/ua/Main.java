package fes.aragon.ua;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/ua/fxml/mENUNUEVO.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/fes/aragon/ua/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			//primaryStage.setX(Screen.getPrimary().getVisualBounds().getMaxX());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void setRoot(String fxml) {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
