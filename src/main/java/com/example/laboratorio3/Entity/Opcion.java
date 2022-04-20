package com.example.laboratorio3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "opcion")
public class Opcion {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idopcion")
    private int idopcion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tiempo_minutos")
    private int tiempo;

    @Column(name = "precio")
    private double precio;

    public int getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(int idopcion) {
        this.idopcion = idopcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
