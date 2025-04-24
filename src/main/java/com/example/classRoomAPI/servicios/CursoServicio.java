package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Curso;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo buscarUnoPorId
    public Curso buscarCursoPorId(Integer id)throws Exception{
        try{
            Optional<Curso> cursoQueEstoyBuscando=this.repositorio.findById(id);
            if(cursoQueEstoyBuscando.isPresent()){
                return cursoQueEstoyBuscando.get();

            }else{
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  modificar
    public Curso modificarCurso(Integer id, Curso datosNuevosCurso)throws Exception{
        try{
            Optional<Curso>cursoQueEstoyBUscandoParaEditar=this.repositorio.findById(id);
            if(cursoQueEstoyBUscandoParaEditar.isPresent()){
                //Modificar ese curso
                cursoQueEstoyBUscandoParaEditar.get().setNombre(datosNuevosCurso.getNombre());
                //Guardo las modificaciones en la BD
                return this.repositorio.save(cursoQueEstoyBUscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  eliminar
    public boolean eliminarCurso(Integer id)throws Exception{
        try{
            Optional<Curso>cursoQueBusco=this.repositorio.findById(id);
            if(cursoQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }
}


