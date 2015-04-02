package net.francais.mashi.dic.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "dic_mot_mashi")
public class MotMashi extends Mot{

	private String origine;
	private String imageUrl;
	private String singlier;
	private String pluriel;
	@OneToOne(mappedBy="motMashi")
	private Example example;
	@ManyToOne
	@JoinColumn(name = "langue_origine", nullable = true)
	private LangueOrigine langueOrigine;
	@OneToOne
	@JoinColumn(name="mot_francais")
	private MotFrancais motFrancais;


	public MotFrancais getMotFrancais() {
		return motFrancais;
	}

	public void setMotFrancais(MotFrancais motFrancais) {
		this.motFrancais = motFrancais;
	}
	
	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSinglier() {
		return singlier;
	}

	public void setSinglier(String singlier) {
		this.singlier = singlier;
	}

	public String getPluriel() {
		return pluriel;
	}

	public void setPluriel(String pluriel) {
		this.pluriel = pluriel;
	}

	public LangueOrigine getLangueOrigine() {
		return langueOrigine;
	}

	public void setLangueOrigine(LangueOrigine langueOrigine) {
		this.langueOrigine = langueOrigine;
	}
	

	public Example getExample() {
		return example;
	}

	public void setExample(Example example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "MotMashi [id=" + super.getMot() + ", mot=" + super.getMot() + ", motFrancais="
				+ motFrancais + "]";
	}
}
