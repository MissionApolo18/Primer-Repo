package fes.aragon.ua.controladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.ua.base.AlumnoInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FotoAlumnoController extends BaseController implements Initializable{

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnCargar;

    @FXML
    private ImageView imageView;

    @FXML
    void abrirArchivo(ActionEvent event) {
    	this.imageView=new ImageView();
    	try {
			this.imageView.setImage(this.imagen(btnCargar));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.imageView.setVisible(true);
    }

    @FXML
    void guardarInfo(ActionEvent event) {
    	try {
			this.guardarArchivo(btnAceptar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void regresarVentana(ActionEvent event) {
    	this.salirVentana(btnCancelar);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public Image imagen(Button boton) throws IOException {
		Stage stage = (Stage) boton.getScene().getWindow();
		FileChooser archivo = new FileChooser();
		
		archivo.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Foto Alumno", "*.jpg"));
		archivo.setTitle("Cargar archivo");
		archivo.setInitialDirectory(new File(System.getProperty("user.dir")));
		File rataA=archivo.showOpenDialog(stage);
		if(rataA!=null) {
			FileOutputStream fa = new FileOutputStream(rataA);
			ObjectOutputStream salidaB=new ObjectOutputStream(fa);
			ArrayList<AlumnoInfo> imagen = new ArrayList<>();
			salidaB.writeObject(imagen);
			salidaB.close();
			fa.close();
		}
		return imagen(btnCargar);
	}

}
