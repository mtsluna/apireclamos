package api.main.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.main.model.Localidad;
import api.main.model.SubTema;

@Repository
public interface LocalidadRepository extends JpaRepository <Localidad, Integer>{
	
	@Query(value = "SELECT * FROM api_localidad WHERE fk_localidad_provincia = ?1", nativeQuery = true)
	public List<Localidad> findByFk(Integer provincia);
	
}

