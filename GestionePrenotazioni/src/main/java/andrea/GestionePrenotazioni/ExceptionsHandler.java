package andrea.GestionePrenotazioni;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import andrea.GestionePrenotazioni.exceptions.BadRequestException;
import andrea.GestionePrenotazioni.exceptions.ErrorsPayload;
import andrea.GestionePrenotazioni.exceptions.NotFoundException;
import andrea.GestionePrenotazioni.exceptions.UnsupportedLanguageException;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
//	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ErrorsPayload> handleValidationErrors(MethodArgumentNotValidException ex) {
//		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage())
//				.collect(Collectors.toList());
//
//		ErrorsPayload payload = new ErrorsPayload(errors.get(0), new Date(), 400);
//
//		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorsPayload> handleNotFound(NotFoundException e) {
		ErrorsPayload payload = new ErrorsPayload(e.getMessage(), new Date(), 404);
		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorsPayload> handleBadRequest(BadRequestException e) {
		ErrorsPayload payload = new ErrorsPayload(e.getMessage(), new Date(), 400);
		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnsupportedLanguageException.class)
	    public ResponseEntity<ErrorsPayload> handleUnsupportedLanguage(UnsupportedLanguageException e) {
	    ErrorsPayload payload = new ErrorsPayload("Unsupported language: " + e.getLanguage(), new Date(), 400);
	    return new ResponseEntity<>(payload, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorsPayload> handleGenericErrors(Exception e) {
		System.out.println(e);
		ErrorsPayload payload = new ErrorsPayload("GENERIC SERVER ERROR! WE GONNA FIX IT ASAP!", new Date(), 500);
		return new ResponseEntity<ErrorsPayload>(payload, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
