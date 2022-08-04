package Egzaminas_uzduotis;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class FilmuKategorijos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String pavadinimas;
	
	@JsonIgnore
	@OneToMany//(cascade = CascadeType.ALL)
	@JoinColumn(name="kategorijos_id", referencedColumnName="id",insertable=false, updatable=false)
	private List<Filmai> filmai;
	
	public FilmuKategorijos() {
		
		super();
		
	}

	public List<Filmai> getFilmai() {
		return filmai;
	}

	public void setFilmai(List<Filmai> filmai) {
		this.filmai = filmai;
	}

	public Integer getId() {
		
		return id;
		
	}

	public void setId(Integer id) {
		
		this.id = id;
		
	}
	
	public String getPavadinimas() {
		
		return pavadinimas;
		
	}

	public void setPavadinimas(String pavadinimas) {
		
		this.pavadinimas = pavadinimas;
		
	}
	
	

}
