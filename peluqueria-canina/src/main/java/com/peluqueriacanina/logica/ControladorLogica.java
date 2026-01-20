package com.peluqueriacanina.logica;

import java.util.List;

import com.peluqueriacanina.persistencia.ControladorPersistencia;


public class ControladorLogica {
    ControladorPersistencia controlpersi = new ControladorPersistencia();
    public void Guardar(String nombre, String raza, String color, String observacion, String alergico, String atencEspecial, String Nduenio, String celular, String direccion){
        Duenio duenio = new Duenio();
        duenio.setNombre(Nduenio);
        duenio.setCelular(celular);
        duenio.setId_duenio(0);
        duenio.setDireccion(direccion);
        Mascota masco = new Mascota();
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencEspecial);
        masco.setColor(color);
        masco.setDuenio(duenio);
        masco.setNombre_de_perro(nombre);
        masco.setNum_cliente(0);
        masco.setObservaciones(observacion);
        masco.setRaza(raza);
        controlpersi.guardar(duenio, masco);
    }
    public List<Mascota> traerMascota(){
        return controlpersi.traerMascota();
    }

    public void borrarMascota(int num_cliente){
        controlpersi.borrarMascota(num_cliente);
    }

    public Mascota findMascota(int id){
        return controlpersi.findMascota(id);
    }

    public void modificarMascota(Mascota masco, String nombre, String raza, String color, 
                                 String observaciones, String alergico, String atEspecial, 
                                 String nombreDuenio, String celDuenio) {
        
        // 1. Modificamos los datos de la mascota con los "Setters"
        masco.setNombre_de_perro(nombre);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atEspecial);
        
        // 2. Modificamos los datos del Dueño
        // Usamos el objeto dueño que ya tiene la mascota y le seteamos los valores nuevos
        controlpersi.modificarMascota(masco);
        
        // Un detalle importante: 
        // Para modificar el dueño, primero lo buscamos dentro de la mascota
        masco.getDuenio().setNombre(nombreDuenio);
        masco.getDuenio().setCelular(celDuenio);
        
        // 3. Llamamos a la persistencia para guardar TODO junto
        // (Al guardar la mascota, JPA guarda automáticamente al dueño asociado)
        controlpersi.modificarMascota(masco);
    }
}
