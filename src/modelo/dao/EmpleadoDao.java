package modelo.dao;
import modelo.entities.*;
import java.util.List;

public interface EmpleadoDao {
	
	List<Empleado> empleadosByDepartamento (int id_depar);
	List<Empleado> empleadosByGenero (char sexo);
	List<Empleado> empleadosByApellido (String subcadena);
	public double salarioTotal();
	public double salarioTotal(int id_depar);
	

}
