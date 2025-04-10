package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.modelos.Estudiante;
import com.example.classRoomAPI.repositorios.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicio {
@Autowired
    IEstudianteRepositorio repositorio;

    //Metodfo Guardar
    public Estudiante guardarEstudiante(Estudiante datosEstudiante)throws Exception{
        try {
            return this.repositorio.save(datosEstudiante);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo BuscarTodos
    public List<Estudiante> listarEstudiantes()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }
}
