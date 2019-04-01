package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class PersonaDTO implements Serializable{
	
	private int id;
	
	private String numero_documento;
	private String nombre;
	private String apellido;
	private String email;
	private String tipo_documento;
	
	private DireccionDTO direccion;
	
	//Constructor
	public PersonaDTO() {
		
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
	
	
	public DireccionDTO getDireccion(){
		return direccion;
	}
	
	
	public void setDireccion(DireccionDTO direccion){
		this.direccion = direccion;
	}
	
	
	

}

