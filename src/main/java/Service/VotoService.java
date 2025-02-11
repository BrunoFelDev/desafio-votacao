package Service;

import DTO.NovoVotoDTO;
import Entity.SessaoVotacao;
import Entity.Voto;
import Exceptions.RecursoNaoEncontradoException;
import Exceptions.VotoInvalidoException;
import Repository.SessaoVotacaoRepository;
import Repository.VotoRepository;

import java.time.LocalDateTime;

@Service
public class VotoService {
    private final VotoRepository votoRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    public VotoService(VotoRepository votoRepository, SessaoVotacaoRepository sessaoVotacaoRepository) {
        this.votoRepository = votoRepository;
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
    }
    public Voto registrarVoto(NovoVotoDTO dto) {
        SessaoVotacao sessao = sessaoVotacaoRepository.findById(dto.getSessaoVotacaoId()).orElseThrow(() -> new RecursoNaoEncontradoException("Sessão de votação não encontrada"));
        if (!sessao.isAtiva()) throw new VotoInvalidoException("Sessão de votação encerrada");
        if (votoRepository.existsBySessaoVotacaoAndAssociadoId(sessao, dto.getAssociadoId())) throw new VotoInvalidoException("Associado já votou nesta sessão");
        return votoRepository.save(new Voto(null, sessao, dto.getAssociadoId(), dto.isVoto(), LocalDateTime.now()));
    }
}
