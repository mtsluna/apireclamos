package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_persona")
public class Persona{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "persona_id")
	private int id;
	
	@Column(name = "persona_numero_documento")
	private String numero_documento;
	@Column(name = "persona_nombre")
	private String nombre;
	@Column(name = "persona_apellido")
	private String apellido;
	@Column(name = "persona_email")
	private String email;
	@Column(name = "persona_tipo_documento")
	private String tipo_documento;
	
	@OneToOne
	@JoinColumn(name = "fk_direccion")
	private Direccion direccion;
	
	//Constructor
	public Persona() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setNumero_documento(String numero_documento){
		this.numero_documento = numero_documento;
	}
	
	public String getNumero_documento(){
		return numero_documento;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	
	public String getApellido(){
		return apellido;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setTipo_documento(String tipo_documento){
		this.tipo_documento = tipo_documento;
	}
	
	public String getTipo_documento(){
		return tipo_documento;
	}
	
	
	public Direccion getDireccion(){
		return direccion;
	}
	
	
	public void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}
	
	
	
	
	

}

