package fes.aragon.ua.base;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Alumno implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Alumno iniciarAl = new Alumno();
	private ActividadExtraCultural iniciarActiv=new ActividadExtraCultural();
	private ActividadExtraDeportiva iniciarActivB = new ActividadExtraDeportiva();
	private ObservableList<AlumnoInfo> alumnos=FXCollections.observableArrayList();
	private int indiceAlum=-1;
	private int indiceActiv=-1;
	private boolean ModificarAlumno=false;
	private boolean AnadirFoto=false;
	private ObservableList<AlumnoInfo> foto;
	private static Alumno guardarArchivo = new Alumno();

	public ObservableList<AlumnoInfo> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ObservableList<AlumnoInfo> string) {
		this.alumnos = string;
	}

	public int getIndiceAlum() {
		return indiceAlum;
	}

	public void setIndiceAlum(int indiceAlum) {
		this.indiceAlum = indiceAlum;
	}

	public int getIndiceActiv() {
		return indiceActiv;
	}
	
	public void setIndiceActiv(int indiceActiv) {
		this.indiceActiv = indiceActiv;
	}
	
	public boolean isModificarAlumno(boolean b) {
		return ModificarAlumno;
	}

	public void setModificarAlumno(boolean modificarAlumno) {
		ModificarAlumno = modificarAlumno;
	}

	public static Alumno getIniciarAl() {
		return iniciarAl;
	}

	public boolean isAnadirFoto() {
		return AnadirFoto;
	}

	public void setAnadirFoto(boolean anadirFoto) {
		AnadirFoto = anadirFoto;
	}

	public static Alumno getGuardarArchivo() {
		return guardarArchivo;
	}

	public static void setGuardarArchivo(Alumno guardarArchivo) {
		Alumno.guardarArchivo = guardarArchivo;
	}

	public ObservableList<AlumnoInfo> getFoto() {
		return foto;
	}

	public void setFoto(ObservableList<AlumnoInfo> foto) {
		this.foto = foto;
	}
	

	public ActividadExtraCultural getIniciarActiv() {
		return iniciarActiv;
	}

	public void setIniciarActiv(ActividadExtraCultural iniciarActiv) {
		this.iniciarActiv = iniciarActiv;
	}

	public ActividadExtraDeportiva getIniciarActivB() {
		return iniciarActivB;
	}

	public void setIniciarActivB(ActividadExtraDeportiva iniciarActivB) {
		this.iniciarActivB = iniciarActivB;
	}
	
}
