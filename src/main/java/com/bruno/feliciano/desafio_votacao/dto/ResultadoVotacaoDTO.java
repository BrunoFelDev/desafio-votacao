package com.bruno.feliciano.desafio_votacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoVotacaoDTO {
    private Long pautaId;
    private Long votosSim;
    private Long votosNao;
}
