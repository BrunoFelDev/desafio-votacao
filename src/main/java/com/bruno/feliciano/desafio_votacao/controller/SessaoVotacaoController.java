package com.bruno.feliciano.desafio_votacao.controller;


import com.bruno.feliciano.desafio_votacao.entity.SessaoVotacao;
import com.bruno.feliciano.desafio_votacao.service.SessaoVotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/sessoes")
public class SessaoVotacaoController {
    private final SessaoVotacaoService sessaoVotacaoService;

    @PostMapping("/{pautaId}")
    public ResponseEntity<SessaoVotacao> abrirSessao(@PathVariable Long pautaId,
                                                     @RequestParam(required = false) Long duracaoMinutos) {
        SessaoVotacao sessao = sessaoVotacaoService.abrirSessao(pautaId, duracaoMinutos);
        return ResponseEntity.ok(sessao);
    }
}
