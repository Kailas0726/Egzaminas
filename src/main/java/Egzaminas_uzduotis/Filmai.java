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

public class Filmai {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private Integer kategorijos_id;
	private String pavadinimas;
	private String aprasas;
	private String imdb_reitingas;
	
	@JsonIgnore
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name="kategorijos_id", referencedColumnName="id",insertable=false, updatable=false)
	private FilmuKategorijos filmu_kategorijos;
	
	public Filmai() {
		
		super();
		
	}
	
	public Filmai(String id, String kategorijos_id, String pavadinimas, String aprasas, String imdb_reitingas) {
		
		super();
		this.id = Integer.parseInt(id);
		this.kategorijos_id = Integer.parseInt(kategorijos_id);
		this.pavadinimas = pavadinimas;
		this.aprasas = aprasas;
		this.imdb_reitingas = imdb_reitingas;
		
	}

	public FilmuKategorijos getFilmu_kategorijos() {
		return filmu_kategorijos;
	}

	public void setFilmu_kategorijos(FilmuKategorijos filmu_kategorijos) {
		this.filmu_kategorijos = filmu_kategorijos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKategorijos_id() {
		return kategorijos_id;
	}

	public void setKategorijos_id(Integer kategorijos_id) {
		this.kategorijos_id = kategorijos_id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getAprasas() {
		return aprasas;
	}

	public void setAprasas(String aprasas) {
		this.aprasas = aprasas;
	}

	public String getImdb_reitingas() {
		return imdb_reitingas;
	}

	public void setImdb_reitingas(String imdb_reitingas) {
		this.imdb_reitingas = imdb_reitingas;
	}

}
