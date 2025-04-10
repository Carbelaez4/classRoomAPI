package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Calificacion;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServicio {

    @Autowired
    ICalificacionRepositorio repositorio;

    //Metodo Guardar
    public Calificacion guardarCalificacion(Calificacion datosCalificacion)throws Exception{
        try{
            return this.repositorio.save(datosCalificacion);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo BuscarTodos
    public List<Calificacion> listarCalificaciones()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }
}




