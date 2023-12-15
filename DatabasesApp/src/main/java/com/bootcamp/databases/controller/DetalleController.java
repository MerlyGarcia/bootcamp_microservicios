package com.bootcamp.databases.controller;

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
import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.model.dto.DetalleConsultaDto;
import com.bootcamp.databases.service.ConsultaService;
import com.bootcamp.databases.service.DetalleService;

@RestController
@RequestMapping("/detalle")
public class DetalleController {
	
	private static final Logger logger = Logger.getLogger(DetalleController.class);
	
	@Autowired
	private DetalleService detalleService;
	
	@Autowired
	private ConsultaService consultaService;
	
	@PostMapping("/nuevo")
	public ResponseEntity<DetalleConsulta> registrar(@RequestBody DetalleConsulta d) {
		logger.info("Registrar nuevo detalle de Consulta");
		try {
			detalleService.registrar(d);
			return ResponseEntity.ok(d);
		} catch (Exception e) {
			logger.error("No se pudo registrar el médico");
			logger.debug(e);
			return ResponseEntity.badRequest().body(d);
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<DetalleConsulta> actualizar(@RequestBody DetalleConsulta d) throws Exception {
		detalleService.registrar(d);
		return ResponseEntity.ok(d);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<DetalleConsulta> buscar(@RequestParam("id") String id) throws Exception {
		
		DetalleConsulta detalleConsultaBD = detalleService.buscar(id);
		
		if(detalleConsultaBD != null) {
			return ResponseEntity.ok(detalleConsultaBD);
		}

		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<DetalleConsulta>> listar() throws Exception {
		return ResponseEntity.ok(detalleService.listarTodos());
	}
	
	@GetMapping("/listarPorConsulta/{id}")
	public ResponseEntity<DetalleConsultaDto> listarPorConsulta(@PathVariable Integer id) throws Exception {
		
		Consulta consulta = consultaService.buscar(id);
		
		if(consulta == null ) {
			return ResponseEntity.notFound().build();
		}
		
		DetalleConsulta detalleConsulta = detalleService.buscarPorConsulta(id);
		
		DetalleConsultaDto response = new DetalleConsultaDto(detalleConsulta, consulta);
		
		return ResponseEntity.ok(response);
	}

}
