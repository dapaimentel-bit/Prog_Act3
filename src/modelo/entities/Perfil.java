package modelo.entities;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "perfiles")

public class Perfil {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	
	private String nombre;
	private BigDecimal tasa_standard;
	
	@OneToMany(mappedBy = "perfiles")
    private List<Empleado> empleado;
	
	public Perfil() {
		
	}

	public int getId_perfil() {
		return idPerfil;
	}

	public void setId_perfil(int id_perfil) {
		this.idPerfil = id_perfil;
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
