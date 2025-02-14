package com.bruno.feliciano.desafio_votacao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessao_votacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;

    @Column(nullable = false, updatable = false)
    private LocalDateTime abertaEm;

    private LocalDateTime encerradaEm;

    @Column(nullable = false)
    private int tempoDuracao = 1;

    public boolean isAtiva() {
        return encerradaEm == null || encerradaEm.isAfter(LocalDateTime.now());
    }

    public SessaoVotacao(Pauta pauta, Long duracaoMinutos) {
        this.pauta = pauta;
        this.abertaEm = LocalDateTime.now();
        this.encerradaEm = this.abertaEm.plusMinutes(duracaoMinutos != null ? duracaoMinutos : 1);
    }
}

