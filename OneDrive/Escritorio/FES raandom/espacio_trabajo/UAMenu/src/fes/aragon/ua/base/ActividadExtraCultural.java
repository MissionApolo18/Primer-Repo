package fes.aragon.ua.base;

import java.io.Serializable;
import java.util.ArrayList;

public class ActividadExtraCultural implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  boolean ActivECultural;
	private boolean confirmarActiv;
	private ArrayList<AlumnoInfo> cultural;
	private int indiceActiv=-1;

	public boolean getActivECultural() {
		return ActivECultural;
	}

	public void setActivECultural(boolean b) {
		ActivECultural = b;
	}

	public boolean isConfirmarActiv() {
		return confirmarActiv;
	}

	public boolean setConfirmarActiv(boolean confirmarActiv) {
		return this.confirmarActiv = confirmarActiv;
	}

	public ArrayList<AlumnoInfo> getCultural() {
		return cultural;
	}

	public void setCultural(ArrayList<AlumnoInfo> cultural) {
		this.cultural = cultural;
	}

	public int getIndiceActiv() {
		return indiceActiv;
	}

	public void setIndiceActiv(int indiceActiv) {
		this.indiceActiv = indiceActiv;
	}
	
}
