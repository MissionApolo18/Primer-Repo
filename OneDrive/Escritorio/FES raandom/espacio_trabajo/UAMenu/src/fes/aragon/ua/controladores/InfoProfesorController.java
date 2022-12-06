package fes.aragon.ua.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import fes.aragon.ua.base.Profesor;
import fes.aragon.ua.base.ProfesorInfo;
import fes.aragon.ua.base.TipoError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InfoProfesorController extends BaseController implements Initializable{
	private ProfesorInfo profe;
	private String mensaje= " ";
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtApellidoMat;

    @FXML
    private TextField txtApellidoPat;

    @FXML
    private TextField txtCorreoInstit;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtRFC;

    @FXML
    void añadirInfoProfe(ActionEvent event) {
    	if(this.verificacion()) {
    		profe.setNombre(this.txtNombre.getText());
    		profe.setApellidoPaterno(this.txtApellidoPat.getText());
    		profe.setApellidoMaterno(this.txtApellidoMat.getText());
    		profe.setRFC(this.txtRFC.getText());
    		profe.setCorreoInstit(this.txtCorreoInstit.getText());
    		if(Profesor.getIniciar().isModificarProfesor(true)&&Profesor.getIniciar().getIndice()!=-1) {
    			Profesor.getIniciar().getGrupoProfesor().set(Profesor.getIniciar().getIndice(), profe);
    			Profesor.getIniciar().setIndice(-1);
    			Profesor.getIniciar().setModificarProfesor(false);
    		} else {
    			Profesor.getIniciar().getGrupoProfesor().set(Profesor.getIniciar().getGrupoProfesor().size()-1, profe);
    		}
    		this.salirVentana(btnAceptar);
    	} else {
    		this.avisoEmergente("Mensaje", "Datos no correctos	", this.mensaje);
    		this.mensaje="";
    	}
    }

    @FXML
    void cancelarAccion(ActionEvent event) {
    	this.salirVentana(btnCancelar);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.entradaCorrecta(txtCorreoInstit, TipoError.CORREO);
		this.entradaCorrecta(txtRFC, TipoError.RFC);
		if(Profesor.getIniciar().isModificarProfesor(true)) {
			this.profe=Profesor.getIniciar().getGrupoProfesor().get(Profesor.getIniciar().getIndice());
			this.txtNombre.setText(profe.getNombre());
			this.txtApellidoPat.setText(profe.getApellidoPaterno());
			this.txtApellidoMat.setText(profe.getApellidoMaterno());
			this.txtRFC.setText(profe.getRFC());
			this.txtCorreoInstit.setText(profe.getCorreoInstit());
		} else {
			profe=Profesor.getIniciar().getGrupoProfesor().get(Profesor.getIniciar().getIndice());
		}
	}
	
	private boolean verificacion() {
		boolean correcto = true;
		if((this.txtNombre.getText()==null)||(this.txtNombre.getText()==null && this.txtNombre.getText()==null)) {
			this.mensaje+= "El Nombre no es válido, es vacio\n";
			correcto=false;
		}
		if((this.txtApellidoPat.getText()==null)||(this.txtApellidoPat.getText()==null && this.txtApellidoPat.getText()==null)) {
			this.mensaje+= "El Apellido Paterno no es válido, es vacio\n";
			correcto=false;
		}
		if((this.txtApellidoMat.getText()==null)||(this.txtApellidoMat.getText()==null && this.txtApellidoMat.getText()==null)) {
			this.mensaje+= "El Apellido Materno no es válido, es vacio\n";
			correcto=false;
		}
		if((this.txtRFC.getText()==null)||(this.txtRFC.getText()==null && this.txtRFC.getText()==null)) {
			this.mensaje+= "El RFC no es válido, es vacio\n";
			correcto=false;
		}
		if((this.txtCorreoInstit.getText()==null)||(this.txtCorreoInstit.getText()==null && this.txtCorreoInstit.getText()==null)) {
			this.mensaje+= "El Correo no es válido, es vacio\n";
			correcto=false;
		}
		return correcto;
	}
}
