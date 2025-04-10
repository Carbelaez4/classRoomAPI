package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;
@Entity
public class Materia {
    private Integer idMateria;
    private String nombre;

    //Creando relacion 1 a *
    @OneToMany(mappedBy = "materia")
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    public Materia() {
    }

    public Materia(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
