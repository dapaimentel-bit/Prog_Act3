package modelo.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="PERFILES")
public class Perfil {
	@Id
	@Column(name="ID_PERFIL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idPerfil;
	 private String nombre;
	 @Column(name="TASA_STANDAR")
	 private double tasaStandard;
	 
	 
	public Perfil(int idPerfil, String nombre, double tasaStandard) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.tasaStandard = tasaStandard;
	}


	public Perfil() {
		super();
	}


	public int getIdPerfil() {
		return idPerfil;
	}


	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getTasaStandard() {
		return tasaStandard;
	}


	public void setTasaStandard(double tasaStandard) {
		this.tasaStandard = tasaStandard;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idPerfil);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Perfil))
			return false;
		Perfil other = (Perfil) obj;
		return idPerfil == other.idPerfil;
	}


	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", nombre=" + nombre + ", tasaStandard=" + tasaStandard + "]";
	}
	 
	 

}
