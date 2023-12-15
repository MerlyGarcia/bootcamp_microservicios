package com.bootcamp.databases.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "examen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Examen {
	
	@Id
	private String id;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	@Column(name = "descripcion", nullable = false, length = 250)
	private String descripcion;

}
