package Controller;

import DTO.NovoVotoDTO;
import Entity.Voto;
import Service.VotoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votos")
public class VotoController {
    private final VotoService votoService;
    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }
    @PostMapping
    public Voto registrarVoto(@RequestBody NovoVotoDTO dto) {
        return votoService.registrarVoto(dto);
    }
}
