package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.modelos.Inscripcion;
import com.example.classRoomAPI.repositorios.IInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionServicio {

    @Autowired
    IInscripcionRepositorio repositorio;

    //Metodo Guardar
    public Inscripcion guardarInscripcion(Inscripcion datosInscripcion)throws Exception{
        try{
            return this.repositorio.save(datosInscripcion);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo BuscarTodos
    public List<Inscripcion> listarInscripciones()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }
}


