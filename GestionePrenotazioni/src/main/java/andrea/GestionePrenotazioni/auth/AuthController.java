package andrea.GestionePrenotazioni.auth;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import andrea.GestionePrenotazioni.auth.payloads.AuthenticationSuccessfullPayload;
import andrea.GestionePrenotazioni.entities.Prenotazione;
import andrea.GestionePrenotazioni.entities.User;
import andrea.GestionePrenotazioni.exceptions.NotFoundException;
import andrea.GestionePrenotazioni.exceptions.UnauthorizedException;
import andrea.GestionePrenotazioni.payloads.UserLoginPayload;
import andrea.GestionePrenotazioni.payloads.UserRegistrationPayload;
import andrea.GestionePrenotazioni.services.PrenotazioniService;
import andrea.GestionePrenotazioni.services.UsersService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UsersService usersService;
	@Autowired
	PrenotazioniService prenotazioniService;
	
	private static String secret;

	@Value("${spring.application.jwt.secret}")
	public void setSecret(String secretKey) {
		secret = secretKey;
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody @Validated UserRegistrationPayload body) {
		User createdUser = usersService.create(body);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationSuccessfullPayload> login(@RequestBody UserLoginPayload body) throws NotFoundException{
		
		//cerco la mail inserita nel login tra quelle degli utenti
		User user = usersService.findByEmail(body.getEmail());
		
		//se la trovo faccio il check sulla password, se non corrisponde lancio errore 401
		if(!body.getPassword().matches(user.getPassword())) throw new UnauthorizedException("Credenziali non valide");
		
		//se corrisponde creo token
		String token = JWTTools.createToken(user);
		
		return new ResponseEntity<>(new AuthenticationSuccessfullPayload(token), HttpStatus.OK);
	}
	
	@GetMapping("/prenotazioniutente")
	public List<Prenotazione> getPrenotazioniUtente(@RequestHeader("Authorization") String token){
		
		String email = getUserEmailFromToken(token);
		
		List<Prenotazione> prenotazioni = prenotazioniService.findByUserEmail(email);
		
		return prenotazioni;
	}
	
	private String getUserEmailFromToken(String token) {
		  try {

		        String userEmail = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token)
						.getBody().getSubject(); 

		        return userEmail;
		    } catch (SignatureException e) {
		        // Il token non è valido o la firma non corrisponde
		        throw new UnauthorizedException("Token JWT non valido");
		    } catch (Exception e) {
		        // Si è verificato un errore durante la decodifica del token
		        throw new UnauthorizedException("Errore nella decodifica del token JWT");
		    }
	}
}
