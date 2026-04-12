package modelo.dao;

import java.util.List;

import modelo.entities.Departamento;

public interface DepartamentoDao {
	
	Departamento findById(int id);
    List<Departamento> findAll();
    void save(Departamento d);
    void delete(int id);

}
