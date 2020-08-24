package com.ws.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ws.clientes.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
