package com.ws.clientes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ws.clientes.entities.Client;
import com.ws.clientes.repositories.ClientRepository;
import com.ws.clientes.services.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ClientService service;
	
	@Test
	public void testEndPoint1() {
		List<Client> list = repository.findAll();
		
		assertThat(list.size()).isEqualTo(2);
	}
	
	@Test
	public void testEndPoint2() {
		long id = 2;
		Optional<Client> obj = repository.findById(id);
		
		assertThat(obj.get().getId()).isEqualTo(id);
	}
	
	@Test
	public void testEndPoint3() {
		service.insert(new Client(null, "ClienteTeste","0000123123", "Rua Teste endpoit3"));
		List<Client> list = repository.findAll();
		assertThat(list.size()).isEqualTo(3);
	}
}
