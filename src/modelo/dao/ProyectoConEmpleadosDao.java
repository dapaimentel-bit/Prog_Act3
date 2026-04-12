package modelo.dao;
import java.util.List;
import modelo.entities.*;

public interface ProyectoConEmpleadosDao {
	
	List<Empleado>empleadosByProyecto(String codigoProyecto);
	List<ProyectoConEmpleados>asignarEmpleadosAProyecto(int empleados);
	public int horasAsignadasAProyecto(String codigoProyecto);
	public double costeActualDeEmpleadosEnProyecto(String codigoProyecto);

}
