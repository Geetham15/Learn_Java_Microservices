package com.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();

	}
	// Output: localhost:8080/users
	// http://localhost:8080/users

	/*
	 * [ { "id": 1, "name": "Adam", "birthDate": "1996-10-15" }, { "id": 2, "name":
	 * "Eve", "birthDate": "2001-10-15" }, { "id": 3, "name": "Jim", "birthDate":
	 * "2006-10-15" } ]
	 */

	// GET user by id
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}
	// Run by command localhost:8080/users/1
	// { "id": 1, "name": "Adam", "birthDate": "1996-10-15" }

	// POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();// /users/{id}, user.getID()
		//Return location.
		return ResponseEntity.created(location).build();
		
		// Return the HTTP status code --> 201- Created Ok
		// return ResponseEntity.created(null).build();
		
	}
	// user Talend API Tester to invoke, discover and test HTTP and REST APIs.
}
