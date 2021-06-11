package com.jmcastle.platziCurso.web.controller;

import com.jmcastle.platziCurso.domain.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    @ApiOperation("Get all clients")
    @ApiResponse(code = 200, message="OK")
    public ResponseEntity getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }
}
