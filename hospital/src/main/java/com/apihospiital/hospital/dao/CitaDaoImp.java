package com.apihospiital.hospital.dao;

import com.apihospiital.hospital.model.Cita;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CitaDaoImp implements ICiataDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crearCita(Cita cita) {
        entityManager.merge(cita);
    }

    @Override
    public List<Cita> consultarCitas() {
        String query= "FROM Cita";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Cita> consultasByIdDoctor(int id) {
        String query= "FROM Cita WHERE idDoctor="+id;
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Cita> consultasByIdConsultorio(int id) {
        String query= "FROM Cita WHERE idConsultorio="+id;
        return entityManager.createQuery(query).getResultList();
    }
}
