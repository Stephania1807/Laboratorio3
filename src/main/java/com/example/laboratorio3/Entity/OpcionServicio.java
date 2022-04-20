package com.example.laboratorio3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "opcion_servicio")
public class OpcionServicio {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idopcion_servicio")
    private int idopcionservicio;

    @ManyToOne
    @JoinColumn(name = "opcion_idopcion")
    private Opcion idopcion;

    @ManyToOne
    @JoinColumn(name = "servicio_idservicio")
    private Servicio idservicio;

    public int getIdopcionservicio() {
        return idopcionservicio;
    }

    public void setIdopcionservicio(int idopcionservicio) {
        this.idopcionservicio = idopcionservicio;
    }

    public Opcion getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(Opcion idopcion) {
        this.idopcion = idopcion;
    }

    public Servicio getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicio idservicio) {
        this.idservicio = idservicio;
    }
}
