package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_foto")
public class Foto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "foto_id")
	private int id;
	
	@Column(name = "foto_source")
	public String source;
	
	
	//Constructor
	public Foto() {
		
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

