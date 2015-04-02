package net.francais.mashi.dic.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="dic_example")
public class Example {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="txt_francais", nullable=false)
	private String txtFrancais;
	@Column(name="txt_mashi", nullable=false)
	private String txtMashi;
	@OneToOne
	@JoinColumn(name="mot_mashi")
	private MotMashi motMashi;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTxtFrancais() {
		return txtFrancais;
	}
	public void setTxtFrancais(String txtFrancais) {
		this.txtFrancais = txtFrancais;
	}
	public String getTxtMashi() {
		return txtMashi;
	}
	public void setTxtMashi(String txtMashi) {
		this.txtMashi = txtMashi;
	}
	public MotMashi getMotMashi() {
		return motMashi;
	}
	public void setMotMashi(MotMashi motMashi) {
		this.motMashi = motMashi;
	}
	
	@Override
	public String toString() {
		return "Example [id=" + id + ", motMashi=" + motMashi.getMot() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((motMashi == null) ? 0 : motMashi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Example other = (Example) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (motMashi == null) {
			if (other.motMashi != null)
				return false;
		} else if (!motMashi.equals(other.motMashi))
			return false;
		return true;
	}
	
}
