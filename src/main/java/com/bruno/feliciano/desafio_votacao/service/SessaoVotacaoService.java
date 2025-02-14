package com.bruno.feliciano.desafio_votacao.service;

import com.bruno.feliciano.desafio_votacao.entity.Pauta;
import com.bruno.feliciano.desafio_votacao.entity.SessaoVotacao;
import com.bruno.feliciano.desafio_votacao.repository.PautaRepository;
import com.bruno.feliciano.desafio_votacao.repository.SessaoVotacaoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessaoVotacaoService {
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaRepository pautaRepository;

    public SessaoVotacao abrirSessao(Long pautaId, Long duracaoMinutos) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new EntityNotFoundException("Pauta não encontrada"));

        if (sessaoVotacaoRepository.findByPautaId(pautaId).isPresent()) {
            throw new IllegalStateException("Já existe uma sessão aberta para esta pauta");
        }

        SessaoVotacao sessao = new SessaoVotacao(pauta, duracaoMinutos);
        return sessaoVotacaoRepository.save(sessao);
    }
}
