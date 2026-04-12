package test.daos;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;

public class TestDeleteEmpleado {

	 public static void main(String[] args) {

	        EmpleadoDao dao = new EmpleadoDaoImpl();

	        int id = 1;

	        dao.delete(id);

	        System.out.println("Empleado eliminado si existía");
	    }
}
