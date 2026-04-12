package test.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;
import modelo.entities.*;

public class TestInsertEmpleadoDao {

    public static void main(String[] args) {

        
        EmpleadoDao dao = new EmpleadoDaoImpl();

        
        EntityManager em = Persistence
                .createEntityManagerFactory("proyectos_fp_2025")
                .createEntityManager();

        
        Departamento d = em.find(Departamento.class, 10);
        Perfil p = em.find(Perfil.class, 1);

        
        Empleado e = new Empleado();
        e.setNombre("Juan");
        e.setApellidos("Pérez");
        e.setGenero('H');
        e.setEmail("juan@test.com");
        e.setPassword("1234");
        e.setSalario(1500);

        e.setDepartamento(d);
        e.setPerfil(p);

       
        dao.save(e);

        System.out.println("Empleado insertado correctamente");

        em.close();
    }
}