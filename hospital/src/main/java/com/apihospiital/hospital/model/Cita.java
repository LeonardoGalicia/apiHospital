package com.apihospiital.hospital.model;

import javax.persistence.*;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcitas")
    private int idCita;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idconsultorio")
    private Consultorio consultorio;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "iddoctor")
    private Doctor doctor;

    @Column(name = "horaConsulta")
    private String horaConsulta;

    @Column(name = "nombrePaciente")
    private String nombrePaciente;

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
}
