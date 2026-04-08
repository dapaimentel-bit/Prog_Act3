package modelo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Entidad JPA para la tabla 'clientes'[cite: 6].
 * Representa a los clientes de la aplicación de gestión de proyectos[cite: 4].
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="cif")
    private String cif; // VARCHAR(10) [cite: 8]

    @Column(nullable=false, length=20)
    private String nombre; // VARCHAR(20) [cite: 10]

    @Column(nullable=false, length=45)
    private String apellidos; // VARCHAR(45) [cite: 11]

    @Column(length=100)
    private String domicilio; // VARCHAR(100) [cite: 12]

    @Column(name="facturacion_anual", precision=15, scale=2)
    private BigDecimal facturacionAnual; // DECIMAL(15,2) 

    @Column(name="numero_empleados")
    private Integer numeroEmpleados; // INT 

    // --- CONSTRUCTORES ---
    public Cliente() {
    }

    public Cliente(String cif, String nombre, String apellidos) {
        this.cif = cif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

 
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public BigDecimal getFacturacionAnual() {
        return facturacionAnual;
    }

    public void setFacturacionAnual(BigDecimal facturacionAnual) {
        this.facturacionAnual = facturacionAnual;
    }

    public Integer getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(Integer numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    @Override
    public String toString() {
        return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cif, cliente.cif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cif);
    }
}