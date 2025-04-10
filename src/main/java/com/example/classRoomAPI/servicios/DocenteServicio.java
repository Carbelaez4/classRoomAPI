package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServicio {

    @Autowired
    IDocenteRepositorio repositorio; //repositorio es el nombre del objeto

    //Metodo Guardar
    public Docente guardarDocente(Docente datosDocente)throws Exception{
       try{
           return this.repositorio.save(datosDocente);

       }catch (Exception error){
            throw new Exception();
       }
    }


    //Metodo BuscarTodos
    public List<Docente> listarDocentes()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo BuscarUnoPorId


    //Metodo  Modificar


    //Metodo  Eliminar
}
