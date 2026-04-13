package modelo.dao;




import modelo.entities.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ImprimirGastos {

private static ProyectoDao proyectoDao = new ProyectoDaoJpa();
private static ProyectoConEmpleadoDao proyectoConEmpleadoDao = new ProyectoConEmpleadoDao();
private static ProyectoConProductoDao proyectoConProductoDao = new ProyectoConProductoDaoJpa();
private static EmpleadoDao empleadoDao = new EmpleadoDaoJpa();
private static ClienteDao clienteDao = new ClienteDaoJpa();
private static ProductoDao productoDao = new ProductoDaoJpa(); // ✅ añadido

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== INFORME DE GASTOS REALES DE PROYECTOS ===");
    System.out.print("Introduzca el ID del proyecto (ej: FOR2020001): ");
    String idProyecto = scanner.nextLine().trim().toUpperCase();

    Proyecto proyecto = obtenerOCrearProyecto(idProyecto);

    if (proyecto != null) {
        imprimirInformeGastos(proyecto);
    } else {
        System.out.println("No se pudo procesar el proyecto.");
    }

    scanner.close();
}

private static Proyecto obtenerOCrearProyecto(String idProyecto) {
    Proyecto proyecto = proyectoDao.findWithDetails(idProyecto);

    if (proyecto != null && "TERMINADO".equals(proyecto.getEstado())) {
        System.out.println("\n✓ Proyecto encontrado en la base de datos.");
        return proyecto;
    }

    System.out.println("\n⚠ El proyecto '" + idProyecto + "' no existe o no está TERMINADO.");
    System.out.println("Se procederá a crear un proyecto de prueba...");

    return crearProyectoDePrueba(idProyecto);
}

private static Proyecto crearProyectoDePrueba(String idProyecto) {
    try {
        // Cliente
        Cliente cliente = clienteDao.findById("A22222222");
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setCif("A22222222");
            cliente.setNombre("Carlos");
            cliente.setApellidos("March");
            cliente.setDomicilio("Madrid");
            cliente.setFacturacionAnual(new BigDecimal("12000000"));
            cliente.setNumeroEmpleados(1500);
            clienteDao.insert(cliente);
            System.out.println("  - Cliente creado");
        }

        // Proyecto
        Proyecto proyecto = new Proyecto();
        proyecto.setIdProyecto(idProyecto);
        proyecto.setDescripcion("Proyecto de prueba para informe de gastos");
        proyecto.setFechaInicio(LocalDate.of(2024, 1, 15));
        proyecto.setFechaFinPrevisto(LocalDate.of(2024, 6, 30));
        proyecto.setFechaFinReal(LocalDate.now());
        proyecto.setVentaPrevisto(new BigDecimal("150000"));
        proyecto.setCostesPrevisto(new BigDecimal("80000"));
        proyecto.setEstado("TERMINADO");
        proyecto.setCliente(cliente);

        Empleado jefeProyecto = empleadoDao.findById(114);
        if (jefeProyecto != null) {
            proyecto.setJefeProyecto(jefeProyecto);
        }

        proyectoDao.insert(proyecto);
        System.out.println("  - Proyecto creado");

        asignarEmpleadosAProyecto(proyecto);
        asignarProductosAProyecto(proyecto);

        BigDecimal costeReal = calcularCosteReal(proyecto);
        proyecto.setCosteReal(costeReal);
        proyectoDao.update(proyecto);

        System.out.println("  - Coste real: " + costeReal + " €");

        return proyectoDao.findWithDetails(idProyecto);

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

private static void asignarEmpleadosAProyecto(Proyecto proyecto) {

    Empleado emp1 = empleadoDao.findById(115);
    Empleado emp2 = empleadoDao.findById(116);
    Empleado emp3 = empleadoDao.findById(117);

    if (emp1 != null) {
        ProyectoConEmpleado pce = new ProyectoConEmpleado(proyecto, emp1, 80);
        pce.setFechaIncorporacion(LocalDate.of(2024, 1, 20));
        proyectoConEmpleadoDao.insert(pce);
    }

    if (emp2 != null) {
        ProyectoConEmpleado pce = new ProyectoConEmpleado(proyecto, emp2, 60);
        pce.setFechaIncorporacion(LocalDate.of(2024, 1, 25));
        proyectoConEmpleadoDao.insert(pce);
    }

    if (emp3 != null) {
        ProyectoConEmpleado pce = new ProyectoConEmpleado(proyecto, emp3, 40);
        pce.setFechaIncorporacion(LocalDate.of(2024, 2, 1));
        proyectoConEmpleadoDao.insert(pce);
    }
}

private static void asignarProductosAProyecto(Proyecto proyecto) {

    Producto producto = productoDao.findById(1);

    if (producto != null) {
        ProyectoConProducto pcp = new ProyectoConProducto();
        pcp.setProyecto(proyecto);
        pcp.setProducto(producto);
        pcp.setPrecioAsignado(125);
        pcp.setCantidad(3);

        proyectoConProductoDao.insert(pcp);
    }
}

private static BigDecimal calcularCosteReal(Proyecto proyecto) {

    BigDecimal total = BigDecimal.ZERO;

    List<ProyectoConEmpleado> empleados =
            proyectoConEmpleadoDao.findByProyecto(proyecto.getIdProyecto());

    for (ProyectoConEmpleado pce : empleados) {
        BigDecimal tasa = empleadoDao.getTasaStandardByEmpleado(pce.getEmpleado().getIdEmpl());
        if (tasa == null) tasa = BigDecimal.valueOf(100);

        total = total.add(
                tasa.multiply(BigDecimal.valueOf(pce.getHorasAsignadas()))
        );
    }

    BigDecimal productos =
            proyectoConProductoDao.getTotalProductosByProyecto(proyecto.getIdProyecto());

    return total.add(productos);
}

private static void imprimirInformeGastos(Proyecto proyecto) {

    System.out.println("\n========== INFORME ==========");

    System.out.println("Proyecto: " + proyecto.getIdProyecto());
    System.out.println("Descripción: " + proyecto.getDescripcion());

    if (proyecto.getCliente() != null) {
        System.out.println("Cliente: " +
                proyecto.getCliente().getNombre() + " " +
                proyecto.getCliente().getApellidos());
    } else {
        System.out.println("Cliente: N/A");
    }

    System.out.println("Estado: " + proyecto.getEstado());
    System.out.println("Coste real: " + proyecto.getCosteReal());

    List<ProyectoConEmpleado> empleados =
            proyectoConEmpleadoDao.findByProyecto(proyecto.getIdProyecto());

    System.out.println("\n--- EMPLEADOS ---");

    for (ProyectoConEmpleado pce : empleados) {
        System.out.println(pce.getEmpleado().getNombreCompleto() +
                " | Horas: " + pce.getHorasAsignadas());
    }

    List<ProyectoConProducto> productos =
            proyectoConProductoDao.findByProyecto(proyecto.getIdProyecto());

    System.out.println("\n--- PRODUCTOS ---");

    for (ProyectoConProducto p : productos) {
        System.out.println(p.getProducto().getDescripcion() +
                " | Cantidad: " + p.getCantidad());
    }

    System.out.println("\nTOTAL COSTE: " + proyecto.getCosteReal());
}
```

}
