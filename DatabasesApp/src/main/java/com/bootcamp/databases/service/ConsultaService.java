package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Consulta;

public interface ConsultaService {

	public void registrar(Consulta c) throws Exception;
	
	public void modificar(Consulta c) throws Exception;
	
	public Consulta buscar(int id) throws Exception;
	
	public List<Consulta> listarTodos() throws Exception;
	
	public List<Consulta> listarPorPaciente(Integer id) throws Exception;
	
	public List<Consulta> listarPorMedico(Integer id) throws Exception;
	
	public List<Consulta> listarPorEspecialidad(Integer id) throws Exception;
}
