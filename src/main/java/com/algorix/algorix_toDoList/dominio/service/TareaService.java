package com.algorix.algorix_toDoList.dominio.service;

import com.algorix.algorix_toDoList.persistence.crud.TareaCrud;
import com.algorix.algorix_toDoList.persistence.entity.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService implements ITareaService{

    @Autowired
    private TareaCrud crud;

    @Override
    public List<Tarea> listarTareas() {
        List<Tarea> tareas = crud.findAll();
        return tareas;
    }

    @Override
    public List<Tarea> filtrarTareas(String estado) {
        List<Tarea> tareasP = new ArrayList<>();
        for (Tarea tareaP : crud.findAll()) {
            if (tareaP.getEstado().equals(estado)) {
                tareasP.add(tareaP);
            }
        }
        return tareasP;
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        crud.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        crud.delete(tarea);
    }

    @Override
    public Tarea buscarTareaPorId(Integer id) {
        Tarea tarea = crud.findById(id).orElse(null);
        return tarea;
    }


}
