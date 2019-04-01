package api.main.dtos;
import java.io.Serializable;
import java.util.*;

public class FotoDTO implements Serializable{
	
	private int id;
	
	public String source;
	
	
	//Constructor
	public FotoDTO() {
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setSource(String source){
		this.source = source;
	}
	
	public String getSource(){
		return source;
	}
	
	
	
	
	

}

