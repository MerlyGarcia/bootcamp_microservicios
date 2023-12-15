package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.DetalleConsulta;

public interface DetalleService {

	public void registrar(DetalleConsulta d) throws Exception;
	
	public void modificar(DetalleConsulta d) throws Exception;
	
	public DetalleConsulta buscar(String id) throws Exception;
	
	public DetalleConsulta buscarPorConsulta(Integer id) throws Exception;
	
	public List<DetalleConsulta> listarTodos() throws Exception;
}
