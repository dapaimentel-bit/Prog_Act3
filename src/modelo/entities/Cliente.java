package modelo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String cif;

    private String nombre;
    private String apellidos;
    private String domicilio;

    @Column(name="facturacion_anual")
    private BigDecimal facturacionAnual;

    @Column(name="numero_empleados")
    private int numeroEmpleados;

    public Cliente() {
    }

   
    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    
    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
    
    public BigDecimal getFacturacionAnual() { return facturacionAnual; }
    public void setFacturacionAnual(BigDecimal facturacionAnual) { this.facturacionAnual = facturacionAnual; }
    
    public int getNumeroEmpleados() { return numeroEmpleados; }
    public void setNumeroEmpleados(int numeroEmpleados) { this.numeroEmpleados = numeroEmpleados; }

    @Override
    public String toString() {
        return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
    }
}