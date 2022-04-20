package com.example.laboratorio3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "responsable")
public class Responsable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idresponsable")
    private int idresponsable;

    @Column(name = "nombre")
    private String nombre;

    public int getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(int idresponsable) {
        this.idresponsable = idresponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
