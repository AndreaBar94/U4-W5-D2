package andrea.GestionePrenotazioni.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import andrea.GestionePrenotazioni.entities.User;
import andrea.GestionePrenotazioni.exceptions.NotFoundException;
import andrea.GestionePrenotazioni.services.UsersService;


@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;

	// 1. - GET http://localhost:3001/users (+opzionalmente query params) <-- READ
	@GetMapping("")
	public List<User> getUsers(){
		return usersService.find();
	}

	// 2. - POST http://localhost:3001/users (+ req.body) <-- CREATE
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED) // <-- 201 CREATED
	public User saveUser(@RequestBody User body) {
		User createdUser = usersService.create(body);
		return createdUser;
	}

	// 3. - GET http://localhost:3001/users/:userId <-- READ
	@GetMapping("/{userId}")
	public User findById(@PathVariable UUID userId) throws Exception {

		return usersService.findById(userId);
	}

	
	// 4. - PUT http://localhost:3001/users/:userId (+ req.body) <-- UPDATE
	@PutMapping("/{userId}")
	public User findByIdAndUpdate(@PathVariable UUID userId, @RequestBody User body) throws Exception {

		return usersService.findByIdAndUpdate(userId, body);
	}

	// 5. - DELETE http://localhost:3001/users/:userId <-- DELETE
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
	public void findByIdAndDelete(@PathVariable UUID userId) throws Exception {

		usersService.findByIdAndDelete(userId);
	}

}

