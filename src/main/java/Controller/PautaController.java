package Controller;

import DTO.NovaPautaDTO;
import Entity.Pauta;
import Service.PautaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pautas")
public class PautaController {
    private final PautaService pautaService;
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }
    @PostMapping
    public Pauta criarPauta(@RequestBody NovaPautaDTO dto) {
        return pautaService.criarPauta(dto);
    }
}
