package com.apihospiital.hospital.servicio;

import com.apihospiital.hospital.dao.ICiataDao;
import com.apihospiital.hospital.model.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImp implements ICitaSevice{

    @Autowired
    private ICiataDao ciataDao;

    @Override
    public int crearCita(Cita cita) {
        List<Cita>  citas = null;
        citas = ciataDao.consultarCitas();
        int error =0;
        if (citas !=null){
            for(Cita citaFor: citas){
                if(citaFor.getConsultorio().getIdConsultorio() == cita.getConsultorio().getIdConsultorio() &&
                        citaFor.getHoraConsulta().equals(cita.getHoraConsulta())){
                    return 1;
                }else if(citaFor.getDoctor().getIdDoctor() == cita.getDoctor().getIdDoctor() &&
                        citaFor.getHoraConsulta().equals(cita.getHoraConsulta())){
                    return 2;
                }
            }
        }

        List<Cita> citasByIdDoctor = ciataDao.consultasByIdDoctor(cita.getDoctor().getIdDoctor());
        if(citasByIdDoctor.size()>=8){
            return 3;
        }

        ciataDao.crearCita(cita);
        return 0;

    }

    @Override
    public List<Cita> getCitasByConsultorio(int id) {
        return ciataDao.consultasByIdDoctor(id);
    }

    @Override
    public List<Cita> getCitasByDoctor(int id) {
        return ciataDao.consultasByIdDoctor(id);
    }


}
