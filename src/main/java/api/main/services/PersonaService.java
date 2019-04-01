package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.PersonaRepository;


@Service
public class PersonaService {
	
	private PersonaRepository personaRepository;

	public PersonaService(PersonaRepository personaRepository){
		this.personaRepository = personaRepository;
	}

	/**
	 * This method transform all entities 'Persona' in 'PersonaDTO' in the database
	 * @return entities 'Persona' transformed in 'Persona'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<PersonaDTO> getAll() {
	
		List<PersonaDTO> result = new ArrayList<>();
	
		for(Persona object2 : personaRepository.findAll()){
			PersonaDTO object = new PersonaDTO();
			object.setId(object2.getId());
			object.setNumero_documento(object2.getNumero_documento());
			object.setNombre(object2.getNombre());
			object.setApellido(object2.getApellido());
			object.setEmail(object2.getEmail());
			object.setTipo_documento(object2.getTipo_documento());
			
			try {
				DireccionDTO direccion = new DireccionDTO();
				direccion.setId(object2.getDireccion().getId());
				direccion.setCalle(object2.getDireccion().getCalle());
				direccion.setNumero(object2.getDireccion().getNumero());
				direccion.setDepartamento(object2.getDireccion().getDepartamento());
				direccion.setPiso(object2.getDireccion().getPiso());
				object.setDireccion(direccion);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Persona' in 'PersonaDTO' in the database
	 * @return entity 'Persona' transformed in 'PersonaDTO' (Data transference Object)
	 * @since 1.0
	 */
	public PersonaDTO getOne(int id) {
	
		Optional<Persona> aOptional = personaRepository.findById(id);
		PersonaDTO object = new PersonaDTO();
	
		try {	
	
			Persona object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNumero_documento(object2.getNumero_documento());
			object.setNombre(object2.getNombre());
			object.setApellido(object2.getApellido());
			object.setEmail(object2.getEmail());
			object.setTipo_documento(object2.getTipo_documento());
			
			try {
				DireccionDTO direccion = new DireccionDTO();
				direccion.setId(object2.getDireccion().getId());
				direccion.setCalle(object2.getDireccion().getCalle());
				direccion.setNumero(object2.getDireccion().getNumero());
				direccion.setDepartamento(object2.getDireccion().getDepartamento());
				direccion.setPiso(object2.getDireccion().getPiso());
				object.setDireccion(direccion);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'PersonaDTO' in the entity 'Persona' for save it in the database
	 * @param personaDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'PersonaDTO'.
	 * @since 1.0
	 */
	public PersonaDTO save(PersonaDTO personaDTO) {
		
		Persona persona = new Persona();
		
		persona.setNumero_documento(personaDTO.getNumero_documento());
		persona.setNombre(personaDTO.getNombre());
		persona.setApellido(personaDTO.getApellido());
		persona.setEmail(personaDTO.getEmail());
		persona.setTipo_documento(personaDTO.getTipo_documento());
		
		try {
			Direccion direccion = new Direccion();
			direccion.setId(personaDTO.getDireccion().getId());
			persona.setDireccion(direccion);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		personaRepository.save(persona);
		
		personaDTO.setId(persona.getId());
		return personaDTO;
		
	}
	/**
	 * This method transform an entity 'PersonaDTO' in the entity 'Persona' for update it in the database
	 * @param personaDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'PersonaDTO'.
	 * @since 1.0
	 */
	public PersonaDTO update(PersonaDTO personaDTO, int id) {
		
		Optional<Persona> optional = personaRepository.findById(id);
		Persona persona = new Persona();
		
		try {
		
		persona = optional.get();
	
		persona.setNumero_documento(personaDTO.getNumero_documento());
		persona.setNombre(personaDTO.getNombre());
		persona.setApellido(personaDTO.getApellido());
		persona.setEmail(personaDTO.getEmail());
		persona.setTipo_documento(personaDTO.getTipo_documento());
		
		try {
			Direccion direccion = new Direccion();
			direccion.setId(personaDTO.getDireccion().getId());
			persona.setDireccion(direccion);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		personaRepository.save(persona);
		
		personaDTO.setId(persona.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			personaDTO.setId(0);
	
		}
	
		return personaDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Persona' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			personaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

