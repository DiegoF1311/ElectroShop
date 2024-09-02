package co.edu.unbosque.electroshop_api.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    	Map<String, String> errors = new HashMap<>();

    	ex.getBindingResult().getAllErrors().forEach((error) -> {
    		String fieldName = ((FieldError) error).getField();
    		String errorMessage = error.getDefaultMessage();
    		errors.put(fieldName, errorMessage);
    	});

    	HttpStatus status = determineHttpStatus(errors);

    	return new ResponseEntity<>(errors, status);
    }

    private HttpStatus determineHttpStatus(Map<String, String> errors) {
    	for (String fieldName : errors.keySet()) {
            switch (fieldName) {
                case "card.cardNumber":
                    return HttpStatus.PAYMENT_REQUIRED;
                case "card.expirationDate":
                    return HttpStatus.PAYMENT_REQUIRED;
                case "customerId":
                    return HttpStatus.BAD_REQUEST;
                case "productsId":
                    return HttpStatus.BAD_REQUEST;
                default:
                    return HttpStatus.BAD_REQUEST;
            }
    	}
        return HttpStatus.BAD_REQUEST;
    }
}

