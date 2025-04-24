package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Calificacion;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    //Metodo buscarUnoPorId
    public Calificacion buscarCalificacionPorId(Integer id)throws Exception{
        try{
            Optional<Calificacion> calificacionQueEstoyBuscando=this.repositorio.findById(id);
            if(calificacionQueEstoyBuscando.isPresent()){
                return calificacionQueEstoyBuscando.get();

            }else{
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Metodo  modificar
    public Calificacion modificarCalificacion(Integer id, Calificacion datosNuevosCalificacion)throws Exception {
        try {
            Optional<Calificacion> calificacionQueEstoyBUscandoParaEditar = this.repositorio.findById(id);
            if (calificacionQueEstoyBUscandoParaEditar.isPresent()) {
                //Modificar esA calificacion
                calificacionQueEstoyBUscandoParaEditar.get().setNota(datosNuevosCalificacion.getNota());
                //Guardo las modificaciones en la BD
                return this.repositorio.save(calificacionQueEstoyBUscandoParaEditar.get());
            } else {
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
            }
        }
    //Metodo  eliminar
    public boolean eliminarCalificacion(Integer id)throws Exception{
        try{
            Optional<Calificacion>calificacionQueBusco=this.repositorio.findById(id);
            if(calificacionQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADA.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }

}




