package com.example.classRoomAPI.modelos;
import com.example.classRoomAPI.ayudas.Estado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table (name= "asistencias")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Id_asistencia")
    private Integer id;

    @Column(name="fecha",unique = false, nullable = false)
    private LocalDate fecha;
    @Column(name="estado",unique = false,nullable = false)
    private Estado estado;

    //Creando relacion Estudiante (* a 1)
    @ManyToOne
    @JoinColumn(name="fk_estudiante",referencedColumnName = "id")
    @JsonBackReference
    private Estudiante estudiante;

    //Creando relacion Curso (* a 1)
    @ManyToOne
    @JoinColumn(name="fk_curso", referencedColumnName = "id")
    @JsonBackReference
    private Curso curso;

    public Asistencia() {
    }

    public Asistencia(Integer id, LocalDate fecha, Estado estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = id;
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
