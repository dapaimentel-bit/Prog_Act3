package modelo.dao;
import java.util.Date;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entities.Proyecto;

public class ProyectoDaoImpl implements ProyectoDao{
	private EntityManager em;
	private EntityManagerFactory emf;

	
	public ProyectoDaoImpl() {
		this.emf = Persistence.createEntityManagerFactory("proyectos_fp_2025");;
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		EntityManager em = emf.createEntityManager();
		List<Proyecto> lista = em.createQuery("SELECT p FROM Proyecto p WHERE p.estado = :est", Proyecto.class)
                .setParameter("est", estado).getResultList();
		return lista;
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		return em.createQuery("SELECT p FROM Proyecto p WHERE p.cif = :cif", Proyecto.class)
                .setParameter("cif", cif).getResultList();
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto, String estado) {
		 return em.createQuery("SELECT p FROM Proyecto p WHERE p.jefeProyecto = :jefe AND p.estado = :est", Proyecto.class)
                 .setParameter("jefe", jefeProyecto)
                 .setParameter("est", estado).getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		return em.createQuery("SELECT SUM(p.ventaPrevista) FROM Proyecto p WHERE p.estado = 'Terminado'", Double.class)
                .getSingleResult();
	}
	
	@Override
	public double margenBrutoProyectosTerminados() {
		Double venta = importesVentaProyectosTerminados();
        Double gastos = em.createQuery("SELECT SUM(p.costeReal) FROM Proyecto p WHERE p.estado = 'Terminado'", Double.class)
                          .getSingleResult();
        return (venta != null ? venta : 0) - (gastos != null ? gastos : 0);
	}

	@Override
	public double porcentajeMargenBrutoProyectosTerminados() {
		double venta = importesVentaProyectosTerminados();
		double margenBruto = margenBrutoProyectosTerminados();
		if(venta == 0) {
			return 0.0;
		}
		return (margenBruto / venta) * 100;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		Proyecto p = em.find(Proyecto.class, codigoProyecto);
        if (p == null || p.getFechaFinPrevisto() == null) return 0;
        long diff = p.getFechaFinPrevisto().getTime() - new Date().getTime();
        return (int) (diff / (1000 * 60 * 60 * 24));
		
	}

	@Override
	public void save(Proyecto newProyect) {
		EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(newProyect);
        em.getTransaction().commit();

        em.close();
	}

	@Override
	public void update(Proyecto newProyect) {
		EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(newProyect);
        em.getTransaction().commit();

        em.close();
	}

	@Override
	public void delete(String idProyect) {
		EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Proyecto e = em.find(Proyecto.class, idProyect);
        if (e != null) {
            em.remove(e);
        }
        em.getTransaction().commit();

        em.close();
	}

	@Override
	public Proyecto finById(String idProyecto) {
		EntityManager em = emf.createEntityManager();
		Proyecto newProyect = em.find(Proyecto.class, idProyecto);
		em.close();
		return newProyect;
	}

	@Override
	public List<Proyecto> finAll() {
		EntityManager em = emf.createEntityManager();
		List<Proyecto> lista = em.createQuery("SELECT p FROM Proyecto p", Proyecto.class).getResultList();
		em.close();
		return lista;
	}

	
  
}
