package fes.aragon.ua.base;

import java.io.Serializable;

import javafx.scene.control.SingleSelectionModel;

public class Materias implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NomMateria;
	private String SemImparte;
	
	public Materias() {
		super();
	}

	public String getNomMateria() {
		return NomMateria;
	}
	
	public void setNomMateria(String nomMateria) {
		NomMateria = nomMateria;
	}

	public String getSemImparte() {
		return SemImparte;
	}

	public void setSemImparte(SingleSelectionModel<String> singleSelectionModel) {
		SemImparte = singleSelectionModel;
	}
	
	
}
