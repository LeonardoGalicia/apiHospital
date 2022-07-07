package com.apihospiital.hospital.servicio;

import com.apihospiital.hospital.dao.IDoctorDao;
import com.apihospiital.hospital.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImp implements IDoctorService{

    @Autowired
    IDoctorDao doctorDao;

    @Override
    public List<Doctor> getDoctor() {
        return doctorDao.getDoctores();
    }
}
