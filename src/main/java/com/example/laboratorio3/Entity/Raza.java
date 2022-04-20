package com.example.laboratorio3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "raza_especie")
public class Raza {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idmascota")
    private int idmascota;

    @Column(name = "descripcion")
    private String descripcion;

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
