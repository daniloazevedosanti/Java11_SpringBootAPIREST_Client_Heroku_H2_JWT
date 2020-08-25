package com.ws.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ws.clientes.entities.Client;

/**
 * Interfaces for database requests via JPA 
 * @author Dan
 *
 */

public interface ClientRepository extends JpaRepository<Client, Long> {

}
