package test.daos;

import java.util.List;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;
import modelo.entities.Empleado;

public class TestFindAllEmpleado {

    public static void main(String[] args) {

        EmpleadoDao dao = new EmpleadoDaoImpl();

        List<Empleado> empleados = dao.findAll();

        System.out.println("====================================");
        System.out.println("      LISTADO DE EMPLEADOS");
        System.out.println("====================================");

        for (Empleado e : empleados) {

            System.out.println("ID: " + e.getIdEmpleado());
            System.out.println("Nombre: " + e.nombreCompleto());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Genero: " + e.literalGenero());
            System.out.println("Salario: " + e.getSalario());

            
            if (e.getDepartamento() != null) {
                System.out.println("Departamento: " +
                    e.getDepartamento().getNombre());
            }

            if (e.getPerfil() != null) {
                System.out.println("Perfil: " +
                    e.getPerfil().getNombre());
            }

            System.out.println("------------------------------------");
        }

        System.out.println("Total empleados: " + empleados.size());
    }
}