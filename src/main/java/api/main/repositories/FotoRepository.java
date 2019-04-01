package api.main.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.main.model.Foto;

@Repository
public interface FotoRepository extends JpaRepository <Foto, Integer>{}

