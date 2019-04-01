package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class SubTemaDTO implements Serializable{
	
	private int id;
	
	private String nombre;
	
	private TemaDTO tema;
	
	//Constructor
	public SubTemaDTO() {
		
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
	
	
	public TemaDTO getTema(){
		return tema;
	}
	
	
	public void setTema(TemaDTO tema){
		this.tema = tema;
	}
	
	
	

}

