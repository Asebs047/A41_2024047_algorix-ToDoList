package com.algorix.algorix_toDoList.persistence.crud;

import com.algorix.algorix_toDoList.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioCrud extends JpaRepository<Usuario, Integer> {
}
