package fes.aragon.ua.base;

import java.util.ArrayList;

public class AlumnoInfo {
	private ArrayList<AlumnoInfo> Nombres;
	private String ApellidoPaterno;
	private String ApellidoMaterno;
	private String NumCuenta;
	private String Correo;
	private String QueActExtra;
	private String semestre;
	private  String PromedioGen;
	private String Nombrees;
	private boolean ActivExtra;
	
	public AlumnoInfo() {
		super();
	}

	public ArrayList<AlumnoInfo> getNombres() {
		return Nombres;
	}

	public void setNombres(ArrayList<AlumnoInfo> string) {
		Nombres = string;
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

	public String getNumCuenta() {
		return NumCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		NumCuenta = numCuenta;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getQueActExtra() {
		return QueActExtra;
	}

	public void setQueActExtra(String queActExtra) {
		QueActExtra = queActExtra;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String string) {
		this.semestre = string;
	}

	public String getPromedioGen() {
		return PromedioGen;
	}

	public void setPromedioGen(String string) {
		PromedioGen = string;
	}

	public boolean isActivExtra() {
		return ActivExtra;
	}

	public void setActivExtra(boolean activExtra) {
		ActivExtra = activExtra;
	}

	@Override
	public String toString() {
		return "AlumnoInfo [Nombres=" + Nombres + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno="
				+ ApellidoMaterno + ", NumCuenta=" + NumCuenta + ", Correo=" + Correo + ", QueActExtra=" + QueActExtra
				+ ", semestre=" + semestre + ", PromedioGen=" + PromedioGen + ", ActivExtra=" + ActivExtra + "]";
	}

	public String getNombrees() {
		return Nombrees;
	}

	public void setNombrees(String text) {
		// TODO Auto-generated method stub
		
	}
	
}