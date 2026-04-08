package principales;

import java.util.Scanner;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoJpa;
import modelo.entities.Cliente;

public class GestionClientes {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ClienteDao cdao = new ClienteDaoJpa();
        int opcion = 0;

        do {
            
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Alta del Cliente");
            System.out.println("2. Buscar un Cliente");
            System.out.println("3. Mostrar Todos");
            System.out.println("4. Eliminar un cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Cliente nuevo = new Cliente();
                    System.out.print("CIF: "); nuevo.setCif(leer.next());
                    System.out.print("Nombre: "); nuevo.setNombre(leer.next());
                    
                    if (cdao.insert(nuevo) == 1) System.out.println("Alta correcta");
                    break;
                case 2:
                    System.out.print("CIF a buscar: ");
                    Cliente buscado = cdao.findById(leer.next());
                    System.out.println(buscado != null ? buscado : "No existe");
                    break;
                case 3:
                    cdao.findAll().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("CIF a eliminar: ");
                    if (cdao.delete(leer.next()) == 1) System.out.println("Borrado");
                    else System.out.println("No se pudo borrar");
                    break;
            }
        } while (opcion != 5);
        leer.close();
    }
}