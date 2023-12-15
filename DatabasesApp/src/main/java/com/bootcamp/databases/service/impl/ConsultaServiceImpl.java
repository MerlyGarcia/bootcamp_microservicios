package com.bootcamp.databases.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.repository.ConsultaRepository;
import com.bootcamp.databases.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Override
	public void registrar(Consulta c) throws Exception {
		consultaRepository.save(c);
	}

	@Override
	public void modificar(Consulta c) throws Exception {
		consultaRepository.save(c);
	}

	@Override
	public Consulta buscar(int id) throws Exception {
		return consultaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Consulta> listarTodos() throws Exception {
		return consultaRepository.findAll();
	}

	@Override
	public List<Consulta> listarPorPaciente(Integer id) throws Exception {
		return consultaRepository.findByPaciente_IdPaciente(id);
	}

	@Override
	public List<Consulta> listarPorMedico(Integer id) throws Exception {
		return consultaRepository.findByMedico_IdMedico(id);
	}

	@Override
	public List<Consulta> listarPorEspecialidad(Integer id) throws Exception {
		return consultaRepository.findByEspecialidad_IdEspecialidad(id);
	}

}
