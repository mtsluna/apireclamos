package api.main.controllers;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.main.dtos.DireccionDTO;
import api.main.dtos.FotoDTO;
import api.main.dtos.GeneralDTO;
import api.main.dtos.PersonaDTO;
import api.main.dtos.ReclamoDTO;
import api.main.dtos.SubTemaDTO;
import api.main.dtos.UbicacionDTO;
import api.main.exceptions.StatusException;
import api.main.services.DireccionService;
import api.main.services.FotoService;
import api.main.services.PersonaService;
import api.main.services.ReclamoService;
import api.main.services.SubTemaService;
import api.main.services.UbicacionService;

@Controller
@RestController
@RequestMapping(path = "api/v1/general")
public class GeneralController {

	private PersonaService personaService;
	private DireccionService direccionService;
	private FotoService fotoService;
	private SubTemaService subTemaService;
	private ReclamoService reclamoService;
	private UbicacionService ubicacionService;

	public GeneralController(DireccionService direccionService, PersonaService personaService, FotoService fotoService,
			SubTemaService subTemaService, ReclamoService reclamoService, UbicacionService ubicacionService) {
		this.direccionService = direccionService;
		this.personaService = personaService;
		this.fotoService = fotoService;
		this.subTemaService = subTemaService;
		this.reclamoService = reclamoService;
		this.ubicacionService = ubicacionService;
	}

	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity save(@RequestBody GeneralDTO t) {

		int idReclamo = 0;

		try {

			FotoDTO fotoDTO = t.getFotoDTO();
			fotoDTO = fotoService.save(fotoDTO);
			
			UbicacionDTO ubicacionDTO = t.getUbicacionDTO();
			ubicacionDTO = ubicacionService.save(ubicacionDTO);
			
			DireccionDTO direccionDTO = t.getDireccionDTO();
			direccionDTO = direccionService.save(direccionDTO);
			PersonaDTO personaDTO = t.getPersonaDTO();
			personaDTO.setDireccion(direccionDTO);
			personaDTO = personaService.save(personaDTO);
			
			SubTemaDTO subtemaDTO = t.getSubTemaDTO();
			
			ReclamoDTO reclamoDTO = t.getReclamoDTO();
			reclamoDTO.setFecha(new Date());
			reclamoDTO.setFoto(fotoDTO);
			reclamoDTO.setPersona(personaDTO);
			reclamoDTO.setSubtema(subtemaDTO);
			reclamoDTO.setUbicacion(ubicacionDTO);
			reclamoDTO = reclamoService.save(reclamoDTO);
			idReclamo = reclamoDTO.getId();

		} catch (Exception e) {

		}
		
		try {
			
			return ResponseEntity.status(201).body("{ \"idReclamo\": \"nº reclamo: "+idReclamo+"\" }");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(201).body("{ idReclamo: Fallido. Vuelva a intentar más tarde }");
			
		}

	}

}
