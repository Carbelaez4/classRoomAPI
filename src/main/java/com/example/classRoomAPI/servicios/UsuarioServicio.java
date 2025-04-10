package com.example.classRoomAPI.servicios;

import com.example.classRoomAPI.modelos.Docente;
import com.example.classRoomAPI.modelos.Usuario;
import com.example.classRoomAPI.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
