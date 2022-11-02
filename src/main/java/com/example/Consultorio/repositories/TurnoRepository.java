package com.example.Consultorio.repositories;

import com.example.Consultorio.models.TurnoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends CrudRepository<TurnoModel,Long> {

}
