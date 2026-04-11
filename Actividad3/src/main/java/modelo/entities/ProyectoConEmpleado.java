package modelo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="proyecto_con_empleados")
public class ProyectoConEmpleado implements Serializable {
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
        if (empleado != null && empleado.getPerfil() != null) {
            return horasAsignadas * empleado.getPerfil().getTasaStandard();
        }
        return 0;
    }
}
