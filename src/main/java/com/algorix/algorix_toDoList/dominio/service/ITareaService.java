package com.algorix.algorix_toDoList.dominio.service;

import com.algorix.algorix_toDoList.persistence.entity.Tarea;
import com.algorix.algorix_toDoList.persistence.entity.Usuario;

import java.util.List;

public interface ITareaService {
    List<Tarea> listarTareas();
    List<Tarea> filtrarTareas(String estado);
    void guardarTarea(Tarea tarea);
    void eliminarTarea(Tarea tarea);
    Tarea buscarTareaPorId(Integer id);

}
