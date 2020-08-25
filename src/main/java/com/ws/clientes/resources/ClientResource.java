package com.ws.clientes.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ws.clientes.entities.Client;
import com.ws.clientes.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	/**
	 * List all registered clients 
	 * @return response list of clients
	 */
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		
		List<Client> list = service.findAll();  
		return ResponseEntity.ok().body(list);
	}
	
	/**
	 * Show client by number id in database
	 * @param id
	 * @return register of client by id
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	 * Register record in the database via post method
	 * @param obj
	 * @return successfully included record
	 */
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	/**
	 * Delete record by id
	 * @param id
	 * @return response entity
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	/**
	 * Update records in database
	 * @param id
	 * @param obj
	 * @return response entity 
	 */
	@PutMapping
	(value = "/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj){
		service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
