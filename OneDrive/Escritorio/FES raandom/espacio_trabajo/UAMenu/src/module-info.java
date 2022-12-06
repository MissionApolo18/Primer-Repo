module UAInterfaz {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens fes.aragon.ua to javafx.graphics, javafx.fxml;
}
