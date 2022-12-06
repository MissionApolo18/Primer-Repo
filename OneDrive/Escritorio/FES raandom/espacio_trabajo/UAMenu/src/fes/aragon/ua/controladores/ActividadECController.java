package fes.aragon.ua.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import fes.aragon.ua.base.ActividadExtraCultural;
import fes.aragon.ua.base.Alumno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ActividadECController extends BaseController implements Initializable{
	private ActividadExtraCultural actividades;
	private String mensaje=" ";

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private CheckBox chkAjedrez;

    @FXML
    private CheckBox chkBaileSal;

    @FXML
    private CheckBox chkCanto;

    @FXML
    private CheckBox chkConfirmar;

    @FXML
    private CheckBox chkCoro;

    @FXML
    private CheckBox chkDanzaA;

    @FXML
    private CheckBox chkDanzaClas;

    @FXML
    private CheckBox chkDanzaFolk;

    @FXML
    private CheckBox chkDanzaJazzA;

    @FXML
    private CheckBox chkDanzaJazzB;

    @FXML
    private CheckBox chkFotograf;

    @FXML
    private CheckBox chkGuitarra;

    @FXML
    private CheckBox chkMeditacion;

    @FXML
    private CheckBox chkOratoria;

    @FXML
    private CheckBox chkPiano;

    @FXML
    private CheckBox chkPintura;

    @FXML
    private CheckBox chkPorras;

    @FXML
    private CheckBox chkSalsa;

    @FXML
    private CheckBox chkTeatro;

    @FXML
    void guardarInfo(ActionEvent event) {
    	if(this.lista()) {
    		ActividadExtraCultural activA=new ActividadExtraCultural();
    		activA.setActivECultural(this.chkAjedrez.isSelected());
    		activA.setActivECultural(this.chkBaileSal.isSelected());
    		activA.setActivECultural(this.chkCanto.isSelected());
    		activA.setActivECultural(this.chkCoro.isSelected());
    		activA.setActivECultural(this.chkDanzaA.isSelected());
    		activA.setActivECultural(this.chkDanzaClas.isSelected());
    		activA.setActivECultural(this.chkDanzaFolk.isSelected());
    		activA.setActivECultural(this.chkDanzaJazzA.isSelected());
    		activA.setActivECultural(this.chkDanzaJazzB.isSelected());
    		activA.setActivECultural(this.chkFotograf.isSelected());
    		activA.setActivECultural(this.chkGuitarra.isSelected());
    		activA.setActivECultural(this.chkMeditacion.isSelected());
    		activA.setActivECultural(this.chkOratoria.isSelected());
    		activA.setActivECultural(this.chkPiano.isSelected());
    		activA.setActivECultural(this.chkPintura.isSelected());
    		activA.setActivECultural(this.chkPorras.isSelected());
    		activA.setActivECultural(this.chkSalsa.isSelected());
    		activA.setActivECultural(this.chkTeatro.isSelected());
    		if (Alumno.getIniciarAl().isModificarAlumno(true)&&Alumno.getIniciarAl().getIndiceActiv()!=-1) {
    			//actividades.getAlumnos().set(Alumno.getIniciarAl().getIndiceActiv(), activA);
    			//actividades.getCultural();
    			
    		} else {
    			Alumno.getIniciarAl().getIndiceActiv();
    		}
    		this.salirVentana(btnAceptar);
    	} else {
    		this.avisoEmergente("¡Aviso!", "Por favor seleccione uno", this.mensaje);
    		this.mensaje="";
    	}
    }

    @FXML
    void regresarVentana(ActionEvent event) {
    	this.salirVentana(btnCancelar);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(this.chkConfirmar.isSelected()==true) {
			this.actividades=Alumno.getIniciarAl().getIniciarActiv();
			int indice = Alumno.getIniciarAl().getIndiceActiv();
			ActividadExtraCultural activ= null;
			if(indice==1) {
				activ= new ActividadExtraCultural();
				activ.setIndiceActiv(indice);
				this.guardarInfo(null);
			} else {
				this.salirVentana(btnCancelar);
			}
		}
	}
	
	public boolean lista() {
		ActividadExtraCultural confirmar = new ActividadExtraCultural();
		boolean completo = false;
		if(this.chkAjedrez.isSelected()) {
			this.chkAjedrez.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkBaileSal.isSelected()) {
			this.chkBaileSal.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkCanto.isSelected()) {
			this.chkCanto.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkCoro.isSelected()) {
			this.chkCoro.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkDanzaA.isSelected()) {
			this.chkDanzaA.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkDanzaClas.isSelected()) {
			this.chkDanzaClas.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkDanzaFolk.isSelected()) {
			this.chkDanzaFolk.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkDanzaJazzA.isSelected()) {
			this.chkDanzaJazzA.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkDanzaJazzB.isSelected()) {
			this.chkDanzaJazzB.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkFotograf.isSelected()) {
			this.chkFotograf.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkGuitarra.isSelected()) {
			this.chkGuitarra.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkMeditacion.isSelected()) {
			this.chkMeditacion.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkOratoria.isSelected()) {
			this.chkOratoria.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkPiano.isSelected()) {
			this.chkPiano.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkPintura.isSelected()) {
			this.chkPintura.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkPorras.isSelected()) {
			this.chkPorras.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkSalsa.isSelected()) {
			this.chkSalsa.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		if(this.chkTeatro.isSelected()) {
			this.chkTeatro.setSelected(confirmar.setConfirmarActiv(completo));
			completo=true;
		}
		return completo;
	}
}
