package com.peluqueriacanina.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_duenio;
    private String nombre;
    private String direccion;
    private String celular;


    public Duenio(){}
    public Duenio(int id_duenio, String nombre, String direccion, String celular){
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
    }
    

    public int getId_duenio() {
        return id_duenio;
    }
    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
}
