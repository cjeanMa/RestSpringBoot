package com.jmcastle.platziCurso.persistence.mapper;

import com.jmcastle.platziCurso.domain.Client;
import com.jmcastle.platziCurso.domain.Product;
import com.jmcastle.platziCurso.persistence.entity.Cliente;
import com.jmcastle.platziCurso.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "id", target = "idClient"),
            @Mapping(source = "nombre", target = "nameClient"),
            @Mapping(source = "apellidos", target = "lastNameClient"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "celular", target = "mobile"),
            @Mapping(source = "correoElectronico", target = "email"),
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "compras", ignore = true)
    Cliente toCliente(Client client);
}
