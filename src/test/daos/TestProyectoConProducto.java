package test.daos;



import modelo.dao.ProyectoConProductoDao;
import modelo.dao.ProyectoConProductoDaoJpa;
import modelo.entities.ProyectoConProducto;
import java.math.BigDecimal;
import java.util.List;

public class TestProyectoConProducto {
    
    public static void main(String[] args) {
        ProyectoConProductoDao dao = new ProyectoConProductoDaoJpa();
        
        System.out.println("=== TEST DE PROYECTO_CON_PRODUCTOS (con CANTIDAD) ===\n");
        
        // 1. Mostrar todos los registros
        System.out.println("1. Todos los registros:");
        List<ProyectoConProducto> todos = dao.findAll();
        for (ProyectoConProducto pcp : todos) {
            System.out.println("   " + pcp);
        }
        
        // 2. Buscar por proyecto
        System.out.println("\n2. Productos del proyecto FOR2020001:");
        List<ProyectoConProducto> porProyecto = dao.findByProyecto("FOR2020001");
        for (ProyectoConProducto pcp : porProyecto) {
            System.out.println("   Producto: " + pcp.getProducto().getDescripcion() + 
                             ", Cantidad: " + pcp.getCantidad() +
                             ", Total: " + pcp.getTotalProducto() + " €");
        }
        
        // 3. Calcular total de productos
        System.out.println("\n3. Total gastos en productos:");
        BigDecimal total = dao.getTotalProductosByProyecto("FOR2020001");
        System.out.println("   Total FOR2020001: " + total + " €");
        
        System.out.println("\n=== FIN DEL TEST ===");
    }
}
