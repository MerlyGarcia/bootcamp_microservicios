package com.bootcamp.databases.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	private static final Logger logger = Logger.getLogger(ConsultaController.class);
	
	@Autowired
	private ConsultaService consultaService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Consulta> registrar(@RequestBody Consulta c) {
		
		if(c.getFecha() == null) {
			c.setFecha(LocalDate.now());
		}
		logger.info("Registrar nueva consulta");
		try {
			consultaService.registrar(c);
			return ResponseEntity.ok(c);
		} catch (Exception e) {
			logger.error("No se pudo registrar la consulta");
			logger.debug(e);
			return ResponseEntity.badRequest().body(c);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Consulta> actualizar(@RequestBody Consulta c) throws Exception {
		if(c.getFecha() == null) {
			c.setFecha(LocalDate.now());
		}
		consultaService.registrar(c);
		return ResponseEntity.ok(c);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Consulta> buscar(@RequestParam("id") int id) throws Exception {
		
		Consulta consultaBD = consultaService.buscar(id);
		
		if(consultaBD != null) {
			return ResponseEntity.ok(consultaBD);
		}

		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Consulta>> listar() throws Exception {
		return ResponseEntity.ok(consultaService.listarTodos());
	}
	
	@GetMapping("/listarPaciente/{id}")
	public ResponseEntity<List<Consulta>> listarPorPaciente(@PathVariable Integer id) throws Exception {
		List<Consulta> lista = consultaService.listarPorPaciente(id);
		
		if(lista.size() > 0) 
			return ResponseEntity.ok(lista);
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listarMedico/{id}")
	public ResponseEntity<List<Consulta>> listarPorMedico(@PathVariable Integer id) throws Exception {
		List<Consulta> lista = consultaService.listarPorMedico(id);
		
		if(lista.size() > 0) 
			return ResponseEntity.ok(lista);
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/listarEspecialidad/{id}")
	public ResponseEntity<List<Consulta>> listarPorEspecialidad(@PathVariable Integer id) throws Exception {
		List<Consulta> lista = consultaService.listarPorEspecialidad(id);
		
		if(lista.size() > 0) 
			return ResponseEntity.ok(lista);
		
		return ResponseEntity.notFound().build();
	}

}
