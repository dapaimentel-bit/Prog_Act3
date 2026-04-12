package test.daos;

import java.util.Date;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;
import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class TestEmpleadoDao {

    public static void main(String[] args) {

        EmpleadoDao dao = new EmpleadoDaoImpl();

       
        // 1. CREATE (INSERTAR)
       
        Empleado e = new Empleado();
        e.setNombre("Juan");
        e.setApellidos("Pérez");
        e.setEmail("juan@test.com");
        e.setPassword("1234");
        e.setGenero('H');
        e.setSalario(1500);
        e.setFechaNacimiento(new Date());
        e.setFechaIngreso(new Date());

        
        Departamento d = new Departamento();
        d.setIdDepar(10);
        e.setDepartamento(d);

        Perfil p = new Perfil();
        p.setIdPerfil(1);
        e.setPerfil(p);

        dao.save(e);

        System.out.println("EMPLEADO CREADO");
        System.out.println("ID generado: " + e.getIdEmpleado());
        System.out.println("-----------------------------------");


        
        // 2. READ (FIND BY ID)
        
        Empleado encontrado = dao.findById(e.getIdEmpleado());
        Empleado carlos = dao.findById(115);

        if (encontrado != null) {
            System.out.println("EMPLEADO ENCONTRADO:");
            System.out.println(encontrado.getIdEmpleado() + " - "
                    + encontrado.getNombre() + " - "
                    + encontrado.getSalario());
        } else {
            System.out.println("Empleado no encontrado");
        }

        System.out.println("-----------------------------------");


        
        // 3. UPDATE (MODIFICAR)
        
        encontrado.setSalario(2000);
        encontrado.setEmail("nuevo@email.com");
        carlos.setSalario(35000);

        dao.update(encontrado);
        

        System.out.println("EMPLEADO ACTUALIZADO");
        System.out.println("-----------------------------------");


        
        // 4. FIND ALL (LISTAR)
        
        System.out.println("LISTADO DE EMPLEADOS:");

        for (Empleado emp : dao.findAll()) {
            System.out.println(
                    emp.getIdEmpleado() + " | " +
                    emp.getNombre() + " | " +
                    emp.getSalario() + " € | " +
                    emp.literalGenero()
            );
        }

        System.out.println("-----------------------------------");


        
        // 5. DELETE (BORRAR)
        
        dao.delete(e.getIdEmpleado());

        System.out.println("EMPLEADO ELIMINADO");

        System.out.println("-----------------------------------");


        
        // 6. VERIFICAR BORRADO
        
        Empleado eliminado = dao.findById(e.getIdEmpleado());

        if (eliminado == null) {
            System.out.println("Confirmado: el empleado ya no existe");
        } else {
            System.out.println("Sigue existiendo en BD");
        }
    }
}