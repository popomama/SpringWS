package com.wx.webservices.first_rest.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	UserDaoService service;
	
	
	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}


	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
		
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Integer id) throws NoUserFoundException
	{
		User user= service.findOne(id);
		if(user==null)
			throw new NoUserFoundException("id: "+ id);
		
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) throws NoUserFoundException
	{
		 service.delete(id);
	
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		
		User updateUser = service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + updateUser.getId()).build().toUri();
		//ServletUriComponentsBuilder ;
		return ResponseEntity.created(location ).build();
				
	}
}
