package com.example.classRoomAPI.modelos;

import java.time.LocalDate;

public class Calificacion {
    private Integer idCalificacion;
    private Double nota;
    private LocalDate fechaEvalucion;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion, Double nota, LocalDate fechaEvalucion) {
        this.idCalificacion = idCalificacion;
        this.nota = nota;
        this.fechaEvalucion = fechaEvalucion;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public LocalDate getFechaEvalucion() {
        return fechaEvalucion;
    }

    public void setFechaEvalucion(LocalDate fechaEvalucion) {
        this.fechaEvalucion = fechaEvalucion;
    }
}
