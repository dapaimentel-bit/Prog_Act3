package test.daos;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;
import modelo.entities.Empleado;


public class TestUpdateEmpleado {
	
	public static void main(String[] args) {

        EmpleadoDao dao = new EmpleadoDaoImpl();

        
        Empleado e = dao.findById(121);

        if (e != null) {
            
            e.setSalario(e.getSalario() + 500);
            e.setEmail("update@test.com");

            
            dao.update(e);

            System.out.println("Empleado actualizado");
        } else {
            System.out.println("No existe");
        }
    }

}
