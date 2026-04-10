package modelo.entities;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "perfiles")

public class Perfiles {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_perfil;
	
	
	private String nombre;
	private BigDecimal tasa_standard;
	
	@OneToMany(mappedBy = "perfiles")
    private List<Empleados> empleados;
	
	public Perfiles() {
		
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getTasa_standard() {
		return tasa_standard;
	}

	public void setTasa_standard(BigDecimal tasa_standard) {
		this.tasa_standard = tasa_standard;
	}
	
	
	
	

}
