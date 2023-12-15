package com.bootcamp.databases.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.service.ConsultaExamenService;

@RestController
@RequestMapping("/consulta_examen")
public class ConsultaExamenController {
	
	private static final Logger logger = Logger.getLogger(ConsultaExamenController.class);
	
	@Autowired
	private ConsultaExamenService consultaExamenService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<ConsultaExamen> registrar(@RequestBody ConsultaExamen c) {
		logger.info("Registrando examenes para la consulta");
		try {
			consultaExamenService.registrar(c);
			return ResponseEntity.ok(c);
		} catch (Exception e) {
			logger.error("No se pudo registrar examenes para la consulta");
			logger.debug(e);
			return ResponseEntity.badRequest().body(c);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<ConsultaExamen> actualizar(@RequestBody ConsultaExamen c) throws Exception {
		consultaExamenService.registrar(c);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<ConsultaExamen> buscar(@RequestParam("id") String id) throws Exception {
		
		ConsultaExamen consultaExamenBD = consultaExamenService.buscar(id);
		
		if(consultaExamenBD != null) {
			return ResponseEntity.ok(consultaExamenBD);
		}

		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<ConsultaExamen>> listar() throws Exception {
		return ResponseEntity.ok(consultaExamenService.listarTodos());
	}

}
