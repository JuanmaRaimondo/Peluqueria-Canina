package com.peluqueriacanina.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int num_cliente;
    protected String nombre_de_perro;
    protected String raza;
    protected String color;
    protected String alergico;
    protected String atencion_especial;
    protected String observaciones;

    @OneToOne
    private Duenio duenio;

    public Mascota(){}
    public Mascota(int num_cliente, String nombre_de_perro,String raza, String color, String alergico, String atencion_especial,String observaciones, Duenio duenio){
        this.num_cliente = num_cliente;
        this.nombre_de_perro = nombre_de_perro;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencion_especial = atencion_especial;
        this.observaciones = observaciones;
        this.duenio = duenio;
    }
    public int getNum_cliente() {
        return num_cliente;
    }
    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }
    public String getNombre_de_perro() {
        return nombre_de_perro;
    }
    public void setNombre_de_perro(String nombre_de_perro) {
        this.nombre_de_perro = nombre_de_perro;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String isAlergico() {
        return alergico;
    }
    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }
    public String getAtencion_especial() {
        return atencion_especial;
    }
    public void setAtencion_especial(String atencion_especial) {
        this.atencion_especial = atencion_especial;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenio getDuenio(){
        return duenio;
    }
    
    public void setDuenio(Duenio duenio){
        this.duenio = duenio;
    }
}
