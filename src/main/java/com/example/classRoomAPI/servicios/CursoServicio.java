package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Curso;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServicio {
    @Autowired
    ICursoRepositorio repositorio;

    //Metodo Guardar
    public Curso guardarCurso(Curso datosCurso)throws Exception{
        try{
            return this.repositorio.save(datosCurso);
        }catch (Exception error){
            throw new Exception();
        }

    }

    //Metodo BuscarTodos
    public List<Curso> listarCursos()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }
}


