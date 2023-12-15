package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Especialidad;

public interface EspecialidadService {
	
	public void registrar(Especialidad e) throws Exception;
	
	public void modificar(Especialidad e) throws Exception;
	
	public Especialidad buscar(int id) throws Exception;
	
	public List<Especialidad> listarTodos() throws Exception;
}
