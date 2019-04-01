package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Reclamo;

@Repository
public interface ReclamoRepository extends JpaRepository <Reclamo, Integer>{}

