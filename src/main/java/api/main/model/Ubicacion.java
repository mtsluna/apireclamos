package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_ubicacion")
public class Ubicacion{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "ubicacion_id")
	private int id;
	
	@Column(name = "ubicacion_latitud")
	private String latitud;
	@Column(name = "ubicacion_longitud")
	private String longitud;
	@Column(name = "ubicacion_lugar")
	private String lugar;
	
	
	//Constructor
	public Ubicacion() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setLatitud(String latitud){
		this.latitud = latitud;
	}
	
	public String getLatitud(){
		return latitud;
	}
	
	public void setLongitud(String longitud){
		this.longitud = longitud;
	}
	
	public String getLongitud(){
		return longitud;
	}
	
	public void setLugar(String lugar){
		this.lugar = lugar;
	}
	
	public String getLugar(){
		return lugar;
	}
	
	
	
	
	
	
	

}

