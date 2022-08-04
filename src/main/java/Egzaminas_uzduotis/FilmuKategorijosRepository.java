package Egzaminas_uzduotis;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmuKategorijosRepository extends JpaRepository<FilmuKategorijos, Integer> {
	
	/*@Query(value="SELECT u FROM Istaiga u WHERE u.pavadinimas like %:keyword%")
	List<Istaiga> findByKeyword(@Param("keyword") String keyword);*/
	
}
