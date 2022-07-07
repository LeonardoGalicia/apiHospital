package com.apihospiital.hospital.dao;

import com.apihospiital.hospital.model.Cita;

import java.util.List;

public interface ICiataDao {

    void crearCita(Cita cita);

    List<Cita> consultarCitas();
    List<Cita> consultasByIdDoctor(int id);
    List<Cita> consultasByIdConsultorio(int id);
}
