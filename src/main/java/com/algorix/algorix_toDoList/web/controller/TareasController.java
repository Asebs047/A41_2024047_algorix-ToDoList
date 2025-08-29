package com.algorix.algorix_toDoList.web.controller;

import com.algorix.algorix_toDoList.dominio.service.ITareaService;
import com.algorix.algorix_toDoList.persistence.entity.Tarea;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class TareasController {

    @Autowired
    ITareaService tareaService;
    private List<Tarea> tareas;
    private Tarea tareaSeleccionada;
    private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.tareas = tareaService.listarTareas();
        this.tareas.forEach(tarea -> logger.info(tarea.toString()));
    }

    public void agregarTarea(){
        this.tareaSeleccionada = new Tarea();
    }

    public void guardarTarea){
        if (this.tareaSeleccionada.getId_tarea() == null){
            this.tareaService.guardarTarea(this.tareaSeleccionada);
            this.tareas.add(this.tareaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarea agregada"));
        }
    }
}
