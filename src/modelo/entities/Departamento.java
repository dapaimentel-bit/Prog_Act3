package modelo.entities;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "departamentos")
public class Departamento {
	
	@Id
	@Column(name = "id_depar")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepar;
	
	private String nombre;
	private String direccion;
	
	@OneToMany(mappedBy = "departamento")
    private List<Empleado> empleado;
	
	public Departamento() {
		
	}
	
	public int getId_depar() {
		return idDepar;
	}
	public void setId_depar(int id_depar) {
		this.idDepar = id_depar;
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
