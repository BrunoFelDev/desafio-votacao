package com.bruno.feliciano.desafio_votacao.service;

import com.bruno.feliciano.desafio_votacao.dto.NovoVotoDTO;
import com.bruno.feliciano.desafio_votacao.entity.Pauta;
import com.bruno.feliciano.desafio_votacao.entity.SessaoVotacao;
import com.bruno.feliciano.desafio_votacao.entity.Voto;
import com.bruno.feliciano.desafio_votacao.exceptions.RecursoNaoEncontradoException;
import com.bruno.feliciano.desafio_votacao.exceptions.VotoInvalidoException;
import com.bruno.feliciano.desafio_votacao.repository.PautaRepository;
import com.bruno.feliciano.desafio_votacao.repository.SessaoVotacaoRepository;
import com.bruno.feliciano.desafio_votacao.repository.VotoRepository;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotoService {
    private final VotoRepository votoRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaRepository pautaRepository;

    public Voto registrarVoto(NovoVotoDTO dto) {
        SessaoVotacao sessao = sessaoVotacaoRepository.findById(dto.getSessaoVotacaoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Sessão de votação não encontrada"));
        if (!sessao.isAtiva()){
            throw new VotoInvalidoException("Sessão de votação encerrada");
        }
        if (votoRepository.existsBySessaoVotacaoAndAssociadoId(sessao, dto.getAssociadoId())){
            throw new VotoInvalidoException("Associado já votou nesta sessão");
        }

        return votoRepository.save(new Voto(null, sessao, dto.getAssociadoId(), dto.isVoto(), LocalDateTime.now()));
    }

    public String contabilizarVotos(Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));

        long votosSim = votoRepository.countBySessaoVotacaoPautaIdAndVotoTrue(pautaId);
        long votosNao = votoRepository.countBySessaoVotacaoPautaIdAndVotoFalse(pautaId);


        String resultado = (votosSim > votosNao) ? "APROVADA" : (votosSim < votosNao) ? "REJEITADA" : "EMPATE";

        return String.format("Resultado da pauta '%s': %s (%d votos Sim, %d votos Não)", pauta.getTitulo(), resultado, votosSim, votosNao);
    }




}
