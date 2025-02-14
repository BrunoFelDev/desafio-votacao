package com.bruno.feliciano.desafio_votacao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sessao_votacao_id")
    private SessaoVotacao sessaoVotacao;

    @Column(nullable = false, unique = true)
    private String associadoId;

    @Column(nullable = false)
    private boolean voto;

    @Column(nullable = false, updatable = false)
    private LocalDateTime votadoEm = LocalDateTime.now();
}
