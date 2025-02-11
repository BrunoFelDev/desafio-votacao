package Repository;

import Entity.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {}
