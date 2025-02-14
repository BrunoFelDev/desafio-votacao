package com.bruno.feliciano.desafio_votacao.controller;


import com.bruno.feliciano.desafio_votacao.response.StatusResponse;
import com.bruno.feliciano.desafio_votacao.service.ValidadorDeCpfClientFakeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validar-cpf")
@AllArgsConstructor
public class ValidadorDeCpfClientFController {

    private final ValidadorDeCpfClientFakeService validadorDeCpfClientFakeService;

    @GetMapping("/{cpf}")
    public ResponseEntity<StatusResponse> validar(@PathVariable String cpf) {
       String status = validadorDeCpfClientFakeService.validarCpf(cpf);
       if (status.equals("Cpf inválido")){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
        return ResponseEntity.ok(new StatusResponse(status));
    }
}
