package com.bootcamp.databases.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.repository.ConsultaExamenRepository;
import com.bootcamp.databases.service.ConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService{

	@Autowired
	private ConsultaExamenRepository consultaExamenRepository;
	
	@Override
	public void registrar(ConsultaExamen c) throws Exception {
		consultaExamenRepository.save(c);
		
	}

	@Override
	public void modificar(ConsultaExamen c) throws Exception {
		consultaExamenRepository.save(c);
		
	}

	@Override
	public ConsultaExamen buscar(String id) throws Exception {
		return consultaExamenRepository.findById(id).orElse(null);
	}

	@Override
	public List<ConsultaExamen> listarTodos() throws Exception {
		return consultaExamenRepository.findAll();
	}

}
