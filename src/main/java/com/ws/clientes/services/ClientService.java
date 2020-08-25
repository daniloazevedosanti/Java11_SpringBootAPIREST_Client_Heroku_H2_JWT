package com.ws.clientes.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ws.clientes.entities.Client;
import com.ws.clientes.repositories.ClientRepository;
import com.ws.clientes.services.exceptions.DatabaseException;
import com.ws.clientes.services.exceptions.ResourceNotFoundException;

/**
 * Class of service, bridges the gap between 
 * the control resource and the jpa, has action 
 * methods registration, listing, updating and deletion.
 * @author Dan
 *
 */
@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);	
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());		
		}
	}
	
	public Client update(Long id, Client obj) {
		try {
		Client entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
		}catch(EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setAddress(obj.getAddress());
	}
}

