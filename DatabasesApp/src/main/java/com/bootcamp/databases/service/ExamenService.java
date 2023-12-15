package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Examen;

public interface ExamenService {

	public void registrar(Examen e) throws Exception;
	
	public void modificar(Examen e) throws Exception;
	
	public Examen buscar(String id) throws Exception;
	
	public List<Examen> listarTodos() throws Exception;
}
