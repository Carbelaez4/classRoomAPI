package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.modelos.Inscripcion;
import com.example.classRoomAPI.repositorios.IInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo buscarUnoPorId
    public Inscripcion buscarInscripcionPorId(Integer id)throws Exception{
        try{
            Optional<Inscripcion> inscripcionQueEstoyBuscando=this.repositorio.findById(id);
            if(inscripcionQueEstoyBuscando.isPresent()){
                return inscripcionQueEstoyBuscando.get();

            }else{
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  modificar
    public Inscripcion modificarInscripcion(Integer id, Inscripcion datosNuevosInscripcion)throws Exception{
        try{
            Optional<Inscripcion>inscripcionQueEstoyBUscandoParaEditar=this.repositorio.findById(id);
            if(inscripcionQueEstoyBUscandoParaEditar.isPresent()){
                //Modificar esa inscripcion
                inscripcionQueEstoyBUscandoParaEditar.get().setFechaInscripcion(datosNuevosInscripcion.getFechaInscripcion());
                //Guardo las modificaciones en la BD
                return this.repositorio.save(inscripcionQueEstoyBUscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO.getMensaje());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Metodo  eliminar
    public boolean eliminarInscripcion(Integer id)throws Exception{
        try{
            Optional<Inscripcion>inscripcionQueBusco=this.repositorio.findById(id);
            if(inscripcionQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }

}


