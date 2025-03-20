package com.example.classRoomAPI.modelos;

import com.example.classRoomAPI.ayudas.TipoUsuario;

import java.time.LocalDate;

public class Estudiante {
    private Integer idEstudiante;
    private Integer  grado;
    private LocalDate fechaNacimiento;
    private String direccion;


    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, Integer grado, LocalDate fechaNacimiento, String direccion) {
        this.idEstudiante = idEstudiante;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
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
