package api.main.services;
import java.util.*;
import org.springframework.stereotype.Service;
import api.main.dtos.*;
import api.main.model.*;
import api.main.repositories.ReclamoRepository;


@Service
public class ReclamoService {
	
	private ReclamoRepository reclamoRepository;

	public ReclamoService(ReclamoRepository reclamoRepository){
		this.reclamoRepository = reclamoRepository;
	}

	/**
	 * This method transform all entities 'Reclamo' in 'ReclamoDTO' in the database
	 * @return entities 'Reclamo' transformed in 'Reclamo'DTO (Data transference Object)
	 * @since 1.0
	 */
	public List<ReclamoDTO> getAll() {
	
		List<ReclamoDTO> result = new ArrayList<>();
	
		for(Reclamo object2 : reclamoRepository.findAll()){
			ReclamoDTO object = new ReclamoDTO();
			object.setId(object2.getId());
			object.setDescripcion(object2.getDescripcion());
			object.setFecha(object2.getFecha());
			
			try {
				PersonaDTO persona = new PersonaDTO();
				persona.setId(object2.getPersona().getId());
				persona.setNumero_documento(object2.getPersona().getNumero_documento());
				persona.setNombre(object2.getPersona().getNombre());
				persona.setApellido(object2.getPersona().getApellido());
				persona.setEmail(object2.getPersona().getEmail());
				persona.setTipo_documento(object2.getPersona().getTipo_documento());
				object.setPersona(persona);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				SubTemaDTO subTema = new SubTemaDTO();
				subTema.setId(object2.getSubtema().getId());
				subTema.setNombre(object2.getSubtema().getNombre());
				object.setSubtema(subTema);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				FotoDTO foto = new FotoDTO();
				foto.setId(object2.getFoto().getId());
				foto.setSource(object2.getFoto().getSource());
				object.setFoto(foto);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				UbicacionDTO ubicacion = new UbicacionDTO();
				ubicacion.setId(object2.getUbicacion().getId());
				ubicacion.setLatitud(object2.getUbicacion().getLatitud());
				ubicacion.setLongitud(object2.getUbicacion().getLongitud());
				ubicacion.setLugar(object2.getUbicacion().getLugar());
				object.setUbicacion(ubicacion);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			result.add(object);		
		}
	
		return result;
	
	}
	/**
	 * This method transform an entity 'Reclamo' in 'ReclamoDTO' in the database
	 * @return entity 'Reclamo' transformed in 'ReclamoDTO' (Data transference Object)
	 * @since 1.0
	 */
	public ReclamoDTO getOne(int id) {
	
		Optional<Reclamo> aOptional = reclamoRepository.findById(id);
		ReclamoDTO object = new ReclamoDTO();
	
		try {	
	
			Reclamo object2 = aOptional.get();
			object.setId(object2.getId());
			object.setDescripcion(object2.getDescripcion());
			object.setFecha(object2.getFecha());
			
			try {
				PersonaDTO persona = new PersonaDTO();
				persona.setId(object2.getPersona().getId());
				persona.setNumero_documento(object2.getPersona().getNumero_documento());
				persona.setNombre(object2.getPersona().getNombre());
				persona.setApellido(object2.getPersona().getApellido());
				persona.setEmail(object2.getPersona().getEmail());
				persona.setTipo_documento(object2.getPersona().getTipo_documento());
				object.setPersona(persona);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				SubTemaDTO subTema = new SubTemaDTO();
				subTema.setId(object2.getSubtema().getId());
				subTema.setNombre(object2.getSubtema().getNombre());
				object.setSubtema(subTema);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				FotoDTO foto = new FotoDTO();
				foto.setId(object2.getFoto().getId());
				foto.setSource(object2.getFoto().getSource());
				object.setFoto(foto);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			try {
				UbicacionDTO ubicacion = new UbicacionDTO();
				ubicacion.setId(object2.getUbicacion().getId());
				ubicacion.setLatitud(object2.getUbicacion().getLatitud());
				ubicacion.setLongitud(object2.getUbicacion().getLongitud());
				ubicacion.setLugar(object2.getUbicacion().getLugar());
				object.setUbicacion(ubicacion);
			
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
			
	
		} catch (Exception e) {
	
			System.out.println("No existe el id");
			
		}
		
		return object;
	
	
	}
	/**
	 * This method transform an entity 'ReclamoDTO' in the entity 'Reclamo' for save it in the database
	 * @param reclamoDTO it is an object DTO that comes from controller that will transformed in an entity
	 * @return entities 'ReclamoDTO'.
	 * @since 1.0
	 */
	public ReclamoDTO save(ReclamoDTO reclamoDTO) {
		
		Reclamo reclamo = new Reclamo();
		
		reclamo.setDescripcion(reclamoDTO.getDescripcion());
		reclamo.setFecha(reclamoDTO.getFecha());
		
		try {
			Persona persona = new Persona();
			persona.setId(reclamoDTO.getPersona().getId());
			reclamo.setPersona(persona);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			SubTema subTema = new SubTema();
			subTema.setId(reclamoDTO.getSubtema().getId());
			reclamo.setSubtema(subTema);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Foto foto = new Foto();
			foto.setId(reclamoDTO.getFoto().getId());
			reclamo.setFoto(foto);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			ubicacion.setId(reclamoDTO.getUbicacion().getId());
			reclamo.setUbicacion(ubicacion);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		reclamoRepository.save(reclamo);
		
		reclamoDTO.setId(reclamo.getId());
		return reclamoDTO;
		
	}
	/**
	 * This method transform an entity 'ReclamoDTO' in the entity 'Reclamo' for update it in the database
	 * @param reclamoDTO it is an object DTO that will transformed.
	 * @param id it is an id that corresponds with the index of the entity in the DB.
	 * @return entities 'ReclamoDTO'.
	 * @since 1.0
	 */
	public ReclamoDTO update(ReclamoDTO reclamoDTO, int id) {
		
		Optional<Reclamo> optional = reclamoRepository.findById(id);
		Reclamo reclamo = new Reclamo();
		
		try {
		
		reclamo = optional.get();
	
		reclamo.setDescripcion(reclamoDTO.getDescripcion());
		reclamo.setFecha(reclamoDTO.getFecha());
		
		try {
			Persona persona = new Persona();
			persona.setId(reclamoDTO.getPersona().getId());
			reclamo.setPersona(persona);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			SubTema subTema = new SubTema();
			subTema.setId(reclamoDTO.getSubtema().getId());
			reclamo.setSubtema(subTema);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Foto foto = new Foto();
			foto.setId(reclamoDTO.getFoto().getId());
			reclamo.setFoto(foto);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			Ubicacion ubicacion = new Ubicacion();
			ubicacion.setId(reclamoDTO.getUbicacion().getId());
			reclamo.setUbicacion(ubicacion);
		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		reclamoRepository.save(reclamo);
		
		reclamoDTO.setId(reclamo.getId());
		
		} catch(Exception e) {
	
			System.out.println("Bad Request");
			reclamoDTO.setId(0);
	
		}
	
		return reclamoDTO;
		
	}
	/**
	 * This method call the repository for delete an entity 'Reclamo' in the database for the id.
	 * @param id it is an id that match with the index of the entity in the DB.
	 * @return true in the case of being successful, or false in the opposite case.
	 * @since 1.0
	 */
	public boolean delete(int id) {
			
		try {
			
			reclamoRepository.deleteById(id);			
			
		} catch (Exception e) {
			
			return false;
			
		}		
		
		return true;
		
	}

}

