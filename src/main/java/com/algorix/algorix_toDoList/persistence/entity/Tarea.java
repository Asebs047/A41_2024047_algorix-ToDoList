package com.algorix.algorix_toDoList.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity(name = "Tareas")
@Data //genera los setter y getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tarea;
    private String titulo;
    private String descripcion;
    private LocalDate fecha_limite;
    private String estado;
    private Integer id_usuario;
}
