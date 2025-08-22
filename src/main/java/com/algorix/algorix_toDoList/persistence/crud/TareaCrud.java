package com.algorix.algorix_toDoList.persistence.crud;

import com.algorix.algorix_toDoList.persistence.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaCrud extends JpaRepository<Tarea, Integer> {
}
