package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.modelos.Materia;
import com.example.classRoomAPI.repositorios.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo buscarUnoPorId
    public Materia buscarMateriaPorId(Integer id)throws Exception{
        try{
            Optional<Materia> materiaQueEstoyBuscando=this.repositorio.findById(id);
            if(materiaQueEstoyBuscando.isPresent()){
                return materiaQueEstoyBuscando.get();

            }else{
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADOA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  modificar
    public Materia modificarMateria(Integer id, Materia datosNuevosMateria)throws Exception{
        try{
            Optional<Materia>materiaQueEstoyBuscandoParaEditar=this.repositorio.findById(id);
            if(materiaQueEstoyBuscandoParaEditar.isPresent()){
                //Modificar esa materia
                materiaQueEstoyBuscandoParaEditar.get().setNombre(datosNuevosMateria.getNombre());
                //Guardo las modificaciones en la BD
                return this.repositorio.save(materiaQueEstoyBuscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADOA.getMensaje());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Metodo  eliminar
    public boolean eliminarMateria(Integer id)throws Exception{
        try{
            Optional<Materia>materiaQueBusco=this.repositorio.findById(id);
            if(materiaQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADOA.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }

}
