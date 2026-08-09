package br.com.pizzariabizu.backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")

public class UserController {


    @GetMapping("/")
    public String testeMensagem(){
        return "funcionou";
    }

}
