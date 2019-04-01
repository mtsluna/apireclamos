package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.UbicacionRepository;


@Service
public class UbicacionService {
	
	private UbicacionRepository ubicacionRepository;

	public UbicacionService(UbicacionRepository ubicacionRepository){
		this.ubicacionRepository = ubicacionRepository;
	}

	/**
	 * This method transform all entities 'Ubicacion' in 'UbicacionDTO' in the database
	 * @return entities 'Ubicacion' transformed in 'Ubicacion'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<UbicacionDTO> getAll() {
	
		List<UbicacionDTO> result = new ArrayList<>();
	
		for(Ubicacion object2 : ubicacionRepository.findAll()){
			UbicacionDTO object = new UbicacionDTO();
			object.setId(object2.getId());
			object.setLatitud(object2.getLatitud());
			object.setLongitud(object2.getLongitud());
			object.setLugar(object2.getLugar());
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Ubicacion' in 'UbicacionDTO' in the database
	 * @return entity 'Ubicacion' transformed in 'UbicacionDTO' (Data transference Object)
	 * @since 1.0
	 */
	public UbicacionDTO getOne(int id) {
	
		Optional<Ubicacion> aOptional = ubicacionRepository.findById(id);
		UbicacionDTO object = new UbicacionDTO();
	
		try {	
	
			Ubicacion object2 = aOptional.get();
			object.setId(object2.getId());
			object.setLatitud(object2.getLatitud());
			object.setLongitud(object2.getLongitud());
			object.setLugar(object2.getLugar());
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'UbicacionDTO' in the entity 'Ubicacion' for save it in the database
	 * @param ubicacionDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'UbicacionDTO'.
	 * @since 1.0
	 */
	public UbicacionDTO save(UbicacionDTO ubicacionDTO) {
		
		Ubicacion ubicacion = new Ubicacion();
		
		ubicacion.setLatitud(ubicacionDTO.getLatitud());
		ubicacion.setLongitud(ubicacionDTO.getLongitud());
		ubicacion.setLugar(ubicacionDTO.getLugar());
		
		
		
		
		ubicacionRepository.save(ubicacion);
		
		ubicacionDTO.setId(ubicacion.getId());
		return ubicacionDTO;
		
	}
	/**
	 * This method transform an entity 'UbicacionDTO' in the entity 'Ubicacion' for update it in the database
	 * @param ubicacionDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'UbicacionDTO'.
	 * @since 1.0
	 */
	public UbicacionDTO update(UbicacionDTO ubicacionDTO, int id) {
		
		Optional<Ubicacion> optional = ubicacionRepository.findById(id);
		Ubicacion ubicacion = new Ubicacion();
		
		try {
		
		ubicacion = optional.get();
	
		ubicacion.setLatitud(ubicacionDTO.getLatitud());
		ubicacion.setLongitud(ubicacionDTO.getLongitud());
		ubicacion.setLugar(ubicacionDTO.getLugar());
		
		
		
		
		ubicacionRepository.save(ubicacion);
		
		ubicacionDTO.setId(ubicacion.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			ubicacionDTO.setId(0);
	
		}
	
		return ubicacionDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Ubicacion' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			ubicacionRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

