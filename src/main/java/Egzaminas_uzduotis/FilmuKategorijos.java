package Egzaminas_uzduotis;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity

public class FilmuKategorijos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String pavadinimas;
	
	public FilmuKategorijos() {
		
		super();
		
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
