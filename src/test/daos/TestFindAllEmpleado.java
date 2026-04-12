package test.daos;

import java.util.List;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;
import modelo.entities.Empleado;

public class TestFindAllEmpleado {

    public static void main(String[] args) {

        EmpleadoDao dao = new EmpleadoDaoImpl();

        List<Empleado> lista = dao.findAll();

        System.out.println("=== LISTA DE EMPLEADOS ===");

        for (Empleado e : lista) {
            System.out.println(
                e.getIdEmpleado() + " - " +
                e.nombreCompleto() + " - " +
                e.getDepartamento().getNombre() + " - " +
                e.getPerfil().getNombre()
            );
        }
    }
}