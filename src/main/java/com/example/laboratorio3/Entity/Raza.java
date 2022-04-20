package com.example.laboratorio3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "raza_especie")
public class Raza {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idraza")
    private int idraza;

    @Column(name = "descripcion")
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdraza() {
        return idraza;
    }

    public void setIdraza(int idraza) {
        this.idraza = idraza;
    }
}
