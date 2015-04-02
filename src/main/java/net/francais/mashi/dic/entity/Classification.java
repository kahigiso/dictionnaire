package net.francais.mashi.dic.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="dic_classification")
public class Classification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	//private String abbreviation;
	//private List<MotMashi> motsMashi = new ArrayList<MotMashi>();;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getAbbreviation() {
//		return abbreviation;
//	}
//	public void setAbbreviation(String abbreviation) {
//		this.abbreviation = abbreviation;
//	}
//	public List<MotMashi> getMotsMashi() {
//		return motsMashi;
//	}
//	public void setMotsMashi(List<MotMashi> motsMashi) {
//		this.motsMashi = motsMashi;
//	}
	
//	@Override
//	public String toString() {
//		return "Classification [id=" + id + ", name=" + name
//				+ ", abbreviation=" + abbreviation + "]";
//	}
	
}
