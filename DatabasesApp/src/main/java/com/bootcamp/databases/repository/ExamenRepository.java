package com.bootcamp.databases.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.databases.model.Examen;

public interface ExamenRepository extends MongoRepository<Examen, String>{

}
