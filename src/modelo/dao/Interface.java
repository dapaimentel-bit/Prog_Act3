package modelo.dao;

import java.util.List;
import modelo.entities.Cliente;

public interface ClienteDao {
    int insert(Cliente cliente);      // Alta [cite: 82]
    Cliente findById(String cif);     // Buscar [cite: 83]
    List<Cliente> findAll();          // Mostrar Todos [cite: 84, 87]
    int delete(String cif);           // Eliminar [cite: 85]
}