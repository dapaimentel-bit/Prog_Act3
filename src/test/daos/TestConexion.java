package test.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestConexion {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("proyectos_fp_2025");

        EntityManager em = emf.createEntityManager();

        System.out.println("CONEXIÓN OK");

        em.close();
        emf.close();
    }
}