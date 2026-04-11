package modelo.dao;

import java.util.List;
import jakarta.persistence.*;
import modelo.entities.Cliente;

public class ClienteDaoJpa implements ClienteDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ClienteDaoJpa() {
        this.emf = Persistence.createEntityManagerFactory("proyectos_FP_2025");
        this.em = emf.createEntityManager();
    }

    @Override
    public int insert(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Cliente findById(String cif) {
        return em.find(Cliente.class, cif);
    }

    @Override
    public List<Cliente> findAll() {
        return em.createQuery("select c from Cliente c", Cliente.class)
                 .getResultList();
    }

    @Override
    public int delete(String cif) {
        try {
            Cliente cliente = findById(cif);
            if (cliente != null) {
                em.getTransaction().begin();
                em.remove(cliente);
                em.getTransaction().commit();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return 0;
        }
    }
}