package com.example.Consultorio.repositories;

import com.example.Consultorio.models.DentistaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends CrudRepository<DentistaModel,Long> {
}
