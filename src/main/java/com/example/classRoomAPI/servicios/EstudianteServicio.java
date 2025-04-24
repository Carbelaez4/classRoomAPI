package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.modelos.Estudiante;
import com.example.classRoomAPI.repositorios.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo buscarUnoPorId
    public Estudiante buscarEstudiantePorId(Integer id)throws Exception{
        try{
            Optional<Estudiante> estudianteQueEstoyBuscando=this.repositorio.findById(id);
            if(estudianteQueEstoyBuscando.isPresent()){
                return estudianteQueEstoyBuscando.get();

            }else{
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  modificar
    public Estudiante modificarEstudiante(Integer id, Estudiante datosNuevosEstudiante)throws Exception{
        try{
            Optional<Estudiante>estudianteQueEstoyBUscandoParaEditar=this.repositorio.findById(id);
            if(estudianteQueEstoyBUscandoParaEditar.isPresent()){
                //Modificar ese estudiante
                estudianteQueEstoyBUscandoParaEditar.get().setGrado(datosNuevosEstudiante.getGrado());
                //Guardo las modificaciones en la BD
                return this.repositorio.save(estudianteQueEstoyBUscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  eliminar
    public boolean eliminarEstudiante(Integer id)throws Exception{
        try{
            Optional<Estudiante>estudianteQueBusco=this.repositorio.findById(id);
            if(estudianteQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }
}
