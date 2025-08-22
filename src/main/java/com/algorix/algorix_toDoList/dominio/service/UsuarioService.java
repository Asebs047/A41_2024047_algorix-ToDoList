package com.algorix.algorix_toDoList.dominio.service;

import com.algorix.algorix_toDoList.persistence.crud.UsuarioCrud;
import com.algorix.algorix_toDoList.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioCrud crud;

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = crud.findAll();
        return usuarios;
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        return null;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {

    }

    @Override
    public void eliminarUsuario(Usuario usuario) {

    }
}
