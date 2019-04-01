package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.SubTemaRepository;


@Service
public class SubTemaService {
	
	private SubTemaRepository subTemaRepository;

	public SubTemaService(SubTemaRepository subTemaRepository){
		this.subTemaRepository = subTemaRepository;
	}
	
	public List<SubTemaDTO> getByFk(int fk){
		
		List<SubTemaDTO> result = new ArrayList<>();
		
		for(SubTema object2 : subTemaRepository.findByFk(fk)){
			SubTemaDTO object = new SubTemaDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			try {
				TemaDTO tema = new TemaDTO();
				tema.setId(object2.getTema().getId());
				tema.setNombre(object2.getTema().getNombre());
				object.setTema(tema);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
		
	}

	/**
	 * This method transform all entities 'SubTema' in 'SubTemaDTO' in the database
	 * @return entities 'SubTema' transformed in 'SubTema'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<SubTemaDTO> getAll() {
	
		List<SubTemaDTO> result = new ArrayList<>();
	
		for(SubTema object2 : subTemaRepository.findAll()){
			SubTemaDTO object = new SubTemaDTO();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			try {
				TemaDTO tema = new TemaDTO();
				tema.setId(object2.getTema().getId());
				tema.setNombre(object2.getTema().getNombre());
				object.setTema(tema);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'SubTema' in 'SubTemaDTO' in the database
	 * @return entity 'SubTema' transformed in 'SubTemaDTO' (Data transference Object)
	 * @since 1.0
	 */
	public SubTemaDTO getOne(int id) {
	
		Optional<SubTema> aOptional = subTemaRepository.findById(id);
		SubTemaDTO object = new SubTemaDTO();
	
		try {	
	
			SubTema object2 = aOptional.get();
			object.setId(object2.getId());
			object.setNombre(object2.getNombre());
			
			try {
				TemaDTO tema = new TemaDTO();
				tema.setId(object2.getTema().getId());
				tema.setNombre(object2.getTema().getNombre());
				object.setTema(tema);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'SubTemaDTO' in the entity 'SubTema' for save it in the database
	 * @param subTemaDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'SubTemaDTO'.
	 * @since 1.0
	 */
	public SubTemaDTO save(SubTemaDTO subTemaDTO) {
		
		SubTema subTema = new SubTema();
		
		subTema.setNombre(subTemaDTO.getNombre());
		
		try {
			Tema tema = new Tema();
			tema.setId(subTemaDTO.getTema().getId());
			subTema.setTema(tema);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		subTemaRepository.save(subTema);
		
		subTemaDTO.setId(subTema.getId());
		return subTemaDTO;
		
	}
	/**
	 * This method transform an entity 'SubTemaDTO' in the entity 'SubTema' for update it in the database
	 * @param subTemaDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'SubTemaDTO'.
	 * @since 1.0
	 */
	public SubTemaDTO update(SubTemaDTO subTemaDTO, int id) {
		
		Optional<SubTema> optional = subTemaRepository.findById(id);
		SubTema subTema = new SubTema();
		
		try {
		
		subTema = optional.get();
	
		subTema.setNombre(subTemaDTO.getNombre());
		
		try {
			Tema tema = new Tema();
			tema.setId(subTemaDTO.getTema().getId());
			subTema.setTema(tema);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		subTemaRepository.save(subTema);
		
		subTemaDTO.setId(subTema.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			subTemaDTO.setId(0);
	
		}
	
		return subTemaDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'SubTema' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			subTemaRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

