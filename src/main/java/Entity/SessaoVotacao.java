package Entity;

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
    private LocalDateTime abertaEm = LocalDateTime.now();

    private LocalDateTime encerradaEm;

    @Column(nullable = false)
    private int tempoDuracao = 1;

    public boolean isAtiva() {
        return encerradaEm == null || encerradaEm.isAfter(LocalDateTime.now());
    }
}

