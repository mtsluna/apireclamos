package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class DireccionDTO implements Serializable{
	
	private int id;
	
	private String calle;
	private int numero;
	private String departamento;
	private String piso;
	
	private LocalidadDTO localidad;
	
	//Constructor
	public DireccionDTO() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setCalle(String calle){
		this.calle = calle;
	}
	
	public String getCalle(){
		return calle;
	}
	
	public void setNumero(int numero){
		this.numero = numero;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public void setDepartamento(String departamento){
		this.departamento = departamento;
	}
	
	public String getDepartamento(){
		return departamento;
	}
	
	public void setPiso(String piso){
		this.piso = piso;
	}
	
	public String getPiso(){
		return piso;
	}
	
	
	public LocalidadDTO getLocalidad(){
		return localidad;
	}
	
	
	public void setLocalidad(LocalidadDTO localidad){
		this.localidad = localidad;
	}
	
	
	

}

