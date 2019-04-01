package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_tema")
public class Tema{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "tema_id")
	private int id;
	
	@Column(name = "tema_nombre")
	private String nombre;
	
	
	//Constructor
	public Tema() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	
	
	
	
	
	

}

