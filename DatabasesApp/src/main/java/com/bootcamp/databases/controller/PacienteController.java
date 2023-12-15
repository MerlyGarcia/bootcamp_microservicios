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

import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	private static final Logger logger = Logger.getLogger(PacienteController.class);
	
	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Paciente> registrar(@RequestBody Paciente p) {
		logger.info("Registrar nuevo paciente");
		try {
			pacienteService.registrar(p);
			return ResponseEntity.ok(p);
		} catch (Exception e) {
			logger.error("No se pudo registrar el paciente");
			logger.debug(e);
			return ResponseEntity.badRequest().body(p);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Paciente> actualizar(@RequestBody Paciente p) throws Exception {
		pacienteService.registrar(p);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Paciente> buscar(@RequestParam("id") int id) throws Exception {
		
		Paciente pacienteBD = pacienteService.buscar(id);
		
		if(pacienteBD != null) {
			return ResponseEntity.ok(pacienteBD);
		}

		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Paciente>> listar() throws Exception {
		return ResponseEntity.ok(pacienteService.listarTodos());
	}

}
