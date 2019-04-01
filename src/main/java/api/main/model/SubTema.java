package api.main.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "api_subtema")
public class SubTema{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "subtema_id")
	private int id;
	
	@Column(name = "subtema_nombre")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "fk_tema")
	private Tema tema;
	
	//Constructor
	public SubTema() {
		
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
	
	
	public Tema getTema(){
		return tema;
	}
	
	
	public void setTema(Tema tema){
		this.tema = tema;
	}
	
	
	
	
	

}

