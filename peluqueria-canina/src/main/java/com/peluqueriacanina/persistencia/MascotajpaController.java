package com.peluqueriacanina.persistencia;

import java.util.List;

import com.peluqueriacanina.logica.Mascota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MascotajpaController {
    
    private EntityManagerFactory emf = null;

    public MascotajpaController() {
        emf = Persistence.createEntityManagerFactory("PeluqueriaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mascota mascota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para traer todos los registros de la tabla Mascota
    public List<Mascota> findMascotaEntities() {
        EntityManager em = getEntityManager();
        try {
            // Esto es JPQL (Java Persistence Query Language)
            // "SELECT m FROM Mascota m" significa: Selecciónames todos los objetos Mascota
            return em.createQuery("SELECT m FROM Mascota m", Mascota.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Método para ELIMINAR (Destroy)
    public void destroy(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            // 1. Buscamos la mascota por ID antes de borrarla
            Mascota mascota;
            try {
                mascota = em.getReference(Mascota.class, id);
                mascota.getNum_cliente(); // Tocamos un atributo para asegurar que cargó
            } catch (Exception e) {
                // Si no existe, no hacemos nada
                return;
            }
            
            // 2. La borramos
            em.remove(mascota);
            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Mascota findMascota(int id) {
    EntityManager em = getEntityManager();
    try {
        return em.find(Mascota.class, id);
    } finally {
        em.close();
    }
}

public void edit(Mascota mascota) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            // El merge es lo que actualiza
            mascota = em.merge(mascota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}