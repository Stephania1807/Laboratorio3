package com.example.laboratorio3.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idmascota")
    private int idmascota;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "anho")
    private String anho;

    @Column(name = "historia")
    private String historia;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "sexo")
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "raza_especie_idraza")
    private Raza raza;

    @Column(name = "raza_otros")
    private String razaotros;

    @ManyToOne
    @JoinColumn(name = "cuenta_idcuenta")
    private Cuenta idcuenta;

    @OneToMany(mappedBy = "mascotaIdmascota")
    private List<Servicio> listaServicios;


    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public String getRazaotros() {
        return razaotros;
    }

    public void setRazaotros(String razaotros) {
        this.razaotros = razaotros;
    }

    public Cuenta getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Cuenta idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }
}
