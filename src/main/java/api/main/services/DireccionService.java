package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.DireccionRepository;


@Service
public class DireccionService {
	
	private DireccionRepository direccionRepository;

	public DireccionService(DireccionRepository direccionRepository){
		this.direccionRepository = direccionRepository;
	}

	/**
	 * This method transform all entities 'Direccion' in 'DireccionDTO' in the database
	 * @return entities 'Direccion' transformed in 'Direccion'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<DireccionDTO> getAll() {
	
		List<DireccionDTO> result = new ArrayList<>();
	
		for(Direccion object2 : direccionRepository.findAll()){
			DireccionDTO object = new DireccionDTO();
			object.setId(object2.getId());
			object.setCalle(object2.getCalle());
			object.setNumero(object2.getNumero());
			object.setDepartamento(object2.getDepartamento());
			object.setPiso(object2.getPiso());
			
			try {
				LocalidadDTO localidad = new LocalidadDTO();
				localidad.setId(object2.getLocalidad().getId());
				localidad.setNombre(object2.getLocalidad().getNombre());
				object.setLocalidad(localidad);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Direccion' in 'DireccionDTO' in the database
	 * @return entity 'Direccion' transformed in 'DireccionDTO' (Data transference Object)
	 * @since 1.0
	 */
	public DireccionDTO getOne(int id) {
	
		Optional<Direccion> aOptional = direccionRepository.findById(id);
		DireccionDTO object = new DireccionDTO();
	
		try {	
	
			Direccion object2 = aOptional.get();
			object.setId(object2.getId());
			object.setCalle(object2.getCalle());
			object.setNumero(object2.getNumero());
			object.setDepartamento(object2.getDepartamento());
			object.setPiso(object2.getPiso());
			
			try {
				LocalidadDTO localidad = new LocalidadDTO();
				localidad.setId(object2.getLocalidad().getId());
				localidad.setNombre(object2.getLocalidad().getNombre());
				object.setLocalidad(localidad);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'DireccionDTO' in the entity 'Direccion' for save it in the database
	 * @param direccionDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'DireccionDTO'.
	 * @since 1.0
	 */
	public DireccionDTO save(DireccionDTO direccionDTO) {
		
		Direccion direccion = new Direccion();
		
		direccion.setCalle(direccionDTO.getCalle());
		direccion.setNumero(direccionDTO.getNumero());
		direccion.setDepartamento(direccionDTO.getDepartamento());
		direccion.setPiso(direccionDTO.getPiso());
		
		try {
			Localidad localidad = new Localidad();
			localidad.setId(direccionDTO.getLocalidad().getId());
			direccion.setLocalidad(localidad);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		direccionRepository.save(direccion);
		
		direccionDTO.setId(direccion.getId());
		return direccionDTO;
		
	}
	/**
	 * This method transform an entity 'DireccionDTO' in the entity 'Direccion' for update it in the database
	 * @param direccionDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'DireccionDTO'.
	 * @since 1.0
	 */
	public DireccionDTO update(DireccionDTO direccionDTO, int id) {
		
		Optional<Direccion> optional = direccionRepository.findById(id);
		Direccion direccion = new Direccion();
		
		try {
		
		direccion = optional.get();
	
		direccion.setCalle(direccionDTO.getCalle());
		direccion.setNumero(direccionDTO.getNumero());
		direccion.setDepartamento(direccionDTO.getDepartamento());
		direccion.setPiso(direccionDTO.getPiso());
		
		try {
			Localidad localidad = new Localidad();
			localidad.setId(direccionDTO.getLocalidad().getId());
			direccion.setLocalidad(localidad);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		direccionRepository.save(direccion);
		
		direccionDTO.setId(direccion.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			direccionDTO.setId(0);
	
		}
	
		return direccionDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Direccion' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			direccionRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

