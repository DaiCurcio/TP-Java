package com.example.Consultorio.repositories;

import com.example.Consultorio.models.PacienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<PacienteModel,Long> {
}
