package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_direccion")
public class Direccion{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "direccion_id")
	private int id;
	
	@Column(name = "direccion_calle")
	private String calle;
	@Column(name = "direccion_numero")
	private int numero;
	@Column(name = "direccion_departamento")
	private String departamento;
	@Column(name = "direccion_piso")
	private String piso;
	
	@OneToOne
	@JoinColumn(name = "fk_direccion_localidad")
	private Localidad localidad;
	
	//Constructor
	public Direccion() {
		
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
	
	
	public Localidad getLocalidad(){
		return localidad;
	}
	
	
	public void setLocalidad(Localidad localidad){
		this.localidad = localidad;
	}
	
	
	
	
	

}

