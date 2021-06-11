package com.jmcastle.platziCurso.persistence;

import com.jmcastle.platziCurso.domain.Client;
import com.jmcastle.platziCurso.persistence.crud.ClienteCrudRepository;
import com.jmcastle.platziCurso.persistence.entity.Cliente;
import com.jmcastle.platziCurso.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    ClienteCrudRepository clienteCrudRepository;

    @Autowired
    ClientMapper mapper;

    public List<Client> getAll(){
        return mapper.toClients((List<Cliente>) clienteCrudRepository.findAll());
    }

}
