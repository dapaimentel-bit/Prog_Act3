package modelo.dao;

import java.util.List;
import modelo.entities.Cliente;

public interface ClienteDao {
    int insert(Cliente cliente);
    Cliente findById(String cif);
    List<Cliente> findAll();    
    int delete(String cif);
    
}