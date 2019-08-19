package pl.fis.java.lbdcinemafinal.cinema_service.errors.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<String> constraintViolation(TransactionSystemException ex)
	{
		//System.out.print();
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
