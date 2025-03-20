package com.example.classRoomAPI.modelos;

import java.time.LocalDate;

public class Docente {
    private Integer idDocente;
    private String especilidad;

    public Docente() {
    }

    public Docente(Integer idDocente, String especilidad) {
        this.idDocente = idDocente;
        this.especilidad = especilidad;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getEspecilidad() {
        return especilidad;
    }

    public void setEspecilidad(String especilidad) {
        this.especilidad = especilidad;
    }
}
