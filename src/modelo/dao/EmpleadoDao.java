package modelo.dao;
import modelo.entities.*;
import java.util.List;

public interface EmpleadoDao {
	
	List<Empleado> empleadosByDepartamento (int id_depar);
	List<Empleado> empleadosByGenero (char sexo);
	List<Empleado> empleadosByApellido (String subcadena);
	public double salarioTotal();
	public double salarioTotal(int idDepar);
	List<Empleado> findAll();
	Empleado findById(int idEmpleado);
	void save(Empleado e);
	void update(Empleado e);
	void delete(int idEmpleado);
	

}
