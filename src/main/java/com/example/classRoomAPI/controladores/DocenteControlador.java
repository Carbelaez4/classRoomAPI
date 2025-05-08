package com.example.classRoomAPI.controladores;

import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.servicios.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docentes")/*Este es el endPoint*/
public class DocenteControlador {

    @Autowired
    DocenteServicio servicio;

    //guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Docente datosQueEnviaElCliente){
        try{

            return ResponseEntity
                    .status(HttpStatus.CREATED)  /*status es el codigo*/
                    .body(this.servicio.guardarDocente(datosQueEnviaElCliente));

        }catch (Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)  /*status es el codigo*/
                    .body(error.getMessage());

        }

    }    /*el signo de interrogacion es una respuesta que puede ser positiva o negativa*/

    //buscarTodos

    //buscarPorId

    //modificar

    //eliminar


}


