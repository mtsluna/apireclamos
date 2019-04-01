package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.TemaRepository;


@Service
public class TemaService {
	
	private TemaRepository temaRepository;

	public TemaService(TemaRepository temaRepository){
		this.temaRepository = temaRepository;
	}

	/**
	 * This method transform all entities 'Tema' in 'TemaDTO' in the database
	 * @return entities 'Tema' transformed in 'Tema'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<TemaDTO> getAll() {
	
		List<TemaDTO> result = new ArrayList<>();
	
		for(Tema object2 : temaRepository.findAll()){
			TemaDTO object = new TemaDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Tema' in 'TemaDTO' in the database
	 * @return entity 'Tema' transformed in 'TemaDTO' (Data transference Object)
	 * @since 1.0
	 */
	public TemaDTO getOne(int id) {
	
		Optional<Tema> aOptional = temaRepository.findById(id);
		TemaDTO object = new TemaDTO();
	
		try {	
	
			Tema object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'TemaDTO' in the entity 'Tema' for save it in the database
	 * @param temaDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'TemaDTO'.
	 * @since 1.0
	 */
	public TemaDTO save(TemaDTO temaDTO) {
		
		Tema tema = new Tema();
		
		tema.setNombre(temaDTO.getNombre());
		
		
		
		
		temaRepository.save(tema);
		
		temaDTO.setId(tema.getId());
		return temaDTO;
		
	}
	/**
	 * This method transform an entity 'TemaDTO' in the entity 'Tema' for update it in the database
	 * @param temaDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'TemaDTO'.
	 * @since 1.0
	 */
	public TemaDTO update(TemaDTO temaDTO, int id) {
		
		Optional<Tema> optional = temaRepository.findById(id);
		Tema tema = new Tema();
		
		try {
		
		tema = optional.get();
	
		tema.setNombre(temaDTO.getNombre());
		
		
		
		
		temaRepository.save(tema);
		
		temaDTO.setId(tema.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			temaDTO.setId(0);
	
		}
	
		return temaDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Tema' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			temaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

