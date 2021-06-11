package com.jmcastle.platziCurso.persistence.crud;

import com.jmcastle.platziCurso.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {

}
