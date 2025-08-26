package com.algorix.algorix_toDoList;

import com.algorix.algorix_toDoList.dominio.service.ITareaService;
import com.algorix.algorix_toDoList.dominio.service.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AlgorixToDoListApplication implements CommandLineRunner {

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private ITareaService tareaService;

	private static final Logger logger = LoggerFactory.getLogger(AlgorixToDoListApplication.class);

	String sl =System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Lasciate ogne speranza, voi ch’intrate");
		SpringApplication.run(AlgorixToDoListApplication.class, args);
		logger.info("Cerrado la puerta a la esperanza");
	}

	@Override
	public void run(String... args){
		toDoList();
	}

	private void toDoList(){
		logger.info("++++++++ Aplicacion manejo de Tareas ++++++++"+sl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			var opcion = mostrarMenuGeneral(consola);
			salir = ejecutarOpcionesGenerales(consola, opcion);
			logger.info(sl);
		}
	}

	private int mostrarMenuGeneral(Scanner consola){
		logger.info("""
				*** Menú de opciones ****
				1. Usuarios
				2. Tareas
				3. Salir
				""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpcionesGenerales(Scanner consola, int opcion){
		switch (opcion){
			case 1 -> {
				var salir = false;
				while (!salir){
					var opcionU = mostrarMenuUsuarios(consola);
					salir = ejecutarOpcionesUsuarios(consola, opcionU);
					logger.info(sl);
				}
			}
			case 2 -> {
				var salir = false;
				while (!salir){
					var opcionT = mostrarMenuTareas(consola);
					salir = ejecutarOpcionesTareas(consola, opcionT);
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



}
