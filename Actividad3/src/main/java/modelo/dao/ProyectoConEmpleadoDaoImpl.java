package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.entities.Empleado;
import modelo.entities.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImpl {
    private EntityManager em;

    public List<Empleado> empleadosByProyecto(String codigoProyecto) {
        return em.createQuery("SELECT pe.empleado FROM ProyectoConEmpleado pe WHERE pe.proyecto.idProyecto = :id", Empleado.class)
                 .setParameter("id", codigoProyecto).getResultList();
    }

    public int horasAsignadasAProyecto(String codigoProyecto) {
        Long total = em.createQuery("SELECT SUM(pe.horasAsignadas) FROM ProyectoConEmpleado pe WHERE pe.proyecto.idProyecto = :id", Long.class)
                       .setParameter("id", codigoProyecto).getSingleResult();
        return total != null ? total.intValue() : 0;
    }

    public double costeActualDeEmpleadosEnProyecto(String codigoProyecto) {
        List<ProyectoConEmpleado> lista = em.createQuery("SELECT pe FROM ProyectoConEmpleado pe WHERE pe.proyecto.idProyecto = :id", ProyectoConEmpleado.class)
                                            .setParameter("id", codigoProyecto).getResultList();
        
        return lista.stream().mapToDouble(ProyectoConEmpleado::costeHorasAsignadas).sum();
    }
    
    public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> asignaciones) {
        try {
            em.getTransaction().begin();
            for (ProyectoConEmpleado pce : asignaciones) {
                em.persist(pce);
            }
            em.getTransaction().commit();
            return asignaciones.size();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return 0;
        }
    }
}
