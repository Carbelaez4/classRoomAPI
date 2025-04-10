package com.example.classRoomAPI.repositorios;

import com.example.classRoomAPI.modelos.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscripcionRepositorio extends JpaRepository<Inscripcion, Integer> {
}
