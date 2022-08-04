package Egzaminas_uzduotis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmaiRepository extends JpaRepository<Filmai, Integer> {
	
	@Query(value="SELECT u FROM Filmai u WHERE u.pavadinimas like %:keyword%")
	List<Filmai> findByKeyword(@Param("keyword") String keyword);
	
}
