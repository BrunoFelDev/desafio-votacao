package Controller;

import DTO.NovaSessaoVotacaoDTO;
import Entity.SessaoVotacao;
import Service.SessaoVotacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessoes")
public class SessaoVotacaoController {
    private final SessaoVotacaoService sessaoVotacaoService;
    public SessaoVotacaoController(SessaoVotacaoService sessaoVotacaoService) {
        this.sessaoVotacaoService = sessaoVotacaoService;
    }
    @PostMapping
    public SessaoVotacao abrirSessao(@RequestBody NovaSessaoVotacaoDTO dto) {
        return sessaoVotacaoService.abrirSessao(dto);
    }
}
