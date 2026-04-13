package modelo.dao;

import java.util.List;

import modelo.entities.Proyecto;

public class ProyectoDaoJpa implements ProyectoDao {

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto, String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double importesVentaProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double porcentajeMargenBrutoProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
