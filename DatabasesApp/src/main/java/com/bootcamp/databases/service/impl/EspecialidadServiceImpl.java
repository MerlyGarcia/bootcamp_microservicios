package com.bootcamp.databases.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.repository.EspecialidadRepository;
import com.bootcamp.databases.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public void registrar(Especialidad e) throws Exception {
		especialidadRepository.save(e);
	}

	@Override
	public void modificar(Especialidad e) throws Exception {
		especialidadRepository.save(e);
		
	}

	@Override
	public Especialidad buscar(int id) throws Exception {
		return especialidadRepository.findById(id).orElse(null);
	}

	@Override
	public List<Especialidad> listarTodos() throws Exception {
		return especialidadRepository.findAll();
	}

}
