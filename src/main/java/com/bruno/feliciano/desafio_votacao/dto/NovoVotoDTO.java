package com.bruno.feliciano.desafio_votacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NovoVotoDTO {
    private Long sessaoVotacaoId;
    private String associadoId;
    private boolean voto;
}
