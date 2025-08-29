package com.algorix.algorix_toDoList.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(length = 64)
    private String nombre;

    @Column(length = 64)
    private String apellido;

    @Column(length = 16)
    private String telefono;

    @Column(length = 128)
    private String correo;

    @Column(length = 32)
    private String pass;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas;
}
