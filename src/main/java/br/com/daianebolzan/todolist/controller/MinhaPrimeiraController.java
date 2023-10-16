package br.com.daianebolzan.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
public class MinhaPrimeiraController {

    // Métodos HTTP - get, post, put, delete, patch

    // método (Funcionalidade) de uma classe
    @GetMapping("/primeiroMetodo")
    public String primeiraMensagem() {
        return "Funcionou";

    }
}
