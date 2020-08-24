package com.ws.clientes.configurations;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ws.clientes.entities.Client;
import com.ws.clientes.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TesteConfiguration implements CommandLineRunner {

	@Autowired
	private ClientRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
				
		Client u1 = new Client(null, "Joana de Souza", "1234567890", "Av. dois de julho");
		Client u2 = new Client(null, "Alex Graao", "1234567890", "Av. dois de julho");
				
		repository.saveAll(Arrays.asList(u1, u2));
		
	}
}
