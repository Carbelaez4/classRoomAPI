package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.repositorios.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Metodo buscarUnoPorId
    public Docente buscarDocentePorId(Integer id)throws Exception{
        try{
            Optional<Docente> docenteQueEstoyBuscando=this.repositorio.findById(id);
            if(docenteQueEstoyBuscando.isPresent()){
                return docenteQueEstoyBuscando.get();

            }else{
                throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  modificar
    public Docente modificarDocente(Integer id, Docente datosNuevosDocente)throws Exception{
    try{
        Optional<Docente>docenteQueEstoyBUscandoParaEditar=this.repositorio.findById(id);
        if(docenteQueEstoyBUscandoParaEditar.isPresent()){
          //Modificar ese docente
          docenteQueEstoyBUscandoParaEditar.get().setEspecilidad(datosNuevosDocente.getEspecialidad());
          //Guardo las modificaciones en la BD
           return this.repositorio.save(docenteQueEstoyBUscandoParaEditar.get());
        }else{
            throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
        }

    }catch (Exception error){
        throw new Exception(error.getMessage());
    }
    }

    //Metodo  eliminar
    public boolean eliminarDocente(Integer id)throws Exception{
        try{
            Optional<Docente>docenteQueBusco=this.repositorio.findById(id);
            if(docenteQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }
}
