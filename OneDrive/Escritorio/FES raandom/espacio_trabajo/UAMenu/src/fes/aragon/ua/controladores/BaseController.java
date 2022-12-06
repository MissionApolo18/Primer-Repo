package fes.aragon.ua.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fes.aragon.ua.base.Alumno;
import fes.aragon.ua.base.AlumnoInfo;
import fes.aragon.ua.base.Profesor;
import fes.aragon.ua.base.ProfesorInfo;
import fes.aragon.ua.base.TipoError;
import fes.aragon.ua.base.archivos.GuardarArchivo;
import javafx.css.PseudoClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BaseController {
	protected boolean RFCValido = true;
	protected boolean CorreoValido = true;
	protected boolean NumCuentaValido = true;
	protected boolean PromGenValido = true;
	public Button boton;

	private String[] expresionesA = { "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", // correo
			"(\\w){13}", // RFC
			"(\\d+)(\\.\\d{1,2})", // promedio
			"(\\d){9}" // número de cuenta
	};

	public void ventanaNueva(String archivo) {
		try {
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("/fes/aragon/ua/fxml/" + archivo + ".fxml"));
			Scene scene = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(scene);
			escenario.initStyle(StageStyle.DECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void salirVentana(Button boton) {
		Stage stage = (Stage) boton.getScene().getWindow();
		stage.close();
	}

	public void entradaCorrecta(TextField caja, TipoError error) {
		caja.textProperty().addListener(evento -> {
			String text = caja.getText();
			if(text==null) {
				text=" ";
			}
			String patrones=expresionesA[error.ordinal()];
			Pattern pt =Pattern.compile(patrones);
			Matcher match=pt.matcher(text);
			caja.pseudoClassStateChanged(PseudoClass.getPseudoClass("error"),!match.matches());
			if (error==TipoError.NUMCUENTA) {
				this.NumCuentaValido=match.matches();
			} else if (error==TipoError.CORREO){
				this.CorreoValido=match.matches();
			} else if (error==TipoError.NUMEROS) {
				this.PromGenValido=match.matches();
			} else if (error==TipoError.RFC) {
				this.RFCValido=match.matches();
			}
		});
	}
	
	public void avisoEmergente(String titulo, String encabezado, String contenido) {
		Alert aviso;
		aviso= new Alert (AlertType.INFORMATION);
		aviso.setTitle(titulo);
		aviso.setHeaderText(encabezado);
		aviso.setContentText(contenido);
		aviso.showAndWait();
	}
	
	public void guardarArchivo (Button boton) throws IOException {
		Stage stage=(Stage) boton.getScene().getWindow();
		FileChooser archivo=new FileChooser();
		
		archivo.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos Alumno y Profesor", "*.txt"));
		archivo.setTitle("Guardar Archivo");
		archivo.setInitialDirectory(new File(System.getProperty("user.dir")));
		File rutaA=archivo.showSaveDialog(stage);
		if(rutaA!=null) {
			FileOutputStream fo=new FileOutputStream(rutaA);
			ObjectOutputStream salidaA=new ObjectOutputStream(fo);
			ArrayList<AlumnoInfoController> ProfesyAlumn = new ArrayList<>();
			for (ProfesorInfo profesores: Profesor.getIniciar().getGrupoProfesor()) {
				GuardarArchivo objeto = new GuardarArchivo();
				objeto.setApellidoPat(profesores.getApellidoPaterno());
				objeto.setApellidoMat(profesores.getApellidoMaterno());
				objeto.setCorreoInstit(profesores.getCorreoInstit());
				objeto.setRFC(profesores.getRFC());
				objeto.setCorreoInstit(profesores.getCorreoInstit());
				objeto.getMateria(profesores.getMateria());
			}
			for (AlumnoInfo alumnos: Alumno.getIniciarAl().getAlumnos()) {
				GuardarArchivo objeto = new GuardarArchivo();
				objeto.setAlumnos(alumnos.getNombres());
				objeto.setApellidoPat(alumnos.getApellidoPaterno());
				objeto.setApellidoMat(alumnos.getApellidoMaterno());
				objeto.setCorreoInstit(alumnos.getCorreo());
				objeto.setNumCuenta(alumnos.getNumCuenta());
				objeto.setSemestre(alumnos.getSemestre());
			};
			salidaA.writeObject(ProfesyAlumn);
			salidaA.close();
			fo.close();
		}
	}
	
	public void abrirArchivo(Button boton) throws IOException, ClassNotFoundException {
		Stage stage = (Stage) boton.getScene().getWindow();
		FileChooser archivo = new FileChooser();
		archivo.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Archivos Alumno y Profesor", "*.txt"));
		archivo.setTitle("Abrir Archivo");
		archivo.setInitialDirectory(new File(System.getProperty("user.dir")));
		File ruta = archivo.showOpenDialog(stage);
		if(ruta!=null) {
			FileInputStream fi = new FileInputStream(ruta);
			ObjectInputStream entrada = new ObjectInputStream(fi);
			ArrayList<GuardarArchivo> datoos= (ArrayList <GuardarArchivo>) entrada.readObject();
			Profesor.getIniciar().getGrupoProfesor().clear();
			for (GuardarArchivo datess: datoos) {
				Profesor profesor = new Profesor();
				//Profesor.getIniciar().getGrupoProfesor().addAll(profesor.toString());
			}
			Alumno.getIniciarAl().getAlumnos().clear();
			for(GuardarArchivo datess: datoos) {
				Alumno alumno = new Alumno();
				//Alumno.getIniciarAl().getAlumnos().addAll(alumno.toString());
			}
			fi.close();
			entrada.close();
		}
	}

}
