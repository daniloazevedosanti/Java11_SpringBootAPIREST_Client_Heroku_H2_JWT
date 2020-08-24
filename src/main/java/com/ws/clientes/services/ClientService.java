package com.ws.clientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.clientes.entities.Client;
import com.ws.clientes.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		//try {
		repository.deleteById(id);
		/*}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);	
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());		
		}*/
	}
	
	public Client update(Long id, Client obj) {
		//try {
		Client entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
		/*}catch(EntityNotFoundException e) {
			//e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}*/
	}
	
	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setAddress(obj.getAddress());
	}
}

