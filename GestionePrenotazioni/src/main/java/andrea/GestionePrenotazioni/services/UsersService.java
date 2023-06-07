package andrea.GestionePrenotazioni.services;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import andrea.GestionePrenotazioni.entities.User;
import andrea.GestionePrenotazioni.exceptions.BadRequestException;
import andrea.GestionePrenotazioni.payloads.UserRegistrationPayload;
import andrea.GestionePrenotazioni.repositories.UsersRepository;



@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepo;

	public User create(UserRegistrationPayload u) {
		//check if email already exist
		usersRepo.findByEmail(u.getEmail()).ifPresent(user -> 
		{throw new BadRequestException("Email " + u.getEmail() + " already exist");
		});
		User newUser = new User(u.getName(), u.getSurname(), u.getEmail());
		return usersRepo.save(newUser);
	}
	
	public Page<User> find(int page, int size, String sortedBy){
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortedBy));
		
		return usersRepo.findAll(pageable);
	}
	
	public User findById(UUID id) throws Exception{
		return usersRepo.findById(id).orElseThrow(()-> new Exception("Utente non trovato"));
	}
	
	public User findByIdAndUpdate(UUID id, User u) throws Exception {
		User found = this.findById(id);
		
		found.setId(id);
		found.setName(u.getName());
		found.setSurname(u.getSurname());
		found.setEmail(u.getEmail());
		return usersRepo.save(found);
	}
	
	public void findByIdAndDelete(UUID id) throws Exception {
		User found = this.findById(id);
		usersRepo.delete(found);
	}
}
