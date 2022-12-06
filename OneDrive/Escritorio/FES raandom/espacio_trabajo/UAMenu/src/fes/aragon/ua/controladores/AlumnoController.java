package fes.aragon.ua.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import fes.aragon.ua.base.Alumno;
import fes.aragon.ua.base.AlumnoInfo;
import fes.aragon.ua.base.Profesor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static javafx.scene.control.ButtonType.OK;

public class AlumnoController extends BaseController implements Initializable{

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnModificar;
    
    @FXML
    private Button btnAbrir;

    @FXML
    private TableColumn<AlumnoInfo, String> clmActivExtra;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlAECultural;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlAEDeportiva;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlApellidoMat;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlApellidoPat;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlConfirmarAcExtra;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlCorreoInstit;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlFoto;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlNombre;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlNumCuenta;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlPromedio;

    @FXML
    private TableColumn<AlumnoInfo, String> cmlSemestre;

    @FXML
    private TableView<AlumnoInfo> tbltablab;

    @FXML
    void añadirInfo(ActionEvent event) {
    	if (Alumno.getIniciarAl().isModificarAlumno(true)) {
    		this.ventanaNueva("FotoAlumno"); 
    	} else {
    		Profesor.getIniciar().setModificarAlumno(true);
    		this.ventanaNueva("AlumnoInfo");
    	}
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.salirVentana(btnCancelar);
    }

    @FXML
    void eliminarInfo(ActionEvent event) {
    	int indix = this.tbltablab.getSelectionModel().getSelectedIndex();
    	if (indix>=0) {
    		this.tbltablab.getItems().remove(indix);
    	} else {
    		Alert alertaa = new Alert(AlertType.INFORMATION);
    		alertaa.setTitle("¡Aviso!");
    		alertaa.setHeaderText("Por favor, seleccione una fila");
    		alertaa.setContentText("Se necesita indicar una fila");
    		Optional <ButtonType> resultao = alertaa.showAndWait();
    		if(resultao.equals(OK)) {
    			
    		}
    	}
    }

    @FXML
    void guardarArchivo(ActionEvent event) {
    	try {
    		this.guardarArchivo(btnGuardar);
    		this.deshabilita(false);
    	} catch(IOException e) {
    		this.avisoEmergente("Aviso", "Problema con el archivo   ", "Consulte al programador, tiene un problema con el archivo");
    		e.printStackTrace();
    	}
    }

    @FXML
    void guardarInfo(ActionEvent event) {
    	this.guardarArchivo(event);
    	this.salirVentana(btnAceptar);
    }
    
    @FXML
    void abrirArchivo(ActionEvent event) {
    	try {
    		this.abrirArchivo(btnAbrir);
    		this.deshabilita(false);
    	} catch(ClassNotFoundException | IOException e) {
    		this.avisoEmergente("Aviso", "Problema con el archivo   ", "Consulte al programador, tiene un problema con el archivo");
    		e.printStackTrace();
    	}
    }

    @FXML
    void modificarInfo(ActionEvent event) {
    	if(Alumno.getIniciarAl().isModificarAlumno(true)) {
    		this.ventanaNueva("FotoAlumno"); 
    	} else {
    		int indie = this.tbltablab.getSelectionModel().getSelectedIndex();
        	if(indie>=0) {
        		Profesor.getIniciar().setModificarAlumno(true);
        		Profesor.getIniciar().setIndice(indie);
        		this.ventanaNueva("AlumnoInfo");
        	}else {
        		Alert alertaa = new Alert(AlertType.INFORMATION);
        		alertaa.setTitle("¡Aviso!");
        		alertaa.setHeaderText("Por favor, seleccione una fila");
        		alertaa.setContentText("Se necesita indicar una fila");
        		Optional <ButtonType> resultao = alertaa.showAndWait();
        		if(resultao.equals(OK)) {
        			
        		}
        	}
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(Alumno.getIniciarAl().isModificarAlumno(true)) {
			this.deshabilita(true);
			this.cmlFoto.cellValueFactoryProperty();
			 this.tbltablab.setItems(Alumno.getIniciarAl().getFoto());
		} else {
			this.cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre")); 
			this.cmlApellidoPat.setCellValueFactory(new PropertyValueFactory<>("apellidoPat")	);
			this.cmlApellidoMat.setCellValueFactory(new PropertyValueFactory<>("apellidoMat"));
			this.cmlSemestre.setCellValueFactory(new PropertyValueFactory<>("semestre"));
			this.cmlPromedio.setCellValueFactory(new PropertyValueFactory<>("promedio"));
			this.cmlNumCuenta.setCellValueFactory(new PropertyValueFactory<>("numCuenta"));
			this.cmlCorreoInstit.setCellValueFactory(new PropertyValueFactory<>("correoIntit"));
			this.cmlConfirmarAcExtra.setCellValueFactory(new PropertyValueFactory<>("QueActivE"));
			this.cmlAECultural.setCellValueFactory(new PropertyValueFactory<>("ActividadEC"));
			this.cmlAEDeportiva.setCellValueFactory(new PropertyValueFactory<>("ActividadED"));
			this.tbltablab.setItems(Alumno.getIniciarAl().getAlumnos());
			this.deshabilita(false);
		}
	}
	
	private void deshabilita (boolean valor) {
		this.btnAñadir.setDisable(valor);
		this.btnEliminar.setDisable(valor);
	}

	
}
