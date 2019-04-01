package api.main.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.main.model.SubTema;

@Repository
public interface SubTemaRepository extends JpaRepository <SubTema, Integer>{
	
	@Query(value = "SELECT * FROM api_subtema WHERE fk_tema = ?1", nativeQuery = true)
	public List<SubTema> findByFk(Integer tema);
	
}


