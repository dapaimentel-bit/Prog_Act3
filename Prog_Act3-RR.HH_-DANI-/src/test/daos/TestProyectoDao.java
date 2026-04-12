package test.daos;

import java.util.Date;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImpl;
import modelo.entities.Proyecto;

public class TestProyectoDao {

	public static void main(String[] args) {
		
		ProyectoDao dao = new ProyectoDaoImpl();
		
	//--CREATE----
		
		Proyecto p = new Proyecto(); 
		p.setIdProyecto("FOR2026001");
		p.setDescripcion("Formacion del alumnado de Tomas");
		p.setFechaInicio(new Date());
		p.setFechaFinPrevisto(new Date());
		p.setFechaFinReal(null);
		p.setVentaPrevisto(50001.00);
		p.setCosteReal(30001.00);
		p.setCostesPrevisto(3000.00);
		p.setEstado("ACTIVO");
		p.setJefeProyecto(114);
		p.setCif("A22222222");
		
		dao.save(p);
		
		System.out.println("PROYECTO CREADO");
		System.out.println("NOMBRE DEL PROYECTO: " + p.getDescripcion());
		System.out.println("---------------------------------------------------");
		System.out.println();
		
		
	//--LEER---
		Proyecto encontrado = dao.finById(p.getIdProyecto());
		Proyecto nP = dao.finById("FOR2026001");
		
		if (encontrado != null) {
            System.out.println("PROYECTO ENCONTRADO:");
            System.out.println(encontrado.getIdProyecto() + " - "
                    + encontrado.getDescripcion() + " - "
                    + encontrado.getCostesPrevisto());
        } else {
            System.out.println("PROYECTO NO ENCONTRADO");
        }

        System.out.println("-----------------------------------");
        
// 3. UPDATE (MODIFICAR)
        
        encontrado.setJefeProyecto(114);
        encontrado.setCif("A22222222");
        p.setEstado("TERMINADO");

        dao.update(encontrado);
        

        System.out.println("PROYECTO TERMINADO Y ACTUALIZADO");
        System.out.println("-----------------------------------");


        
        // 4. FIND ALL (LISTAR)
        
        System.out.println("LISTADO DE EMPLEADOS:");

        for (Proyecto Proyect : dao.finAll()) {
            System.out.println(
            		Proyect.getIdProyecto() + " | " +
            		Proyect.getDescripcion() + " | " +
            		Proyect.getFechaInicio() + " € | " +
            		Proyect.getFechaFinPrevisto()
            );
        }

        System.out.println("-----------------------------------");

    
        // 5. DELETE (BORRAR)
        
        dao.delete(p.getIdProyecto());

        System.out.println("EMPLEADO ELIMINADO");

        System.out.println("-----------------------------------");


        
        // 6. VERIFICAR BORRADO
        
        Proyecto eliminado = dao.finById(p.getIdProyecto());

        if (eliminado == null) {
            System.out.println("CONFIRMADO: EL PROYECTO NO EXISTE");
        } else {
            System.out.println("EL PROYECTO SIGUE EXISTIENDO");
        }

		
	}

}
