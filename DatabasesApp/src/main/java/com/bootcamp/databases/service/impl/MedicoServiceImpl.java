package com.bootcamp.databases.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.repository.MedicoRepository;
import com.bootcamp.databases.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository repo;
	
	@Override
	public void registrar(Medico m) throws Exception {
		repo.save(m);
		
	}

	@Override
	public void modificar(Medico m) throws Exception {
		repo.save(m);
		
	}

	@Override
	public Medico buscar(int id) throws Exception {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Medico> listarTodos() throws Exception {
		return repo.findAll();
	}

}
