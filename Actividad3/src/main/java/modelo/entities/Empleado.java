package modelo.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADOS")
public class Empleado {
	@Id
	@Column(name="ID_EMPL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_empl;
	private String nombre;
	private String apellidos;
	private String genero;
	private String email;
	private String password;
	private double salario;
	@Column(name="FECHA_INGRESO")
	private LocalDate fechaIngreso;
	@Column(name="FECHA_NACIMIENTNO")
	private LocalDate fechaNacimiento;
	@ManyToOne
    @JoinColumn(name="id_perfil")
    private Perfil perfil;
	@ManyToOne
    @JoinColumn(name="id_depar")
    private Departamento depar;
	

	public int getId_empl() {
		return id_empl;
	}

	public void setId_empl(int id_empl) {
		this.id_empl = id_empl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Departamento getDepar() {
		return depar;
	}

	public void setDepar(Departamento depar) {
		this.depar = depar;
	}
	
}
