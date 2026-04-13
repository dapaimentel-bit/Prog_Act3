package modelo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import modelo.entities.ProyectoConProducto;
import java.math.BigDecimal;
import java.util.List;

public class ProyectoConProductoDaoJpa implements ProyectoConProductoDao {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
    
    public ProyectoConProducto findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(ProyectoConProducto.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<ProyectoConProducto> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT pcp FROM ProyectoConProducto pcp", ProyectoConProducto.class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public int insert(ProyectoConProducto entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        } finally {
            em.close();
        }
    }
    
    public int update(ProyectoConProducto entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        } finally {
            em.close();
        }
    }
    
    public int delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            ProyectoConProducto pcp = em.find(ProyectoConProducto.class, id);
            if (pcp != null) {
                em.getTransaction().begin();
                em.remove(pcp);
                em.getTransaction().commit();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<ProyectoConProducto> findByProyecto(String idProyecto) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<ProyectoConProducto> query = em.createQuery(
                "SELECT pcp FROM ProyectoConProducto pcp " +
                "JOIN FETCH pcp.producto prod " +
                "JOIN FETCH prod.familia " +
                "WHERE pcp.proyecto.idProyecto = :idProyecto", 
                ProyectoConProducto.class);
            query.setParameter("idProyecto", idProyecto);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    @Override
    public BigDecimal getTotalProductosByProyecto(String idProyecto) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<BigDecimal> query = em.createQuery(
                "SELECT SUM(pcp.precioAsignado * COALESCE(pcp.cantidad, 1)) " +
                "FROM ProyectoConProducto pcp " +
                "WHERE pcp.proyecto.idProyecto = :idProyecto", 
                BigDecimal.class);
            query.setParameter("idProyecto", idProyecto);
            BigDecimal result = query.getSingleResult();
            return result != null ? result : BigDecimal.ZERO;
        } finally {
            em.close();
        }
    }
    
    @Override
    public int updateCantidad(Integer numOrden, Integer cantidad) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ProyectoConProducto pcp = em.find(ProyectoConProducto.class, numOrden);
            if (pcp != null && cantidad != null && cantidad > 0) {
                pcp.setCantidad(cantidad);
                em.merge(pcp);
                em.getTransaction().commit();
                return 1;
            }
            em.getTransaction().rollback();
            return 0;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        } finally {
            em.close();
        }
    }
}