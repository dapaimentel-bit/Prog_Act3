package modelo.entities;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import jakarta.persistence.*;


@Entity
@Table(name="PROYECTOS")
public class Proyecto {
	@Id
	@Column(name="ID_PROYECTO")
	private String idProyecto; 
	private String descripcion;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FIN_PREVISTO")
	private Date fechaFinPrevisto;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FIN_REAL")
	private Date fechaFinReal;
	@Column(name="VENTA_PREVISTO")
	private double ventaPrevisto;
	@Column(name="COSTES_PREVISTO")
	private double costesPrevisto;
	@Column(name="COSTE_REAL")
	private double costeReal;
	private String estado;
	@Column(name="JEFE_PROYECTO")
	private int jefeProyecto;
	private String cif;
	
	public double margenPrevisto() {
		return ventaPrevisto - costesPrevisto;
	}
	
	public double porcentajeMargenPrevisto() {
		return (margenPrevisto() / ventaPrevisto) * 100;
	}
	
	public double margenReal() {
		return ventaPrevisto - costeReal;
	}
	
	public double porcentajeMargenReal() {
		return (margenReal() / ventaPrevisto) * 100;
	}
	
	public double diferenciaGastos() {
		return costeReal - costesPrevisto;
	}
	
	public int diferenciaDiasFinPrevistoReal() {
	    if (this.fechaFinPrevisto == null || this.fechaFinReal == null) {
	        return 0; 
	    }
	    long diff = this.fechaFinReal.getTime() - this.fechaFinPrevisto.getTime();
	    return (int) (diff / (1000 * 60 * 60 * 24));
	}

	public Proyecto(String idProyecto, String descripcion, Date fechaInicio, Date fechaFinPrevisto,
			Date fechaFinReal, double ventaPrevisto, double costesPrevisto, double costeReal, String estado,
			int jefeProyecto, String cif) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventaPrevisto = ventaPrevisto;
		this.costesPrevisto = costesPrevisto;
		this.costeReal = costeReal;
		this.estado = estado;
		this.jefeProyecto = jefeProyecto;
		this.cif = cif;
	}

	public Proyecto() {
		super();
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public Date getFechaFinReal() {
		return fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public double getVentaPrevisto() {
		return ventaPrevisto;
	}

	public void setVentaPrevisto(double ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}

	public double getCostesPrevisto() {
		return costesPrevisto;
	}

	public void setCostesPrevisto(double costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public double getCosteReal() {
		return costeReal;
	}

	public void setCosteReal(double costeReal) {
		this.costeReal = costeReal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getJefeProyecto() {
		return jefeProyecto;
	}

	public void setJefeProyecto(int jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProyecto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Proyecto))
			return false;
		Proyecto other = (Proyecto) obj;
		return idProyecto == other.idProyecto;
	}

	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventaPrevisto="
				+ ventaPrevisto + ", costesPrevisto=" + costesPrevisto + ", costeReal=" + costeReal + ", estado="
				+ estado + ", jefeProyecto=" + jefeProyecto + ", cif=" + cif + "]";
	}
	
	

}

