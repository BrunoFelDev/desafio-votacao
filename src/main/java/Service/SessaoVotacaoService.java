package Service;

import DTO.NovaSessaoVotacaoDTO;
import Entity.Pauta;
import Entity.SessaoVotacao;
import Exceptions.RecursoNaoEncontradoException;
import Repository.PautaRepository;
import Repository.SessaoVotacaoRepository;

import java.time.LocalDateTime;

@Service
public class SessaoVotacaoService {
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaRepository pautaRepository;
    public SessaoVotacaoService(SessaoVotacaoRepository sessaoVotacaoRepository, PautaRepository pautaRepository) {
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
        this.pautaRepository = pautaRepository;
    }
    public SessaoVotacao abrirSessao(NovaSessaoVotacaoDTO dto) {
        Pauta pauta = pautaRepository.findById(dto.getPautaId()).orElseThrow(() -> new RecursoNaoEncontradoException("Pauta não encontrada"));
        SessaoVotacao sessao = new SessaoVotacao(null, pauta, LocalDateTime.now(), LocalDateTime.now().plusMinutes(dto.getTempoDuracao()), dto.getTempoDuracao());
        return sessaoVotacaoRepository.save(sessao);
    }
}
