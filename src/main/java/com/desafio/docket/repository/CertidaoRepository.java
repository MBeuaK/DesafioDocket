package com.desafio.docket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.docket.model.Certidao;

@Repository
public interface CertidaoRepository extends JpaRepository<Certidao, Long>{

}
