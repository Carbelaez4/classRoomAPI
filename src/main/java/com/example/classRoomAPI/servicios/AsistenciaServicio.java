package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Asistencia;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaServicio {

    @Autowired
    IAsistenciaRepositorio repositorio;

    //Metodo Guardar

    public Asistencia guardarAsistencia(Asistencia datosAsistencia)throws Exception{
        try{
            return this.repositorio.save(datosAsistencia);
        }
        catch (Exception error){
            throw new Exception();
        }

    }

    //Metodo BuscarTodos
    public List<Asistencia> listarAsistencias()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }


}
