package modelo.entities;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;


@Entity
@Table(name="proyecto_con_empleados")
public class ProyectoConEmpleados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="numero_orden")
    private int numeroOrden;

    @ManyToOne
    @JoinColumn(name="id_proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name="id_empl")
    private Empleado empleado;

    @Column(name="horas_asignadas")
    private int horasAsignadas;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_incorporacion")
    private Date fechaIncorporacion;

    public double costeHorasAsignadas() {
        if (empleado == null || empleado.getPerfil() == null) {
            return 0;
        }
        return horasAsignadas * empleado.getPerfil().getTasaStandard();
    }
}