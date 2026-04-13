package modelo.dao;

import modelo.entities.ProyectoConProducto;
import java.math.BigDecimal;
import java.util.List;

public interface ProyectoConProductoDao {

    /**
     * Busca todos los productos asignados a un proyecto específico
     */
    List<ProyectoConProducto> findByProyecto(String idProyecto);

    /**
     * Calcula el total de gastos en productos para un proyecto
     */
    BigDecimal getTotalProductosByProyecto(String idProyecto);

    /**
     * Actualiza la cantidad de un producto en un proyecto
     */
    int updateCantidad(Integer numOrden, Integer cantidad);

    /**
     * Devuelve todos los registros
     */
    List<ProyectoConProducto> findAll();

    /**
     * Inserta un nuevo registro
     */
    void insert(ProyectoConProducto pcp);

    /**
     * Elimina un registro
     */
    void delete(Integer numOrden);
}