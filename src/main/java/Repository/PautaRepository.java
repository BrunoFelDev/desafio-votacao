package Repository;

import Entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {}
