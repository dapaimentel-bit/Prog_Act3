package test.entities;

import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class TestEntidadesRRHH {

    public static void main(String[] args) {

        // Creacion de entidades
        Departamento d = new Departamento();
        d.setIdDepar(10);
        d.setNombre("Software");

        Perfil p = new Perfil();
        p.setIdPerfil(1);
        p.setNombre("Administrador");

        Empleado e = new Empleado();
        e.setNombre("Juan");
        e.setApellidos("Pérez");
        e.setGenero('H');
        e.setSalario(1500);
        e.setDepartamento(d);
        e.setPerfil(p);

        // Prueba de métodos propios
        System.out.println("===== TEST ENTIDADES =====");
        System.out.println("Nombre completo: " + e.nombreCompleto());
        System.out.println("Genero: " + e.literalGenero());
        System.out.println("Salario 3 meses: " + e.salarioMensual(3));

        // Relaciones correctas
        System.out.println("Departamento: " + e.getDepartamento().getNombre());
        System.out.println("Perfil: " + e.getPerfil().getNombre());
    }
}