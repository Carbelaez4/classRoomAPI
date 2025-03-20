package com.example.classRoomAPI.modelos;

import java.time.LocalDate;

public class Inscripcion {
    private Integer idInscripcion;
    private LocalDate fechaInscripcion;

    public Inscripcion() {
    }

    public Inscripcion(Integer idInscripcion, LocalDate fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
