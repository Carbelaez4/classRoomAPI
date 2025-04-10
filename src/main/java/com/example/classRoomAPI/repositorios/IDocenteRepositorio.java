package com.example.classRoomAPI.repositorios;


import com.example.classRoomAPI.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenteRepositorio extends JpaRepository<Docente,Integer> {
    //Si tengo consultas personalizadas deben ir en este espacio
}
