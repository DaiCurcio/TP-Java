package com.example.Consultorio.repositories;

import com.example.Consultorio.models.TurnoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<TurnoModel,Integer> {

}
