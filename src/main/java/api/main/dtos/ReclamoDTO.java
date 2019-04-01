package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class ReclamoDTO implements Serializable{
	
	private int id;
	
	private String descripcion;
	private Date fecha;
	
	private PersonaDTO persona;
	private SubTemaDTO subtema;
	private FotoDTO foto;
	private UbicacionDTO ubicacion;
	
	//Constructor
	public ReclamoDTO() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setFecha(Date fecha){
		this.fecha = fecha;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	
	public PersonaDTO getPersona(){
		return persona;
	}
	
	public SubTemaDTO getSubtema(){
		return subtema;
	}
	
	public FotoDTO getFoto(){
		return foto;
	}
	
	public UbicacionDTO getUbicacion(){
		return ubicacion;
	}	
	
	public void setPersona(PersonaDTO persona){
		this.persona = persona;
	}
	
	public void setSubtema(SubTemaDTO subtema){
		this.subtema = subtema;
	}
	
	public void setFoto(FotoDTO foto){
		this.foto = foto;
	}
	
	public void setUbicacion(UbicacionDTO ubicacion){
		this.ubicacion = ubicacion;
	}	
	

}

