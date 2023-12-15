package com.bootcamp.databases.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "consulta_examen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsultaExamen {

	@Id
	private String id;
	
	@Column(name = "idExamen", nullable = false, length = 100)
	private String idExamen;
	@Column(name = "idConsulta", nullable = false, length = 250)
	private int idConsulta;

}
