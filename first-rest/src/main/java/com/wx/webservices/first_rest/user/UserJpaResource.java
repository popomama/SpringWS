package com.wx.webservices.first_rest.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; 
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wx.webservices.first_rest.jpa.IUserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	//UserDaoService service;
	IUserRepository repo;
	
	public UserJpaResource(IUserRepository repo) {
		super();
	//	this.service = service;
		this.repo=repo;
	}


	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers()
	{
		return repo.findAll();
		
	}
	
	

	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable Integer id) throws NoUserFoundException
	{
		//User user= service.findOne(id);
		Optional<User> user = repo.findById(id); 
		if(user.isEmpty())
			throw new NoUserFoundException("id: "+ id);
		
		EntityModel<User> model = EntityModel.of(user.get());
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		model.add(link.withRel("all-users"));
		return model;
	}
	
	/*
	 * @GetMapping("/users/{id}") public User retrieveUser(@PathVariable Integer id)
	 * throws NoUserFoundException { User user= service.findOne(id); if(user==null)
	 * throw new NoUserFoundException("id: "+ id);
	 * 
	 * return user; }
	 */
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id) throws NoUserFoundException
	{
		 //service.delete(id);
		repo.deleteById(id);
	
	}
	
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		
		User updateUser = repo.save(user);  //service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + updateUser.getId()).build().toUri();
		//ServletUriComponentsBuilder ;
		return ResponseEntity.created(location ).build();
				
	}
}
