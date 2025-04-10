package com.example.classRoomAPI.repositorios;

import com.example.classRoomAPI.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface IMateriaRepositorio extends JpaRepository<Materia, Integer> {
}

