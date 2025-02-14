package com.bruno.feliciano.desafio_votacao.service;

import com.bruno.feliciano.desafio_votacao.util.ValidarCpf;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidadorDeCpfClientFakeService {

    public String validarCpf(String cpf) {
        boolean retornoValidacaoCpf = ValidarCpf.isValidCpf(cpf);

        if (retornoValidacaoCpf == false){
            return "Cpf inválido";
        }else{
            return Math.random() > 0.5 ? "ABLE_TO_VOTE" : "UNABLE_TO_VOTE";
        }

    }

}
