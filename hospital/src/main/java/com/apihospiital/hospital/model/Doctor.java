package com.apihospiital.hospital.model;

import javax.persistence.*;

@Entity
@Table(name = "doctores")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddoctores" )
    private int idDoctor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidop")
    private String apellidoP;

    @Column(name = "apellidom")
    private String apellidoM;

    @Column(name = "especialidad")
    private String especialidad;

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidop) {
        this.apellidoP = apellidop;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidom) {
        this.apellidoM = apellidom;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
