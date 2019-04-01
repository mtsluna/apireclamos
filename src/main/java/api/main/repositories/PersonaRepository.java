package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Integer>{}

