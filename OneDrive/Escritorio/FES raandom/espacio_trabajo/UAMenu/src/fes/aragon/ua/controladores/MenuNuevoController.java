package fes.aragon.ua.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import fes.aragon.ua.base.Alumno;
import fes.aragon.ua.base.AlumnoInfo;
import fes.aragon.ua.base.Profesor;
import fes.aragon.ua.base.ProfesorInfo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuNuevoController extends BaseController implements Initializable {

    @FXML
    private Button btnAlumno;

    @FXML
    private Button btnProfesor;

    @FXML
    private Button btnSalir;

    @FXML
    void abrirAlumno(ActionEvent event) {
    	Alumno.getIniciarAl().setAnadirFoto(true);
    	Alumno.getIniciarAl().isModificarAlumno(true);
    	this.ventanaNueva("Alumno");
    }



	@FXML
    void abrirProfesor(ActionEvent event) {
		Profesor.getIniciar().setIndice(-1);
    	Profesor.getIniciar().setModificarProfesor(false);
    	Profesor.getIniciar().setIndiceMat(-1);
    	Profesor.getIniciar().getGrupoProfesor().add(new ProfesorInfo());
    	Alumno.getIniciarAl().setAlumnos(null);
    	Alumno.getIniciarAl().setModificarAlumno(false);
    	Alumno.getIniciarAl().setIndiceAlum(-1);
    	Alumno.getIniciarAl().setIndiceActiv(-1);
    	Alumno.getIniciarAl().getAlumnos().add(new AlumnoInfo());
    	this.ventanaNueva("Profesor");
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	Platform.exit();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
