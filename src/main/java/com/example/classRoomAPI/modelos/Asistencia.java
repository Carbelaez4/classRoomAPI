package com.example.classRoomAPI.modelos;
import com.example.classRoomAPI.ayudas.Estado;
import java.time.LocalDate;

public class Asistencia {
    private Integer idAsistencia;
    private LocalDate fecha;
    private Estado estado;

    public Asistencia() {
    }

    public Asistencia(Integer idAsistencia, LocalDate fecha, Estado estado) {
        this.idAsistencia = idAsistencia;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
