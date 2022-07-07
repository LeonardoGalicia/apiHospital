package com.apihospiital.hospital.controller;

import com.apihospiital.hospital.model.Doctor;
import com.apihospiital.hospital.servicio.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorControllerRest {

/*
    @Autowired
    IDoctorService doctorService;

    @GetMapping("/doctores")
    public List<Doctor> getDoctores(){
        return doctorService.getDoctor();
    }*/

}
