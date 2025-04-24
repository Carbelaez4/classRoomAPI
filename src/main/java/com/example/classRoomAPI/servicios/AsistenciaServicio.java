package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Asistencia;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    //Metodo buscarUnoPorId
    public Asistencia buscarAsistenciaPorId(Integer id)throws Exception{
        try{
            Optional<Asistencia> asistenciaQueEstoyBuscando=this.repositorio.findById(id);
            if(asistenciaQueEstoyBuscando.isPresent()){
                return asistenciaQueEstoyBuscando.get();

            }else{
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Metodo  modificar
    public Asistencia modificarAsistencia(Integer id, Asistencia datosNuevosAsistencia)throws Exception{
        try{
            Optional<Asistencia>asistenciaQueEstoyBUscandoParaEditar=this.repositorio.findById(id);
            if(asistenciaQueEstoyBUscandoParaEditar.isPresent()){
                //Modificar esa asistencia
                asistenciaQueEstoyBUscandoParaEditar.get().setFecha(datosNuevosAsistencia.getFecha());
                //Guardo las modificaciones en la BD
                return this.repositorio.save(asistenciaQueEstoyBUscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  eliminar
    public boolean eliminarAsistencia(Integer id)throws Exception{
        try{
            Optional<Asistencia>asistenciaQueBusco=this.repositorio.findById(id);
            if(asistenciaQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }


}
