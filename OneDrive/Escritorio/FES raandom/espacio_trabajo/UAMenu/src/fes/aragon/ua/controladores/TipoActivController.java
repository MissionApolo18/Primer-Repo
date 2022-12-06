package fes.aragon.ua.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import fes.aragon.ua.base.Alumno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TipoActivController extends BaseController implements Initializable{

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnCultural;

    @FXML
    private Button btnDeportes;

    @FXML
    void abrirAECulturales(ActionEvent event) {
    	Alumno.getIniciarAl().setIndiceActiv(-1);
    	this.ventanaNueva("ActividadEC");
    	this.salirVentana(btnCultural);
    }

    @FXML
    void abrirAEDeportivas(ActionEvent event) {
    	Alumno.getIniciarAl().setIndiceActiv(-1);
    	this.ventanaNueva("ActividadED");
    	this.salirVentana(btnDeportes);
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.salirVentana(btnCancelar);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
