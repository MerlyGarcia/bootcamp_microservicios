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

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.service.ExamenService;

@RestController
@RequestMapping("/examen")
public class ExamenController {
	
	private static final Logger logger = Logger.getLogger(ExamenController.class);
	
	@Autowired
	private ExamenService examenService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Examen> registrar(@RequestBody Examen examen) {
		logger.info("Registrar nuevo examen");
		try {
			examenService.registrar(examen);
			return ResponseEntity.ok(examen);
		} catch (Exception e) {
			logger.error("No se pudo registrar el examen");
			logger.debug(e);
			return ResponseEntity.badRequest().body(examen);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Examen> actualizar(@RequestBody Examen e) throws Exception {
		examenService.registrar(e);
		return ResponseEntity.ok(e);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Examen> buscar(@RequestParam("id") String id) throws Exception {
		
		Examen examenBD = examenService.buscar(id);
		
		if(examenBD != null) {
			return ResponseEntity.ok(examenBD);
		}

		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Examen>> listar() throws Exception {
		return ResponseEntity.ok(examenService.listarTodos());
	}

}
