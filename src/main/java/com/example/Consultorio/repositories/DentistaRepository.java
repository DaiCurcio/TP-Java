package com.example.Consultorio.repositories;

import com.example.Consultorio.models.DentistaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // extiende de jpa q usa hibernate para mappear
public interface DentistaRepository extends JpaRepository<DentistaModel,Integer> {
}
