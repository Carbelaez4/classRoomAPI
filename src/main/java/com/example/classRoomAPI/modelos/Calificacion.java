package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="calificaciones")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_calificacion")
    private Integer id;

    @Column(name ="nota", unique = false, nullable = false)
    private Double nota;
    @Column(name ="fecha_evaluacion", unique = false, nullable = false)
    private LocalDate fechaEvaluacion;

    //Creando relacion Estudiante (* a 1)
    @ManyToOne
    @JoinColumn(name="fk_estudiante",referencedColumnName = "id")
    @JsonBackReference
    private Estudiante estudiante;

    //Creando relacion materia (* a 1)
    @ManyToOne
    @JoinColumn(name="fk_materia",referencedColumnName = "id")
    @JsonBackReference
    private Materia materia;

    public Calificacion() {
    }

    public Calificacion(Integer id, Double nota, LocalDate fechaEvalucion) {
        this.id = id;
        this.nota = nota;
        this.fechaEvalucion = fechaEvalucion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
