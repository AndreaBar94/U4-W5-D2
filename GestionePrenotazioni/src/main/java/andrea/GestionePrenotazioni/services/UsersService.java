package andrea.GestionePrenotazioni.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andrea.GestionePrenotazioni.entities.User;
import andrea.GestionePrenotazioni.repositories.UsersRepository;



@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepo;

	public User create(User u) {
		//check if email is correct
		
		return usersRepo.save(u);
	}
	
	public List<User> find(){
		return usersRepo.findAll();
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
