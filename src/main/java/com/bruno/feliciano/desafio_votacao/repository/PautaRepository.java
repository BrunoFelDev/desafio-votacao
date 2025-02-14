package com.bruno.feliciano.desafio_votacao.repository;

import com.bruno.feliciano.desafio_votacao.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {



}
