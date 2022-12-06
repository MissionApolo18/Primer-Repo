package fes.aragon.ua.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import fes.aragon.ua.base.Alumno;
import fes.aragon.ua.base.AlumnoInfo;
import fes.aragon.ua.base.TipoError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AlumnoInfoController extends BaseController implements Initializable{
	private AlumnoInfo alumnoA;
	private String mensaje= " ";
	
    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnActivExtra;

    @FXML
    private Button btnCancelar;

    @FXML
    private ChoiceBox<String> chcSemestre;

    @FXML
    private TextField txtApellidoMat;

    @FXML
    private TextField txtApellidoPat;

    @FXML
    private TextField txtCorreoInstit;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumCuenta;

    @FXML
    private TextField txtPromedio;

    @FXML
    void abrirActividades(ActionEvent event) {
    	this.ventanaNueva("TipoActiv");
    }

    @FXML
    void añadirInfo(ActionEvent event) {
    	if(this.verificacion()) {
    		alumnoA.setNombrees(this.txtNombre.getText());
    		alumnoA.setApellidoPaterno(this.txtApellidoPat.getText());
    		alumnoA.setApellidoMaterno(txtApellidoMat.getText());
    		alumnoA.setSemestre(this.chcSemestre.getValue());
    		alumnoA.setPromedioGen(this.txtPromedio.getText());
    		alumnoA.setNumCuenta(this.txtNumCuenta.getText());
    		alumnoA.setCorreo(this.txtCorreoInstit.getText());
    		if(Alumno.getIniciarAl().isModificarAlumno(true)&&Alumno.getIniciarAl().getIndiceAlum()!=-1) {
    			Alumno.getIniciarAl().getAlumnos().set(Alumno.getIniciarAl().getIndiceAlum(), alumnoA);
    			Alumno.getIniciarAl().setIndiceAlum(-1);
    			Alumno.getIniciarAl().setModificarAlumno(false);
    			Alumno.getIniciarAl().setIndiceAlum(-1);
    		} else {
    			Alumno.getIniciarAl().getAlumnos().set(Alumno.getIniciarAl().getAlumnos().size()-1, alumnoA);
    		}
    		this.salirVentana(btnAceptar);
    	} else {
    		this.avisoEmergente("Mensaje", "Datos no correctos	", this.mensaje);
    		this.mensaje="";
    	}
    }

    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.salirVentana(btnCancelar);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.entradaCorrecta(txtPromedio, TipoError.PROMEDIO);
		this.entradaCorrecta(txtCorreoInstit, TipoError.CORREO);
		this.entradaCorrecta(txtNumCuenta, TipoError.NUMCUENTA);
		this.chcSemestre.getItems().addAll("Seleccione uno", "1", "2" ,"3", "4", "5", "6", "7", "8", "9");
		if(Alumno.getIniciarAl().isModificarAlumno(true)) {
			this.alumnoA=Alumno.getIniciarAl().getAlumnos().get(Alumno.getIniciarAl().getIndiceAlum());
			this.txtNombre.setText(alumnoA.getNombrees());
			this.txtApellidoPat.setText(alumnoA.getApellidoPaterno());
			this.txtApellidoMat.setText(alumnoA.getApellidoMaterno());
			this.chcSemestre.getSelectionModel().select(0);
		} else {
			alumnoA=Alumno.getIniciarAl().getAlumnos().get(Alumno.getIniciarAl().getIndiceAlum());
		}
	}
	
	private boolean verificacion() {
		boolean correcto= true;
		if((this.txtNombre.getText()==null)||(this.txtNombre.getText()==null && this.txtNombre.getText()==null)) {
			this.mensaje+="El Nombre no es valido, es vacio\n";
			correcto=false;
		}
		if((this.txtApellidoPat.getText()==null)||(this.txtApellidoPat.getText()==null&&this.txtApellidoPat.getText()==null)) {
			this.mensaje+="El Apellido Paterno no es valido, es vacio\n";
		}
		if((this.txtApellidoMat.getText()==null)||(this.txtApellidoMat.getText()==null&&this.txtApellidoMat.getText()==null)) {
			this.mensaje+="El Apellido Materno no es valido, es vacio\n";
			correcto=false;
		}
		if((this.txtPromedio.getText()==null)||(this.txtPromedio.getText()==null&&this.txtPromedio.getText()==null)) {
			try {
				if (this.txtPromedio != null) {
					throw new NumberFormatException();
				}
				Float.parseFloat(this.txtPromedio.getText());
			} catch (NumberFormatException ex) {
				this.mensaje+="El costo no es valido, debe tener decimales\n";
				correcto=false;
			}
		}
		if((this.txtNumCuenta.getText()==null)||(this.txtNumCuenta.getText()==null&&this.txtNumCuenta.getText()==null)) {
			this.mensaje+="El Numero de cuenta no es valido, es vacio\n";
			correcto=false;
		}
		if((this.txtCorreoInstit.getText()==null)||(this.txtCorreoInstit.getText()==null&&this.txtCorreoInstit.getText()==null)) {
			this.mensaje+="El correono es valido, es vacio\n";
			correcto=false;
		}
		if(this.chcSemestre.getSelectionModel().getSelectedIndex()==0||this.chcSemestre.getSelectionModel().getSelectedIndex()==-1) {
			this.mensaje+="Por favor, seleccione un semestre";
			correcto=false;
		}
		return correcto;
	}
}
