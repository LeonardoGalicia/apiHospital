package com.apihospiital.hospital.dao;

import com.apihospiital.hospital.model.Doctor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class DoctorDaoImp implements IDoctorDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Doctor> getDoctores() {
        String query = "From Doctor";
        return entityManager.createQuery(query).getResultList();
    }
}
