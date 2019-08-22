package pl.fis.java.showservice.exceptions;

import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Map<String, String>> errorList = new ArrayList<>();
        Map<String, String> map = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        errorList.add(map);

        ErrorInfo errorDetails = new ErrorInfo(HttpStatus.BAD_REQUEST, errorList);
        return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
    }

    /*@ExceptionHandler(TransactionSystemException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleMethodArgumentNotValid(TransactionSystemException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }*/



    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({TransactionSystemException.class})
    @ResponseBody
    public ErrorInfo handleNotFound(Exception ex) {
        return new ErrorInfo(HttpStatus.NOT_FOUND, ex.toString()
                .substring(ex.toString()
                        .lastIndexOf(':') + 1));
    }


}
