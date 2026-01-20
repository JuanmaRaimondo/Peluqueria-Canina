package com.peluqueriacanina.persistencia;

import java.util.List;

import com.peluqueriacanina.logica.Duenio;
import com.peluqueriacanina.logica.Mascota;

public class ControladorPersistencia {
    
    // Instanciamos a los especialistas (los dos archivos nuevos)
    DueniojpaController duenioJpa = new DueniojpaController();
    MascotajpaController mascotaJpa = new MascotajpaController();

    // Método que recibe todo y reparte el trabajo
    public void guardar(Duenio duenio, Mascota masco) {
        
        // 1. Crear Dueño en la BD
        duenioJpa.create(duenio);
        
        // 2. Crear Mascota en la BD
        mascotaJpa.create(masco);
    }

    public List<Mascota> traerMascota() {
        // El gerente le dice al obrero: "Tráeme la lista"
        return mascotaJpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente){
        mascotaJpa.destroy(num_cliente);
    }

    public Mascota findMascota(int id){
        return mascotaJpa.findMascota(id);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            // Aquí podríamos imprimir el error, pero por ahora lo dejamos así
        }
    }
}