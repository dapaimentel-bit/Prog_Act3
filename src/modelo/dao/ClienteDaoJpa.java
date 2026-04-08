package modelo.dao;

import java.util.List;
import javax.persistence.*;
import modelo.entities.Cliente;

public class ClienteDaoJpa implements ClienteDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");

    @Override
    public int insert(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            return 0;
        } finally { em.close(); }
    }

    @Override
    public Cliente findById(String cif) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, cif);
        em.close();
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public int delete(String cif) {
        EntityManager em = emf.createEntityManager();
        Cliente c = em.find(Cliente.class, cif);
        if (c != null) {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            em.close();
            return 1;
        }
        return 0;
    }
}package modelo.dao;

import java.util.List;
import javax.persistence.*;
import modelo.entities.Cliente;

public class ClienteDaoImplMy8Jpa implements ClienteDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");

    @Override
    public int insert(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            return 0;
        } finally { em.close(); }
    }

    @Override
    public Cliente findById(String cif) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, cif);
        em.close();
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public int delete(String cif) {
        EntityManager em = emf.createEntityManager();
        Cliente c = em.find(Cliente.class, cif);
        if (c != null) {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            em.close();
            return 1;
        }
        return 0;
    }
}