package com.algorix.algorix_toDoList.dominio.service;

import com.algorix.algorix_toDoList.persistence.crud.UsuarioCrud;
import com.algorix.algorix_toDoList.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        Usuario usuario = crud.findById(id).orElse(null);
        return usuario;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        crud.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {crud.delete(usuario);}
}
