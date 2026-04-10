package modelo.entities;
import jakarta.persistence.*;
import java.util.List;



public class Departamentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_depar;
	
	private String nombre;
	private String direccion;
	
	@OneToMany(mappedBy = "departamentos")
    private List<Empleados> empleados;
	
	public Departamentos() {
		
	}
	
	public int getId_depar() {
		return id_depar;
	}
	public void setId_depar(int id_depar) {
		this.id_depar = id_depar;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
