package Repository;

import Entity.SessaoVotacao;
import Entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsBySessaoVotacaoAndAssociadoId(SessaoVotacao sessaoVotacao, String associadoId);
    long countBySessaoVotacaoAndVoto(SessaoVotacao sessaoVotacao, boolean voto);
}
