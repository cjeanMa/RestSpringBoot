package com.jmcastle.platziCurso.web.controller;

import com.jmcastle.platziCurso.domain.dto.AuthenticationRequest;
import com.jmcastle.platziCurso.domain.dto.AuthenticationResponse;
import com.jmcastle.platziCurso.domain.service.UserService;
import com.jmcastle.platziCurso.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Autor: Jean M. Castillo
 **/
@RestControllerAdvice
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

@PostMapping("/authenticate")
public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){

    try{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
    }
    catch (BadCredentialsException ex){
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
}
