package pl.fis.java.lbdcinemafinal.cinema_service.errors.handlers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<String> constraintViolation(TransactionSystemException ex)
	{
		Throwable cause = ex.getRootCause();
		String message = "";
		if (cause instanceof ConstraintViolationException)
		{
			Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) cause)
					.getConstraintViolations();
			for (ConstraintViolation<?> violation : constraintViolations)
			{
				message += violation.getMessage() + "\n";
			}
		}

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
}
