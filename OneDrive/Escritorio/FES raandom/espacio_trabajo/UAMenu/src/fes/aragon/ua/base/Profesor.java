package fes.aragon.ua.base;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Profesor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Profesor iniciar = new Profesor();
	private static Materias iniciarmat = new Materias();
	private ObservableList<ProfesorInfo> grupoProfesor=FXCollections.observableArrayList();
	private boolean ModificarProfesor= false;
	private boolean ModificarAlumno=false;
	private int indice= -1;
	private int indiceMat=-1;
	
	

	public int getIndice() {
		return indice;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public int getIndiceMat() {
		return indiceMat;
	}

	public void setIndiceMat(int indiceMat) {
		this.indiceMat = indiceMat;
	}

	public static Profesor getIniciar() {
		return iniciar;
	}

	public boolean isModificarProfesor(boolean b) {
		return ModificarProfesor;
	}

	public void setModificarProfesor(boolean modificarProfesor) {
		ModificarProfesor = modificarProfesor;
	}

	public boolean isModificarAlumno() {
		return ModificarAlumno;
	}

	public void setModificarAlumno(boolean modificarAlumno) {
		ModificarAlumno = modificarAlumno;
	}

	public ObservableList<ProfesorInfo> getGrupoProfesor() {
		return grupoProfesor;
	}

	public void setGrupoProfesor() {
		this.grupoProfesor = grupoProfesor;
	}

	public static Materias getIniciarmat() {
		return iniciarmat;
	}

	public static void setIniciarmat(Materias iniciarmat) {
		Profesor.iniciarmat = iniciarmat;
	}
	
	
}
