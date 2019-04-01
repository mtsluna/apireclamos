package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository <Direccion, Integer>{}

