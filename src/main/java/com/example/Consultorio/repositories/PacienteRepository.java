package com.example.Consultorio.repositories;

import com.example.Consultorio.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {
}
