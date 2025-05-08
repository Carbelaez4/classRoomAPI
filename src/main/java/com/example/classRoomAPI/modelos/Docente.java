package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity

public class Docente {

    private Integer id;
    private String especilidad;

   //Creando relacion (1 a *)
   @OneToMany(mappedBy = "docente")
   @JsonManagedReference
    private List<Curso> cursos;

    public Docente() {
    }

    public Docente(Integer id, String especilidad) {
        this.id = id;
        this.especilidad = especilidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecilidad() {
        return especilidad;
    }

    public void setEspecilidad(String especilidad) {
        this.especilidad = especilidad;
    }
}
