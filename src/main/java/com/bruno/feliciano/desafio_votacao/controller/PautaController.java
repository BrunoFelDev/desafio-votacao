package com.bruno.feliciano.desafio_votacao.controller;


import com.bruno.feliciano.desafio_votacao.dto.NovaPautaDTO;
import com.bruno.feliciano.desafio_votacao.entity.Pauta;
import com.bruno.feliciano.desafio_votacao.service.PautaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/pautas")
public class PautaController {
    private final PautaService pautaService;
    @PostMapping
    public Pauta criarPauta(@RequestBody NovaPautaDTO dto) {
        return pautaService.criarPauta(dto);
    }


}
