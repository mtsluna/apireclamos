package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.FotoRepository;


@Service
public class FotoService {
	
	private FotoRepository fotoRepository;

	public FotoService(FotoRepository fotoRepository){
		this.fotoRepository = fotoRepository;
	}

	/**
	 * This method transform all entities 'Foto' in 'FotoDTO' in the database
	 * @return entities 'Foto' transformed in 'Foto'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<FotoDTO> getAll() {
	
		List<FotoDTO> result = new ArrayList<>();
	
		for(Foto object2 : fotoRepository.findAll()){
			FotoDTO object = new FotoDTO();
			object.setId(object2.getId());
			object.setSource(object2.getSource());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Foto' in 'FotoDTO' in the database
	 * @return entity 'Foto' transformed in 'FotoDTO' (Data transference Object)
	 * @since 1.0
	 */
	public FotoDTO getOne(int id) {
	
		Optional<Foto> aOptional = fotoRepository.findById(id);
		FotoDTO object = new FotoDTO();
	
		try {	
	
			Foto object2 = aOptional.get();
			object.setId(object2.getId());
			object.setSource(object2.getSource());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'FotoDTO' in the entity 'Foto' for save it in the database
	 * @param fotoDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'FotoDTO'.
	 * @since 1.0
	 */
	public FotoDTO save(FotoDTO fotoDTO) {
		
		Foto foto = new Foto();
		
		foto.setSource(fotoDTO.getSource());
		
		
		
		
		fotoRepository.save(foto);
		
		fotoDTO.setId(foto.getId());
		return fotoDTO;
		
	}
	/**
	 * This method transform an entity 'FotoDTO' in the entity 'Foto' for update it in the database
	 * @param fotoDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'FotoDTO'.
	 * @since 1.0
	 */
	public FotoDTO update(FotoDTO fotoDTO, int id) {
		
		Optional<Foto> optional = fotoRepository.findById(id);
		Foto foto = new Foto();
		
		try {
		
		foto = optional.get();
	
		foto.setSource(fotoDTO.getSource());
		
		
		
		
		fotoRepository.save(foto);
		
		fotoDTO.setId(foto.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			fotoDTO.setId(0);
	
		}
	
		return fotoDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Foto' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			fotoRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

