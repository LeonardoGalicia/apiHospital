package com.apihospiital.hospital.servicio;

import com.apihospiital.hospital.model.Cita;

import java.util.List;

public interface ICitaSevice {

    int crearCita(Cita cita);
    List<Cita> getCitasByConsultorio(int id);
    List<Cita> getCitasByDoctor(int id);
}
