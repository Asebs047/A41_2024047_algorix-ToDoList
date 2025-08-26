package com.algorix.algorix_toDoList;

import com.algorix.algorix_toDoList.dominio.service.ITareaService;
import com.algorix.algorix_toDoList.dominio.service.IUsuarioService;
import com.algorix.algorix_toDoList.persistence.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AlgorixToDoListApplication implements CommandLineRunner {

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private ITareaService tareaService;

	private static final Logger logger = LoggerFactory.getLogger(AlgorixToDoListApplication.class);

	String sl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Lasciate ogne speranza, voi ch’intrate");
		SpringApplication.run(AlgorixToDoListApplication.class, args);
		logger.info("Cerrado la puerta a la esperanza");
	}

	@Override
	public void run(String... args) {
		toDoList();
	}

	private void toDoList() {
		logger.info("++++++++ Aplicacion manejo de Tareas ++++++++" + sl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			var opcion = mostrarMenuGeneral(consola);
			salir = ejecutarOpcionesGenerales(consola, opcion);
			logger.info(sl);
		}
	}

	private int mostrarMenuGeneral(Scanner consola) {
		logger.info("""
				*** Menú de opciones ***
				1. Usuarios
				2. Tareas
				3. Salir
				""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpcionesGenerales(Scanner consola, int opcion) {
		switch (opcion) {
			case 1 -> {
				var salir = false;
				while (!salir) {
					var opcionU = mostrarMenuUsuarios(consola);
					salir = ejecutarOpcionesUsuarios(consola, opcionU);
					logger.info(sl);
				}
			}
			case 2 -> {
				var salir = false;
				while (!salir) {
					// var opcionT = mostrarMenuTareas(consola);
					//salir = ejecutarOpcionesTareas(consola, opcionT);
					logger.info(sl);
				}
			}
			case 3 -> {
				logger.info("Saliendo de la aplicacion...");
				return true;
			}
			default -> logger.info("Opcion no valida");
		}
		return false;
	}

	private int mostrarMenuUsuarios(Scanner consola) {
		logger.info("""
				*** Menu de Usuarios ***
				1. Listar Usuarios
				2. Buscar Usuario por ID
				3. Crear Usuario
				4. Editar Usuario
				5. Eliminar Usuari 
				0. Salir 
				""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpcionesUsuarios(Scanner consola, int opcion) {
		switch (opcion) {
			case 1 -> {
				logger.info(sl + "*** Listado de Usuarios ***" + sl);
				List<Usuario> usuarios = usuarioService.listarUsuarios();
				usuarios.forEach(usuario -> logger.info(usuario.toString() + sl));
			}
			case 2 -> {
				logger.info("Ingrese el ID del usuario a buscar:");
				var id = Integer.parseInt(consola.nextLine());
				Usuario usuario = usuarioService.buscarUsuarioPorId(id);
				if (usuario != null) {
					logger.info("Usuario encontrado: " + sl + usuario + sl);
				} else {
					logger.info("Usuario no encontrado con ID: " + sl + id + sl);
				}
			}
			case 3 -> {
				logger.info("Ingrese el nombre:");
				var nombre = consola.nextLine();
				logger.info("Ingrese el apellido:");
				var apellido = consola.nextLine();
				logger.info("Ingrese el telefono:");
				var telefono = consola.nextLine();
				logger.info("Ingrese el email:");
				var email = consola.nextLine();
				logger.info("Ingrese la contraseña:");
				var pass = consola.nextLine();
				var usuario = new com.algorix.algorix_toDoList.persistence.entity.Usuario();
				usuario.setNombre(nombre);
				usuario.setApellido(apellido);
				usuario.setTelefono(telefono);
				usuario.setCorreo(email);
				usuario.setPass(pass);
				usuarioService.guardarUsuario(usuario);
				logger.info("Usuario creado: " + sl + usuario + sl);
			}
			case 4 -> {
				logger.info("Ingrese el ID del usuario a editar:");
				var id = Integer.parseInt(consola.nextLine());
				var usuario = usuarioService.buscarUsuarioPorId(id);
				if (usuario != null) {
					logger.info("Ingrese el nuevo nombre del usuario (actual: " + usuario.getNombre() + "):");
					var nombre = consola.nextLine();
					logger.info("Ingrese el nuevo email del usuario (actual: " + usuario.getCorreo() + "):");
					var email = consola.nextLine();
					usuario.setNombre(nombre.isEmpty() ? usuario.getNombre() : nombre);
					usuario.setCorreo(email.isEmpty() ? usuario.getCorreo() : email);
					usuarioService.guardarUsuario(usuario);
					logger.info("Usuario actualizado: " + usuario);
				} else {
					logger.info("Usuario no encontrado con ID: " + id);
				}
			}
			case 5 -> {
				logger.info("Ingrese el ID del usuario a eliminar:");
				var id = Integer.parseInt(consola.nextLine());
				var usuario = usuarioService.buscarUsuarioPorId(id);
				if (usuario != null) {
					usuarioService.eliminarUsuario(usuario);
					logger.info("Usuario eliminado con ID: " + id);
				}

			}
		}
        return false;
    }
}