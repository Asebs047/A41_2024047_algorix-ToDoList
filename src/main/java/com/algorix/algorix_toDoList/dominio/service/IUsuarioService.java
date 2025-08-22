package com.algorix.algorix_toDoList.dominio.service;

import com.algorix.algorix_toDoList.persistence.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    Usuario buscarUsuarioPorId(Integer id);
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
}
