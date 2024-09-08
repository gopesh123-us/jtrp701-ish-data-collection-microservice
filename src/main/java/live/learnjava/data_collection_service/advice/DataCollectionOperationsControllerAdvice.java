package live.learnjava.data_collection_service.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DataCollectionOperationsControllerAdvice {
	//handle all exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String>handleAllExceptions(Exception e){
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}
}
