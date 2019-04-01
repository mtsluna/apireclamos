package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository <Tema, Integer>{}

