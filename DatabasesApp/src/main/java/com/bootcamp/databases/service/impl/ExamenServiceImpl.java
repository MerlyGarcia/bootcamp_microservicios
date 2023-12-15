package com.bootcamp.databases.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.repository.ExamenRepository;
import com.bootcamp.databases.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService{

	@Autowired
	private ExamenRepository examenRepository;
	
	@Override
	public void registrar(Examen e) throws Exception {
		examenRepository.save(e);
		
	}

	@Override
	public void modificar(Examen e) throws Exception {
		examenRepository.save(e);
		
	}

	@Override
	public Examen buscar(String id) throws Exception {
		return examenRepository.findById(id).orElse(null);
	}

	@Override
	public List<Examen> listarTodos() throws Exception {
		return examenRepository.findAll();
	}

}
