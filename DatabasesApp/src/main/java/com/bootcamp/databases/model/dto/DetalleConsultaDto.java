package com.bootcamp.databases.model.dto;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.DetalleConsulta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleConsultaDto {

	private DetalleConsulta detalleConsulta;
	
	private Consulta consulta;
}
