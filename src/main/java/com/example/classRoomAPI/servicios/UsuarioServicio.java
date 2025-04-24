package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.ayudas.MensajesAPI;
import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.modelos.Usuario;
import com.example.classRoomAPI.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio repositorio;

    //Metodo Guardar
    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception{
        try{
            return this.repositorio.save(datosUsuario);
        }catch (Exception error){
           throw new Exception();
        }
    }

    //Metodo BuscarTodos
    public List<Usuario> listarUsuarios()throws Exception{
        try{
            return this.repositorio.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }

    //Metodo buscarUnoPorId
    public Usuario buscarusuarioPorId(Integer id)throws Exception{
        try{
            Optional<Usuario> usuarioQueEstoyBuscando=this.repositorio.findById(id);
            if(usuarioQueEstoyBuscando.isPresent()){
                return usuarioQueEstoyBuscando.get();

            }else{
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADOA.getMensaje());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo  modificar
    public Usuario modificarUsuario(Integer id, Usuario datosNuevosUsuario)throws Exception{
        try{
            Optional<Usuario>usuarioQueEstoyBUscandoParaEditar=this.repositorio.findById(id);
            if(usuarioQueEstoyBUscandoParaEditar.isPresent()){
                //Modificar ese usuario
                usuarioQueEstoyBUscandoParaEditar.get().setCorreoElectronico(datosNuevosUsuario.getCorreoElectronico());
                //Guardo las modificaciones en la BD
                return this.repositorio.save(usuarioQueEstoyBUscandoParaEditar.get());
            }else{
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADOA.getMensaje());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Metodo  eliminar
    public boolean eliminarUsuario(Integer id)throws Exception{
        try{
            Optional<Usuario>usuarioQueBusco=this.repositorio.findById(id);
            if(usuarioQueBusco.isPresent()){
                //Lo elimino
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADOA.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
    }
}
