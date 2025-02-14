package com.bruno.feliciano.desafio_votacao.repository;

import com.bruno.feliciano.desafio_votacao.entity.SessaoVotacao;
import com.bruno.feliciano.desafio_votacao.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsBySessaoVotacaoAndAssociadoId(SessaoVotacao sessaoVotacao, String associadoId);
    long countBySessaoVotacaoPautaIdAndVotoTrue(Long pautaId);
    long countBySessaoVotacaoPautaIdAndVotoFalse(Long pautaId);
}
