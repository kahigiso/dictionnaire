package net.francais.mashi.dic.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="dic_mot_francais")
public class MotFrancais extends Mot{
	
	@Column(unique=true)
	private String precision;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Domaine domaine;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Nature nature;
	@OneToOne(mappedBy="motFrancais")
	private MotMashi motMashi;
	
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	
	public Nature getNature() {
		return nature;
	}
	public void setNature(Nature nature) {
		this.nature = nature;
	}
	public MotMashi getMotMashi() {
		return motMashi;
	}
	public void setMotMashi(MotMashi motMashi) {
		this.motMashi = motMashi;
	}
	
	@Override
	public String toString() {
		return "MotFrancais [id=" + super.getMot() + ", mot=" + super.getMot() + ", precision="
				+ precision + ", motMashi=" + motMashi + "]";
	}
	
}
