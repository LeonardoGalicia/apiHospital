# apiHospital

# apiHospital

Sigue los siguentes pasos.

- importa el script Dump20220707.sql en mysql
- abre el proyecto en intellej o tu idee importalo como proyecto maven
- cambia el ususario y contraseña de la conexion por tus datos en el archivo application.porperties, lineas a modificar spring.datasource.username=root spring.datasource.password=sasa
- corre el proyecto e ingresa a la siguiente linea http://localhost:8888/swagger-ui/index.html#/ donde podras probrar los endpoint

 ejemplo de endpoints 

1. crear cita

post http://localhost:8888/cita

json ejemplo:

{
    "consultorio":{
        "idConsultorio":1
    },
    "doctor":{
        "idDoctor":3
    },
    "horaConsulta":"12:00",
    "nombrePaciente":"leo"

}

2.consultar por doctor

get http://localhost:8888/citasByDoctor/{idDoctor}

donde {idDoctor} es variable dependiendo el id del doctor que quiera consultar

ejemplo

http://localhost:8888/citasByDoctor/3

3. consultar por consultorio

get http://localhost:8888/citasByConsultorio/{idConsultorio}

donde {idConsultorio} es variable dependiendo el id del consultorio que quiera consultar

ejemplo

http://localhost:8888/citasByConsultorio/1
