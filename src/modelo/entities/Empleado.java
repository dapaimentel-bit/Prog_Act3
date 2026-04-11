package modelo.entities;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado { //*Declaramos los atributos referentes a empleado//*
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_empl;
	
	private String nombre;
	private String apellidos;
	private char genero;
	private String email;
	private String password;
	private double salario;
	
	@Temporal(TemporalType.DATE)
	private LocalDate fecha_Nacimiento;
	
	@Temporal(TemporalType.DATE)
	private LocalDate fecha_Ingreso;
	
	@ManyToOne
	@JoinColumn(name = "id_depar")
	private Departamento departamento;
	
	@ManyToOne
    @JoinColumn(name = "id_perfil")
	private Perfil perfil;
	
	//*Generamos el constructor vacío //*
	
	public Empleado () {
		
	}
	
	//* Todos los getters/setters//*

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

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
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

	public LocalDate getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(LocalDate fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public LocalDate getFecha_Ingreso() {
		return fecha_Ingreso;
	}

	public void setFecha_Ingreso(LocalDate fecha_Ingreso) {
		this.fecha_Ingreso = fecha_Ingreso;
	}

	public Departamento getDepartamentos() {
		return departamento;
	}

	public void setDepartamentos(Departamento departamento) {
		this.departamento = departamento;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	//* Los 3 metodos a implementar//*
	
	public double salarioMensual(int meses) {
		return salario * meses;
		
	}
	
	public String literalGenero() {
		return genero == 'H' ? "Hombre" : "Mujer";
	}
	
	 public String nombreCompleto() {
	        return nombre + " " + apellidos;
	    }


}
