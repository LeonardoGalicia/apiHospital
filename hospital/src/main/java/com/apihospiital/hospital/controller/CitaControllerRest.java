package com.apihospiital.hospital.controller;

import com.apihospiital.hospital.dao.ICiataDao;
import com.apihospiital.hospital.model.Cita;
import com.apihospiital.hospital.servicio.ICitaSevice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CitaControllerRest {

    @Autowired
    private ICitaSevice citaSevice;




    @Operation(summary = "1. crear cita con las restricciones mencionandas en el pdf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Creada",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "ya existe una cita en ese consultorio a la misma hora",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "el doctor ya tiene una cita con ese horario",
                    content = @Content),})
    @PostMapping("/cita")
    public ResponseEntity<?> crearCita(@RequestBody Cita cita){
        Map<String, Object> response = new HashMap<>();

        int respuesta = citaSevice.crearCita(cita);

        if (respuesta == 1){
            response.put("error:","ya existe una cita en ese consultorio a la misma hora");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (respuesta == 2){
            response.put("error:","el doctor ya tiene una cita con ese horario");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (respuesta == 3){
            response.put("error:","ya no tine citas disponibles el doctor");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("message:","cita creada exitosamente");
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);

    }

    @Operation(summary = "Consultar citas por id de consultorio")
    @GetMapping("/citasByConsultorio/{idConsultorio}")
    public List<Cita> getCitasByConsultorio(@PathVariable int idConsultorio){
        return citaSevice.getCitasByConsultorio(idConsultorio);
    }

    @Operation(summary = "Consultar citas por id de doctor")
    @GetMapping("/citasByDoctor/{idDoctor}")
    public List<Cita> getCitasByDoctor(@PathVariable int idDoctor){
        return citaSevice.getCitasByDoctor(idDoctor);
    }


}
