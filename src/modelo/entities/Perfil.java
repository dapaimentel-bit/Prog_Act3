package modelo.entities;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "perfiles")

public class Perfil {
	
	@Id
	@Column(name = "id_perfil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPerfil;
	
	
	private String nombre;
	@Column(name = "tasa_standard")
	private BigDecimal tasaStandard;
	
	@OneToMany(mappedBy = "perfil")
    private List<Empleado> empleado;
	
	public Perfil() {
		
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int id_perfil) {
		this.idPerfil = id_perfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getTasastandard() {
		return tasaStandard;
	}

	public void setTasa_standard(BigDecimal tasaStandard) {
		this.tasaStandard = tasaStandard;
	}
	
	
	
	

}
