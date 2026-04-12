package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.entities.Departamento;

public class DepartamentoDaoImpl implements DepartamentoDao {

    private EntityManager em;

    public DepartamentoDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Departamento findById(int id) {
        return em.find(Departamento.class, id);
    }

    @Override
    public List<Departamento> findAll() {
        return em.createQuery("SELECT d FROM Departamento d", Departamento.class)
                 .getResultList();
    }

    @Override
    public void save(Departamento d) {
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Departamento d = em.find(Departamento.class, id);
        if (d != null) em.remove(d);
        em.getTransaction().commit();
    }
}
