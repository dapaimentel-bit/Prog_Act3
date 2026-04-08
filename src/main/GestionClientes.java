package main;

import java.util.Scanner;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoJpa;
import modelo.entities.Cliente;

public class GestionClientes {
    public static void main(String[] args) {
        ClienteDao cdao = new ClienteDaoJpa();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) { // Opción 5: Salir [cite: 86]
            System.out.println("1. Alta del Cliente"); // [cite: 82]
            System.out.println("2. Buscar un Cliente"); // [cite: 83]
            System.out.println("3. Mostrar Todos");     // [cite: 84]
            System.out.println("4. Eliminar un cliente"); // [cite: 85]
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para pedir datos por consola y llamar a cdao.insert()
                    break;
                case 2:
                    System.out.println("Introduce CIF:");
                    Cliente c = cdao.findById(sc.next());
                    System.out.println(c != null ? c.getNombre() : "No encontrado");
                    break;
                case 3:
                    cdao.findAll().forEach(cli -> System.out.println(cli.getNombre()));
                    break;
                case 4:
                    System.out.println("Introduce CIF a eliminar:");
                    int res = cdao.delete(sc.next());
                    System.out.println(res == 1 ? "Eliminado" : "Error");
                    break;
            }
        }
    }
}