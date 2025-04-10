package com.example.classRoomAPI.repositorios;

import com.example.classRoomAPI.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepositorio extends JpaRepository<Estudiante, Integer> {
}


