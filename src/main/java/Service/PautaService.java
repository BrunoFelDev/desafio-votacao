package Service;

import DTO.NovaPautaDTO;
import Entity.Pauta;
import Repository.PautaRepository;

import java.time.LocalDateTime;

@Service
public class PautaService {
    private final PautaRepository pautaRepository;
    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }
    public Pauta criarPauta(NovaPautaDTO dto) {
        return pautaRepository.save(new Pauta(null, dto.getTitulo(), dto.getDescricao(), LocalDateTime.now()));
    }
}