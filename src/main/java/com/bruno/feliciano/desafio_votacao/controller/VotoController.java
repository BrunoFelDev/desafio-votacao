package com.bruno.feliciano.desafio_votacao.controller;

import com.bruno.feliciano.desafio_votacao.dto.NovoVotoDTO;
import com.bruno.feliciano.desafio_votacao.entity.Voto;
import com.bruno.feliciano.desafio_votacao.service.VotoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/votos")
public class VotoController {
    private final VotoService votoService;
    @PostMapping
    public Voto registrarVoto(@RequestBody NovoVotoDTO dto) {
        return votoService.registrarVoto(dto);
    }


    @GetMapping("/{pautaId}/resultado")
    public ResponseEntity<String> resultadoVotacao(@PathVariable Long pautaId) {
        return ResponseEntity.ok(votoService.contabilizarVotos(pautaId));
    }

}
