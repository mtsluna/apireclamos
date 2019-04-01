package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_reclamo")
public class Reclamo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "reclamo_id")
	private int id;
	
	@Column(name = "reclamo_descripcion")
	private String descripcion;
	@Column(name = "reclamo_fecha")
	private Date fecha;
	
	@OneToOne
	@JoinColumn(name = "fk_persona")
	private Persona persona;
	@OneToOne
	@JoinColumn(name = "fk_subtema_reclamo")
	private SubTema subtema;
	@OneToOne
	@JoinColumn(name = "fk_foto")
	private Foto foto;
	@OneToOne
	@JoinColumn(name = "fk_reclamo_ubicacion")
	private Ubicacion ubicacion;
	
	//Constructor
	public Reclamo() {
		
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
	
	
	public Persona getPersona(){
		return persona;
	}
	
	public SubTema getSubtema(){
		return subtema;
	}
	
	public Foto getFoto(){
		return foto;
	}
	
	public Ubicacion getUbicacion(){
		return ubicacion;
	}	
	
	public void setPersona(Persona persona){
		this.persona = persona;
	}
	
	public void setSubtema(SubTema subtema){
		this.subtema = subtema;
	}
	
	public void setFoto(Foto foto){
		this.foto = foto;
	}
	
	public void setUbicacion(Ubicacion ubicacion){
		this.ubicacion = ubicacion;
	}

}

