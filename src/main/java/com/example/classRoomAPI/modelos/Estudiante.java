package com.example.classRoomAPI.modelos;

import com.example.classRoomAPI.ayudas.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity

public class Estudiante {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer  grado;
    private LocalDate fechaNacimiento;
    private String direccion;

    //Creando relacion Calificacion(1 a *)
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    //Creando relacion Asistencia (1 a *)
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Asistencia> asistencias;

    public Estudiante() {
    }

    public Estudiante(Integer id, Integer grado, LocalDate fechaNacimiento, String direccion) {
        this.id = id;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
