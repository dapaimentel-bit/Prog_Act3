package modelo.dao;

import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.entities.Proyecto;

public class ProyectoDaoImpl {
    private EntityManager em;
    
    public ProyectoDaoImpl(EntityManager em) {
        this.em = em;
    }

    public List<Proyecto> proyectosByEstado(String estado) {
        return em.createQuery("SELECT p FROM Proyecto p WHERE p.estado = :est", Proyecto.class)
                 .setParameter("est", estado).getResultList();
    }

    public List<Proyecto> proyectosByCliente(String cif) {
        return em.createQuery("SELECT p FROM Proyecto p WHERE p.cliente.cif = :cif", Proyecto.class)
                 .setParameter("cif", cif).getResultList();
    }

    public List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto, String estado) {
        return em.createQuery("SELECT p FROM Proyecto p WHERE p.jefeProyecto = :jefe AND p.estado = :est", Proyecto.class)
                 .setParameter("jefe", jefeProyecto)
                 .setParameter("est", estado).getResultList();
    }

    public double importesVentaProyectosTerminados() {
        return em.createQuery("SELECT SUM(p.ventaPrevista) FROM Proyecto p WHERE p.estado = 'Terminado'", Double.class)
                 .getSingleResult();
    }

    public double margenBrutoProyectosTerminados() {
        Double venta = importesVentaProyectosTerminados();
        Double gastos = em.createQuery("SELECT SUM(p.costeReal) FROM Proyecto p WHERE p.estado = 'Terminado'", Double.class)
                          .getSingleResult();
        return (venta != null ? venta : 0) - (gastos != null ? gastos : 0);
    }

    public int diasATerminoProyectoActivo(String codigoProyecto) {
        Proyecto p = em.find(Proyecto.class, codigoProyecto);
        if (p == null || p.getFechaFinPrevisto() == null) return 0;
        long diff = p.getFechaFinPrevisto().getTime() - new Date().getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
    }
    
}