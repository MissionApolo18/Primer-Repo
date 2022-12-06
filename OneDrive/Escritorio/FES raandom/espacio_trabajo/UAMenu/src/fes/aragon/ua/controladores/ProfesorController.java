package fes.aragon.ua.controladores;

import static javafx.scene.control.ButtonType.OK;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import fes.aragon.ua.base.Profesor;
import fes.aragon.ua.base.ProfesorInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProfesorController extends BaseController implements Initializable{

    @FXML
    private Button bntInfoProfe;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnInfoAlumno;

    @FXML
    private Button btnMateria;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<ProfesorInfo, String> cmlApellidoMat;

    @FXML
    private TableColumn<ProfesorInfo, String> cmlApellidoPat;

    @FXML
    private TableColumn<ProfesorInfo, String> cmlCorreoInstit;

    @FXML
    private TableColumn<ProfesorInfo, String> cmlMateriaNombre;

    @FXML
    private TableColumn<ProfesorInfo, String> cmlMateriasInfo;

    @FXML
    private TableColumn<ProfesorInfo, String> cmlNombre;

    @FXML
    private TableColumn<ProfesorInfo, String> cmlRFC;

    @FXML
    private TableColumn<ProfesorInfo, String> cmlSemestreMateria;

    @FXML
    private TableView<ProfesorInfo> tblTablaa;

    @FXML
    void abrirInfoAlumnos(ActionEvent event) {
    	Profesor.getIniciar().setModificarAlumno(false);
    	this.ventanaNueva("Alumno");
    }

    @FXML
    void abrirInfoProf(ActionEvent event) {
    	Profesor.getIniciar().setIndice(-1);
    	Profesor.getIniciar().setModificarProfesor(false);
    	Profesor.getIniciar().setGrupoProfesor();
    	this.ventanaNueva("InfoProfesor");
    }

    @FXML
    void abrirMateria(ActionEvent event) {
    	Profesor.getIniciar().setIndiceMat(-1);
    	this.ventanaNueva("Materias");
    }

    @FXML
    void eliminarInfoProfe(ActionEvent event) {
    	int indix = this.tblTablaa.getSelectionModel().getSelectedIndex();
    	if (indix>=0) {
    		this.tblTablaa.getItems().remove(indix);
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
    void modificarInfoProfe(ActionEvent event) {
    	int indice = this.tblTablaa.getSelectionModel().getSelectedIndex();
		if (indice >= 0) {
			Profesor.getIniciar().setModificarProfesor(true);
			Profesor.getIniciar().setIndice(indice);
			this.ventanaNueva("InfoProfesor");
		} else {
			Alert alertar;
			alertar = new Alert(AlertType.INFORMATION);
			alertar.setTitle("Dialogo de aviso");
			alertar.setHeaderText("Se necesita seleccionar una fila");
			alertar.setContentText("Por favor selecciona una fila");
			Optional<ButtonType> resultado = alertar.showAndWait();
			if (resultado.get().equals(OK)) {
			}
		}
    }

    @FXML
    void regresarVentana(ActionEvent event) {
    	this.salirVentana(btnRegresar);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.cmlNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		this.cmlApellidoPat.setCellValueFactory(new PropertyValueFactory<>("ApellidoPaterno"));
		this.cmlApellidoMat.setCellValueFactory(new PropertyValueFactory<>("EpellidoMaterno"));
		this.cmlRFC.setCellValueFactory(new PropertyValueFactory<>("RFC"));
		this.cmlCorreoInstit.setCellValueFactory(new PropertyValueFactory<>("CorreoInstit"));
		this.cmlMateriasInfo.cellValueFactoryProperty(); //Falta inicializar esta cosa
		this.cmlMateriaNombre.setCellValueFactory(new PropertyValueFactory<>("NomMateria"));
		this.cmlSemestreMateria.setCellValueFactory(new PropertyValueFactory<>("SemImparte"));
		this.tblTablaa.setItems(Profesor.getIniciar().getGrupoProfesor());
	}

}
