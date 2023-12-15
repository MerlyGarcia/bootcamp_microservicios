package com.bootcamp.databases.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.databases.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

	public List<Consulta> findByPaciente_IdPaciente(Integer id);
	
	public List<Consulta> findByMedico_IdMedico(Integer id);
	
	public List<Consulta> findByEspecialidad_IdEspecialidad(Integer id);
}
