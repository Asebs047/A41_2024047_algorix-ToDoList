package com.algorix.algorix_toDoList.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Usuarios")
@Data //genera los setter y getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    @Column
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String pass;
}
