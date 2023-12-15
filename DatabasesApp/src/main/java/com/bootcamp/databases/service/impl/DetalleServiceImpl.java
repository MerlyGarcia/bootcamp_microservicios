package com.bootcamp.databases.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.repository.DetalleRepository;
import com.bootcamp.databases.service.DetalleService;

@Service
public class DetalleServiceImpl implements DetalleService{

	@Autowired
	private DetalleRepository detalleRepository;
	
	@Override
	public void registrar(DetalleConsulta d) throws Exception {
		detalleRepository.save(d);
		
	}

	@Override
	public void modificar(DetalleConsulta d) throws Exception {
		detalleRepository.save(d);
		
	}

	@Override
	public DetalleConsulta buscar(String id) throws Exception {
		
		return detalleRepository.findById(id).orElse(new DetalleConsulta());
	}

	@Override
	public List<DetalleConsulta> listarTodos() throws Exception {
		return detalleRepository.findAll();
	}

	@Override
	public DetalleConsulta buscarPorConsulta(Integer id) throws Exception {
		return detalleRepository.findByIdConsulta(id);
	}

}
