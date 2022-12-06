package fes.aragon.ua.base;

import java.io.Serializable;
import java.util.ArrayList;

public class ActividadExtraDeportiva implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean ActivEDeportiva;
	private boolean confirmarActiv;
	private ArrayList<AlumnoInfo> Deportiva;
	private int indiceActiv=-1;

	public boolean isActivEDeportiva() {
		return ActivEDeportiva;
	}

	public boolean setActivEDeportiva(boolean activEDeportiva) {
		return ActivEDeportiva = activEDeportiva;
	}

	public boolean isConfirmarActiv() {
		return confirmarActiv;
	}

	public void setConfirmarActiv(boolean confirmarActiv) {
		this.confirmarActiv = confirmarActiv;
	}

	public ArrayList<AlumnoInfo> getActividadED() {
		return Deportiva;
	}

	public void setActividadED(ArrayList<AlumnoInfo> actividadED) {
		Deportiva = actividadED;
	}

	public int getIndiceActiv() {
		return indiceActiv;
	}

	public void setIndiceActiv(int indiceActiv) {
		this.indiceActiv = indiceActiv;
	}
	
	
}