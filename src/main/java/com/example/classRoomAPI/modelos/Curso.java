package com.example.classRoomAPI.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_curso")
    private Integer id;

    @Column(name ="nombre",length = 100, unique = false, nullable = false)
    private String nombre;

    //Creando relacion docente (* a 1)
    @ManyToOne
    @JoinColumn(name="fk_docente",referencedColumnName = "id")
    @JsonBackReference
    private Docente docente;

    //Creando relacion Asistencia(1 a *)
    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Curso> cursos;

    public Curso() {
    }

    public Curso(Integer id, String nombre) {
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
