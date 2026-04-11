package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import modelo.entities.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {

    private EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("proyectos_FP_2025");

    // ---------------- CRUD ----------------

    @Override
    public void save(Empleado empleado) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void update(Empleado empleado) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(empleado);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void delete(int idEmpleado) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Empleado e = em.find(Empleado.class, idEmpleado);
        if (e != null) {
            em.remove(e);
        }

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Empleado findById(int idEmpleado) {
        EntityManager em = emf.createEntityManager();

        Empleado e = em.find(Empleado.class, idEmpleado);

        em.close();
        return e;
    }

    @Override
    public List<Empleado> findAll() {
        EntityManager em = emf.createEntityManager();

        List<Empleado> lista = em.createQuery(
            "SELECT e FROM Empleado e", Empleado.class)
            .getResultList();

        em.close();
        return lista;
    }

    // ---------------- CONSULTAS ----------------

    @Override
    public List<Empleado> empleadosByDepartamento(int idDepar) {
        EntityManager em = emf.createEntityManager();

        List<Empleado> lista = em.createQuery(
            "SELECT e FROM Empleado e WHERE e.departamento.idDepartamento = :id",
            Empleado.class)
            .setParameter("id", idDepar)
            .getResultList();

        em.close();
        return lista;
    }

    @Override
    public List<Empleado> empleadosByGenero(char sexo) {
        EntityManager em = emf.createEntityManager();

        List<Empleado> lista = em.createQuery(
            "SELECT e FROM Empleado e WHERE e.genero = :sexo",
            Empleado.class)
            .setParameter("sexo", sexo)
            .getResultList();

        em.close();
        return lista;
    }

    @Override
    public List<Empleado> empleadosByApellido(String subcadena) {
        EntityManager em = emf.createEntityManager();

        List<Empleado> lista = em.createQuery(
            "SELECT e FROM Empleado e WHERE e.apellidos LIKE :txt",
            Empleado.class)
            .setParameter("txt", "%" + subcadena + "%")
            .getResultList();

        em.close();
        return lista;
    }

    @Override
    public double salarioTotal() {
        EntityManager em = emf.createEntityManager();

        Double total = em.createQuery(
            "SELECT SUM(e.salario) FROM Empleado e",
            Double.class)
            .getSingleResult();

        em.close();
        return total != null ? total : 0;
    }

    @Override
    public double salarioTotal(int idDepar) {
        EntityManager em = emf.createEntityManager();

        Double total = em.createQuery(
            "SELECT SUM(e.salario) FROM Empleado e WHERE e.departamento.idDepartamento = :id",
            Double.class)
            .setParameter("id", idDepar)
            .getSingleResult();

        em.close();
        return total != null ? total : 0;
    }
}