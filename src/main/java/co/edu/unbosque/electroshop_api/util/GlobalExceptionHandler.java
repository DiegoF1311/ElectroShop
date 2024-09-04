package co.edu.unbosque.electroshop_api.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for handling validation exceptions.
 * <p>
 * This class is used to catch and handle exceptions thrown due to validation errors
 * in the application. It returns a structured response with error details and appropriate HTTP status codes.
 * </p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
     * Handles {@link MethodArgumentNotValidException} thrown during validation errors.
     * <p>
     * This method collects all validation errors from the exception, maps them to field names and error messages,
     * and returns a {@link ResponseEntity} containing these errors along with an appropriate HTTP status code.
     * </p>
     * 
     * @param ex the {@link MethodArgumentNotValidException} containing validation errors
     * @return a {@link ResponseEntity} with a map of field names to error messages and the appropriate HTTP status
     */
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

    /**
     * Determines the HTTP status code based on the validation errors.
     * <p>
     * This method checks the field names in the errors map and returns specific HTTP status codes based on known error types.
     * </p>
     * 
     * @param errors a map of field names to error messages
     * @return the {@link HttpStatus} corresponding to the validation errors
     */
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

