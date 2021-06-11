package com.jmcastle.platziCurso.domain.service;

import com.jmcastle.platziCurso.domain.Client;
import com.jmcastle.platziCurso.persistence.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Client> getAll(){
       return clienteRepository.getAll();
    }
}
