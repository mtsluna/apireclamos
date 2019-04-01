package api.main.dtos;

import java.io.Serializable;

public class GeneralDTO implements Serializable {

	//Direccion	
	private DireccionDTO direccionDTO;
	
	//Persona	
	private PersonaDTO personaDTO;
	
	//Foto	
	private FotoDTO fotoDTO;
	
	//Subtema
	private SubTemaDTO subTemaDTO;
	
	//Reclamo
	private ReclamoDTO reclamoDTO;
	
	//Ubicacion
	private UbicacionDTO ubicacionDTO;
	
	public GeneralDTO() {
		
	}		

	public UbicacionDTO getUbicacionDTO() {
		return ubicacionDTO;
	}

	public void setUbicacionDTO(UbicacionDTO ubicacionDTO) {
		this.ubicacionDTO = ubicacionDTO;
	}

	public DireccionDTO getDireccionDTO() {
		return direccionDTO;
	}

	public void setDireccionDTO(DireccionDTO direccionDTO) {
		this.direccionDTO = direccionDTO;
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public FotoDTO getFotoDTO() {
		return fotoDTO;
	}

	public void setFotoDTO(FotoDTO fotoDTO) {
		this.fotoDTO = fotoDTO;
	}

	public SubTemaDTO getSubTemaDTO() {
		return subTemaDTO;
	}

	public void setSubTemaDTO(SubTemaDTO subTemaDTO) {
		this.subTemaDTO = subTemaDTO;
	}

	public ReclamoDTO getReclamoDTO() {
		return reclamoDTO;
	}

	public void setReclamoDTO(ReclamoDTO reclamoDTO) {
		this.reclamoDTO = reclamoDTO;
	}
		
}
