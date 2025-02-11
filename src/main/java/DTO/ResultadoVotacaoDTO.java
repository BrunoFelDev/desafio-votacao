package DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoVotacaoDTO {
    private Long pautaId;
    private long votosSim;
    private long votosNao;
}
