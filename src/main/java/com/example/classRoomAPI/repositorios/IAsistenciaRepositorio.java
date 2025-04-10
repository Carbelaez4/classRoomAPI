package com.example.classRoomAPI.repositorios;

import com.example.classRoomAPI.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsistenciaRepositorio extends JpaRepository<Asistencia, Integer> {
}


