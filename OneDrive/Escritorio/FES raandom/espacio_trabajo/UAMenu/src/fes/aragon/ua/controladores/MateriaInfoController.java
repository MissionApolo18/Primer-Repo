package fes.aragon.ua.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import fes.aragon.ua.base.Materias;
import fes.aragon.ua.base.Profesor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class MateriaInfoController extends BaseController implements Initializable{
	private String mensaje=" ";
	private Materias materia;
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;
    
    @FXML
    private Button btnEliminar;

    @FXML
    private ChoiceBox<String> chcSemestre;

    @FXML
    private TextField txtNombreMat;

    @FXML
    void guardarInfoMateria(ActionEvent event) {
    	if(this.infoCorrecta()){
    		Materias mat=new Materias();
    		mat.setNomMateria(this.txtNombreMat.getText());
    		mat.setSemImparte(this.chcSemestre.getValue());
    		if(Profesor.getIniciar().isModificarProfesor(true)) {
    			materia.getNomMateria().set(Profesor.getIniciar().getIndiceMat(),mat);
    			materia.getSemImparte().set(Profesor.getIniciar().getIndiceMat(),mat);
    		} else {
    			materia.getNomMateria().add(mat);
    			materia.getSemImparte().add(mat);
    		}
    		this.salirVentana(btnAceptar);
    	} else {
    		this.avisoEmergente("¡Aviso!", "Datos no correctos", this.mensaje);
    		this.mensaje="";
    	}
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.salirVentana(btnCancelar);
    }
    
    @FXML
    void eliminarMateria(ActionEvent event) {
    	//falta hacer esto
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.chcSemestre.getItems().addAll("Seleccione un semestre","1","2","3","4","5","6","7","8","9");
		this.chcSemestre.getSelectionModel().select(0);
		if(Profesor.getIniciar().isModificarProfesor(true)) {
			this.materia=Profesor.getIniciarmat().getNomMateria().get(Profesor.getIniciarmat().getNomMateria());
			this.materia=Profesor.getIniciarmat().getSemImparte().get(Profesor.getIniciarmat().getSemImparte());
			int indice=Profesor.getIniciar().getIndiceMat();
			Materias mate=null;
			if(indice==1) {
				mate=new Materias();
				mate.setNomMateria(this.txtNombreMat.getText());
				mate.setSemImparte(this.chcSemestre.getSelectionModel());
			} else {
				mate=materia.getNomMateria().get(Profesor.getIniciar().getIndiceMat());
				mate=materia.getSemImparte().get(Profesor.getIniciar().getIndiceMat());
			}
			this.txtNombreMat.setText(mate.getNomMateria());
			this.chcSemestre.setValue(mate.getSemImparte());
		} else {
			materia=Profesor.getIniciarmat().getNomMateria(Profesor.getIniciarmat().getNomMateria());
			materia=Profesor.getIniciarmat().getSemImparte(Profesor.getIniciarmat().getSemImparte());
		}
	}
	private boolean infoCorrecta() {
		boolean correcto=true;
		if((this.txtNombreMat.getText()==null)||(this.txtNombreMat.getText()==null&&this.txtNombreMat.getText()==null)) {
			this.mensaje+="Por favor ingrese una materia, el campo está vacio\n";
			correcto=false;
		}
		if(this.chcSemestre.getSelectionModel().getSelectedIndex()==0||this.chcSemestre.getSelectionModel().getSelectedIndex()==-1) {
			this.mensaje+="Por favor seleccione un semestre";
			correcto=false;
		}
		return correcto;
	}
}
