package test.entities;

import java.util.Date;

import modelo.entities.Proyecto;

public class TestProyectoEntities {

	public static void main(String[] args) {
		
		Proyecto p = new Proyecto();
		
		p.setCif("B11111111");
		p.setIdProyecto("FOR2000002");
		p.setDescripcion("FORMACION GENERAL");
		p.setFechaInicio(new Date());
		p.setFechaFinPrevisto(new Date());
		p.setFechaFinReal(new Date());
		p.setVentaPrevisto(10000.00);
		p.setCostesPrevisto(2000.00);
		p.setCosteReal(1500.00);
		p.setEstado("ACTIVO");
		p.setJefeProyecto(115);
		
		
		System.out.println("===== TEST ENTIDADES =====");
        System.out.println("ID PROYECTO: " + p.getIdProyecto());
        System.out.println("Genero: " + p.getDescripcion());
        System.out.println("Salario 3 meses: " + p.getCostesPrevisto());

	}

}
