package com.bruno.feliciano.desafio_votacao.service;

import com.bruno.feliciano.desafio_votacao.dto.NovaPautaDTO;
import com.bruno.feliciano.desafio_votacao.entity.Pauta;
import com.bruno.feliciano.desafio_votacao.repository.PautaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PautaService {
    private final PautaRepository pautaRepository;
    public Pauta criarPauta(NovaPautaDTO dto) {
        return pautaRepository.save(
                new Pauta(
                        null,
                        dto.getTitulo(),
                        dto.getDescricao(),
                        LocalDateTime.now()));
    }
}