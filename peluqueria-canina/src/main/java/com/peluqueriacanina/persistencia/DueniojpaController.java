package com.peluqueriacanina.persistencia;

import com.peluqueriacanina.logica.Duenio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DueniojpaController {
    
    private EntityManagerFactory emf = null;

    public DueniojpaController() {
        // "PeluqueriaPU" es el nombre que pusimos en persistence.xml
        emf = Persistence.createEntityManagerFactory("PeluqueriaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Duenio duenio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
