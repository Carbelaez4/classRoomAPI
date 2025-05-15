package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="calificaciones")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    public Calificacion(Integer id, Double nota, LocalDate fechaEvalaucion) {
        this.id = id;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
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

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvalucion(LocalDate fechaEvalucion) {
        this.fechaEvaluacion = fechaEvalucion;
    }
}
