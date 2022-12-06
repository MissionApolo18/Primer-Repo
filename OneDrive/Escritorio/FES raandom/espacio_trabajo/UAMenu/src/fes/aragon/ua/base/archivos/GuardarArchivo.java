package fes.aragon.ua.base.archivos;

import java.util.ArrayList;

import fes.aragon.ua.base.AlumnoInfo;
import fes.aragon.ua.base.Materias;
import fes.aragon.ua.base.ProfesorInfo;

public class GuardarArchivo {
	private ArrayList<AlumnoInfo> alumnos = new ArrayList<>();
	private ArrayList<ProfesorInfo> profesores = new ArrayList<>();
	private ArrayList<ProfesorInfo> nombre= new ArrayList<>();
	private String ApellidoPat;
	private String ApellidoMat;
	private String correoInstit;
	private String RFC;
	private String materia;
	private String NumCuenta;
	private String semestre;
	private String foto;

	public void setAlumnos(ArrayList<AlumnoInfo> string) {
		this.alumnos = string;
	}

	public ArrayList<ProfesorInfo> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<ProfesorInfo> profesores) {
		this.profesores = profesores;
	}

	public ArrayList<ProfesorInfo> getNombre() {
		return nombre;
	}

	public void setNombre(ArrayList <ProfesorInfo> nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPat() {
		return ApellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		ApellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return ApellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		ApellidoMat = apellidoMat;
	}

	public String getCorreoInstit() {
		return correoInstit;
	}

	public void setCorreoInstit(String correoInstit) {
		this.correoInstit = correoInstit;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}

	public String getNumCuenta() {
		return NumCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		NumCuenta = numCuenta;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String string) {
		this.semestre = string;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getMateria(ArrayList<Materias> arrayList) {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "GuardarArchivo [alumnos=" + alumnos + ", profesores=" + profesores + ", nombre=" + nombre
				+ ", ApellidoPat=" + ApellidoPat + ", ApellidoMat=" + ApellidoMat + ", correoInstit=" + correoInstit
				+  ", RFC=" + RFC + ", materia=" + materia + ", NumCuenta=" + NumCuenta
				+ ", semestre=" + semestre + ", foto=" + foto + "]";
	}
	
}
