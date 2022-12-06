package fes.aragon.ua.base;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfesorInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Attributes 
	private String Nombre;
	private String ApellidoPaterno;
	private String ApellidoMaterno;
	private String CorreoInstit;
	private String RFC;
	private ArrayList<Materias> materia = new ArrayList<Materias> ();
	private ArrayList<AlumnoInfo> alumno = new ArrayList<AlumnoInfo> ();
	//Methods
	public ProfesorInfo() {
		super();
	}
	
	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}

	public String getCorreoInstit() {
		return CorreoInstit;
	}

	public void setCorreoInstit(String correoInstit) {
		CorreoInstit = correoInstit;
	}

	public String getRFC() {
		return RFC;
	}
	
	public void setRFC(String rFC) {
		RFC = rFC;
	}
	
	public ArrayList<Materias> getMateria() {
		return materia;
	}

	public void setMateria(ArrayList<Materias> materia) {
		this.materia = materia;
	}

	public ArrayList<AlumnoInfo> getAlumno() {
		return alumno;
	}

	public void setAlumno(ArrayList<AlumnoInfo> alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "ProfesorInfo [Nombres=" + Nombre + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno="
				+ ApellidoMaterno + ", CorreoInstit=" + CorreoInstit + ", RFC=" + RFC + ", materia=" + materia
				+ ", alumno=" + alumno + "]";
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String string) {
		Nombre = string;
	}
	
}
