package modelo.dao;

import jakarta.persistence.*;
import modelo.entities.Proyecto;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "proyecto_con_productos")
public class ProyectoConProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_orden")
    private Integer numOrden;
    
    @ManyToOne
    @JoinColumn(name = "id_proyecto", nullable = false)
    private Proyecto proyecto;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
    
    @Column(name = "precio_asignado", nullable = false)
    private Integer precioAsignado;
    

    @Column(name = "cantidad")
    private Integer cantidad;
    
    // Constructores
    public ProyectoConProducto() {}
    
    public ProyectoConProducto(Proyecto proyecto, Producto producto, Integer precioAsignado, Integer cantidad) {
        this.proyecto = proyecto;
        this.producto = producto;
        this.precioAsignado = precioAsignado;
        this.cantidad = cantidad;
    }
    
    // Getters y Setters
    public Integer getNumOrden() {
        return numOrden;
    }
    
    public void setNumOrden(Integer numOrden) {
        this.numOrden = numOrden;
    }
    
    public Proyecto getProyecto() {
        return proyecto;
    }
    
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Integer getPrecioAsignado() {
        return precioAsignado;
    }
    
    public void setPrecioAsignado(Integer precioAsignado) {
        this.precioAsignado = precioAsignado;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    // Método para calcular el total del producto (precio * cantidad)
    public BigDecimal getTotalProducto() {
        if (precioAsignado != null && cantidad != null) {
            return BigDecimal.valueOf(precioAsignado).multiply(BigDecimal.valueOf(cantidad));
        } else if (precioAsignado != null) {
            return BigDecimal.valueOf(precioAsignado);
        }
        return BigDecimal.ZERO;
    }
    
    @Override
    public String toString() {
        return "ProyectoConProducto{" +
                "numOrden=" + numOrden +
                ", idProyecto=" + (proyecto != null ? proyecto.getIdProyecto() : "null") +
                ", idProducto=" + (producto != null ? producto.getIdProducto() : "null") +
                ", precioAsignado=" + precioAsignado +
                ", cantidad=" + cantidad +
                ", total=" + getTotalProducto() +
                '}';
    }
}