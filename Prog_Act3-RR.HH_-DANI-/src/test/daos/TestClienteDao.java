package test.daos;

import java.util.List;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImpl;
import modelo.entities.Cliente;

public class TestClienteDao {

    public static void main(String[] args) {

        // Instanciamos el DAO de Cliente
        ClienteDao dao = new ClienteDaoImpl();

        // 1. CREATE (INSERTAR)
        System.out.println("--- 1. INSERTAR CLIENTE ---");
        Cliente c = new Cliente();
        c.setCif("B12345678");
        c.setNombre("Sistemas Futuros S.L.");
        c.setDireccion("Calle Doctor Zarzuelo 37");
        
        int insertado = dao.insert(c);
        
        if (insertado == 1) {
            System.out.println("CLIENTE CREADO: " + c.getNombre());
        } else {
            System.out.println("Error al insertar el cliente.");
        }
        System.out.println("-----------------------------------");


        // 2. READ (FIND BY ID)
        System.out.println("--- 2. BUSCAR POR CIF ---");
        Cliente encontrado = dao.findById("B12345678");

        if (encontrado != null) {
            System.out.println("CLIENTE ENCONTRADO:");
            System.out.println("CIF: " + encontrado.getCif() + " | Nombre: " + encontrado.getNombre());
        } else {
            System.out.println("Cliente con CIF " + encontrado.getCif() + " no encontrado.");
        }
        System.out.println("-----------------------------------");


        // 3. FIND ALL (LISTAR)
        System.out.println("--- 3. LISTADO DE CLIENTES ---");
        List<Cliente> lista = dao.findAll();
        
        for (Cliente cli : lista) {
            System.out.println(
                cli.getCif() + " | " + 
                cli.getNombre() + " | " + 
                cli.getDireccion()
            );
        }
        System.out.println("Total clientes: " + lista.size());
        System.out.println("-----------------------------------");


        // 4. DELETE (BORRAR)
        System.out.println("--- 4. ELIMINAR CLIENTE ---");
       
        int eliminado = dao.delete("B12345678");

        if (eliminado == 1) {
            System.out.println("CLIENTE ELIMINADO CORRECTAMENTE");
        } else {
            System.out.println("No se pudo eliminar el cliente (posiblemente no existe)");
        }
        System.out.println("-----------------------------------");


        // 5. VERIFICAR BORRADO
        System.out.println("--- 5. VERIFICAR BORRADO ---");
        Cliente verif = dao.findById("B12345678");

        if (verif == null) {
            System.out.println("Confirmado: el cliente ya no existe en la base de datos.");
        } else {
            System.out.println("ERROR: El cliente sigue existiendo.");
        }
    }
}