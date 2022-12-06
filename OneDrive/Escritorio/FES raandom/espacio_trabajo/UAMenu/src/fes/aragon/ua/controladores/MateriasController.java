package fes.aragon.ua.controladores;

import static javafx.scene.control.ButtonType.OK;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import fes.aragon.ua.base.Materias;
import fes.aragon.ua.base.Profesor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class MateriasController extends BaseController implements Initializable {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnModificar;
    
    @FXML
    private Button btnAñadirMateria;

    @FXML
    private TableColumn<Materias, String> cmlNombreMat;

    @FXML
    private TableColumn<Materias, String> cmlSemestre;

    @FXML
    private TableView<Materias> tblTablab;

    @FXML
    void agregarMateria(ActionEvent event) {
    	Profesor.getIniciar().setIndiceMat(-1);
    	this.ventanaNueva("MateriaInfo");
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.salirVentana(btnCancelar);
    }

    @FXML
    void guardarInfo(ActionEvent event) {
    	this.guardarInfo(event);
    	this.salirVentana(btnAceptar);
    }
    @FXML
    void modificarInfoMateria(ActionEvent event) { 
    	int indie = this.tblTablab.getSelectionModel().getSelectedIndex();
    	if(indie>=0) {
    		Profesor.getIniciar().isModificarProfesor(true);
        	Profesor.getIniciar().setIndice(indie);
    		this.ventanaNueva("MateriaInfo");
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.cmlNombreMat.setCellValueFactory(new PropertyValueFactory<>("NomMateria"));
		this.cmlSemestre.setCellValueFactory(new PropertyValueFactory<>("SemImparte"));
		//this.tblTablab.setItems(Profesor.getIniciar().getIndiceMat());
	}

}
