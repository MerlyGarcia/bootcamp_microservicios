package com.bootcamp.databases.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.databases.model.ConsultaExamen;

public interface ConsultaExamenRepository extends MongoRepository<ConsultaExamen, String>{

}
