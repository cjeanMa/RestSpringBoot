package com.jmcastle.platziCurso;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/saludar")
public class TestController {

    @GetMapping("/hola")
    public String saludar(){
        return "Enrutamiento basico Spring";
    }
}
