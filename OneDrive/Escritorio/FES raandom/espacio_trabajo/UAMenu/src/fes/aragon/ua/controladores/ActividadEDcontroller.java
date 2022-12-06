package fes.aragon.ua.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import fes.aragon.ua.base.ActividadExtraCultural;
import fes.aragon.ua.base.ActividadExtraDeportiva;
import fes.aragon.ua.base.Alumno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ActividadEDcontroller extends BaseController implements Initializable{
	private ActividadExtraDeportiva actividad;
	private String mensajeb=" ";
	
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancela;

    @FXML
    private CheckBox chkAtletismo;

    @FXML
    private CheckBox chkBadminton;

    @FXML
    private CheckBox chkBasquet;

    @FXML
    private CheckBox chkBeisbol;

    @FXML
    private CheckBox chkCiclismo;

    @FXML
    private CheckBox chkConfirmar;

    @FXML
    private CheckBox chkEntrenamiento;

    @FXML
    private CheckBox chkFutbolA;

    @FXML
    private CheckBox chkFutbolR;

    @FXML
    private CheckBox chkGimnasia;

    @FXML
    private CheckBox chkGimnasio;

    @FXML
    private CheckBox chkKarate;

    @FXML
    private CheckBox chkLuchaGreco;

    @FXML
    private CheckBox chkMontanismo;

    @FXML
    private CheckBox chkRugby;

    @FXML
    private CheckBox chkTaekw;

    @FXML
    private CheckBox chkTenis;

    @FXML
    private CheckBox chkTocho;

    @FXML
    private CheckBox chkVolei;

    @FXML
    private CheckBox chkZumba;

    @FXML
    void guardarInfo(ActionEvent event) {
    	if(this.listaB()) {
    		ActividadExtraDeportiva activB=new ActividadExtraDeportiva();
    		activB.setActivEDeportiva(this.chkAtletismo.isSelected());
    		activB.setActivEDeportiva(this.chkBadminton.isSelected());
    		activB.setActivEDeportiva(this.chkBasquet.isSelected()); 
    		activB.setActivEDeportiva(this.chkBeisbol.isSelected());
    		activB.setActivEDeportiva(this.chkCiclismo.isSelected());
    		activB.setActivEDeportiva(this.chkEntrenamiento.isSelected());
    		activB.setActivEDeportiva(this.chkFutbolA.isSelected());
    		activB.setActivEDeportiva(this.chkFutbolR.isSelected());
    		activB.setActivEDeportiva(this.chkGimnasia.isSelected());
    		activB.setActivEDeportiva(this.chkGimnasio.isSelected());
    		activB.setActivEDeportiva(this.chkKarate.isSelected());
    		activB.setActivEDeportiva(this.chkLuchaGreco.isSelected());
    		activB.setActivEDeportiva(this.chkMontanismo.isSelected());
    		activB.setActivEDeportiva(this.chkRugby.isSelected());
    		activB.setActivEDeportiva(this.chkTaekw.isSelected());
    		activB.setActivEDeportiva(this.chkTenis.isSelected());
    		activB.setActivEDeportiva(this.chkTocho.isSelected());
    		activB.setActivEDeportiva(this.chkVolei.isSelected());
    		activB.setActivEDeportiva(this.chkZumba.isSelected());
    		if (Alumno.getIniciarAl().isModificarAlumno(true)&&Alumno.getIniciarAl().getIndiceActiv()!=-1) {
    			//actividades.getAlumnos().set(Alumno.getIniciarAl().getIndiceActiv(), activA);
    			//actividad.getActividadED().add(this.listaB());
    		} else {
    			Alumno.getIniciarAl().getIndiceActiv();
    		}
    		this.salirVentana(btnAceptar);
    	} else {
    		this.avisoEmergente("¡Aviso!", "Por favor seleccione uno", this.mensajeb);
    		this.mensajeb="";
    	}
    }

    @FXML
    void regresarVentana(ActionEvent event) {
    	this.salirVentana(btnCancela);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(this.chkConfirmar.isSelected()==true) {
			this.actividad=Alumno.getIniciarAl().getIniciarActivB();
			int indice = Alumno.getIniciarAl().getIndiceActiv();
			ActividadExtraDeportiva activ= null;
			if(indice==1) {
				activ= new ActividadExtraDeportiva();
				activ.setIndiceActiv(indice);
				this.guardarInfo(null);
			} else {
				this.salirVentana(btnCancela);
			}
		}
	}
	
	public boolean listaB() {
		ActividadExtraDeportiva actividad = new ActividadExtraDeportiva();
		boolean confirmar=false;
		if(this.chkAtletismo.isSelected()) {
			this.chkAtletismo.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkBadminton.isSelected()) {
			this.chkBadminton.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkBasquet.isSelected()) {
			this.chkBasquet.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkBeisbol.isSelected()) {
			this.chkBeisbol.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkCiclismo.isSelected()) {
			this.chkCiclismo.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkEntrenamiento.isSelected()) {
			this.chkEntrenamiento.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkFutbolA.isSelected()) {
			this.chkFutbolA.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkFutbolR.isSelected()) {
			this.chkFutbolR.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkGimnasia.isSelected()) {
			this.chkGimnasia.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkGimnasio.isSelected()) {
			this.chkGimnasio.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkKarate.isSelected()) {
			this.chkKarate.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkLuchaGreco.isSelected()) {
			this.chkLuchaGreco.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkMontanismo.isSelected()) {
			this.chkMontanismo.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkRugby.isSelected()) {
			this.chkRugby.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkTaekw.isSelected()) {
			this.chkTaekw.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkTenis.isSelected()) {
			this.chkTenis.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkTocho.isSelected()) {
			this.chkTocho.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkVolei.isSelected()) {
			this.chkVolei.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		if(this.chkZumba.isSelected()) {
			this.chkZumba.setSelected(actividad.setActivEDeportiva(true));
			confirmar=true;
		}
		return confirmar;
	}

}
