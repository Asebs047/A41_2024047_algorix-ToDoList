package com.algorix.algorix_toDoList.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tarea;

    private String titulo;

    @Column(columnDefinition = "TEXT") // corresponde al tipo TEXT en MySQL
    private String descripcion;

    private LocalDate fecha_limite;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    public enum Estado {
        pendiente,
        teminada
    }
}
