package test.entities;

import java.math.BigDecimal;
import modelo.entities.Cliente;

public class TestClienteEntities {

    public static void main(String[] args) {

        // 1. Creación de la entidad Cliente
        Cliente c = new Cliente();
        
        // 2. Asignación de valores (Setters)
        c.setCif("A12345678");
        c.setNombre("Iberia");
        c.setApellidos("Líneas Aéreas");
        c.setDomicilio("Calle Velázquez, 130");
        c.setFacturacionAnual(new BigDecimal("5000000.50"));
        c.setNumeroEmpleados(2500);

        // 3. Prueba de salida por consola
        System.out.println("===== TEST ENTIDAD CLIENTE =====");
        
        // Comprobación de getters individuales
        System.out.println("CIF: " + c.getCif());
        System.out.println("Nombre Comercial: " + c.getNombre() + " " + c.getApellidos());
        System.out.println("Domicilio: " + c.getDomicilio());
        System.out.println("Facturación: " + c.getFacturacionAnual() + " €");
        System.out.println("Nº Empleados: " + c.getNumeroEmpleados());

        System.out.println("--------------------------------");

        // 4. Prueba del método toString()
        // Este método en la clase Cliente muestra CIF, Nombre y Apellidos
        System.out.println("Método toString():");
        System.out.println(c.toString());
    }
}