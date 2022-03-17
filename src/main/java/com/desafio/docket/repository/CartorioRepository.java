package com.desafio.docket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.docket.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long> {

}
