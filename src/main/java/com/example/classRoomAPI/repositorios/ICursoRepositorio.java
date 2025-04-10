package com.example.classRoomAPI.repositorios;

import com.example.classRoomAPI.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository<Curso,Integer> {
}



