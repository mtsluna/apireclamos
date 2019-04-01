package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class UbicacionDTO implements Serializable{
	
	private int id;
	
	private String latitud;
	private String longitud;
	private String lugar;
	
	
	//Constructor
	public UbicacionDTO() {
		
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

