package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.modelos.Materia;
import com.example.classRoomAPI.repositorios.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServicio {
    @Autowired
    IMateriaRepositorio repositorio;

    //Metodo Guardar
    public Materia guardarMateria(Materia datosMateria)throws Exception{
        try{
            return this.repositorio.save(datosMateria);
        }catch (Exception error){
            throw new Exception();
        }
    }
    //Metodo BuscarTodos
    public List<Materia> listarMaterias()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }
}
