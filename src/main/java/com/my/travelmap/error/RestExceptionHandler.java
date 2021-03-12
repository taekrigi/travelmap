package com.my.travelmap.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    private final static String INTERNAL_SERVER_ERROR = "Internal Server Error";
    private final static String BAD_REQUEST = "Bad request";
    private final static String NOT_FOUND = "Not Found";
    private final static String UNAUTHORIZED = "Unauthorized";
    
    @ExceptionHandler(value = {IllegalArgumentException.class, UserAlreadyExistsException.class})
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(Exception e) {
        return buildResponseEntity(
        		new ExceptionResponse(
    				BAD_REQUEST, 
    				e.getMessage(), 
    				HttpStatus.BAD_REQUEST
    			)
    		);
    }
    
    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalStateExceptionn(Exception e) {
        return buildResponseEntity(
        		new ExceptionResponse(
    				BAD_REQUEST, 
    				e.getMessage(), 
    				HttpStatus.BAD_REQUEST
    			)
    		);
    }
    
    @ExceptionHandler(value = NoHandlerFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoHandlerFoundException(Exception e) {
    	return buildResponseEntity(
        		new ExceptionResponse(
    				NOT_FOUND, 
    				NOT_FOUND, 
    				HttpStatus.NOT_FOUND
    			)
        	);
    }
    
    @ExceptionHandler(value = ResponseStatusException.class)
	public ResponseEntity<ExceptionResponse> handleResponsestatusException(ResponseStatusException e) {
    	return buildResponseEntity(
        		new ExceptionResponse(
        		    e.getLocalizedMessage(), 
    				e.getMessage(), 
    				e.getStatus()
        		)		
        );
    }
    
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    	return buildResponseEntity(
        		new ExceptionResponse(
        		    e.getLocalizedMessage(), 
    				e.getMessage(), 
    				HttpStatus.BAD_REQUEST
        		)		
        );
    }
    
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        logger.error("Server error - {}", e.getMessage(), e);
        return buildResponseEntity(
        		new ExceptionResponse(
    				INTERNAL_SERVER_ERROR, 
    				INTERNAL_SERVER_ERROR, 
    				HttpStatus.INTERNAL_SERVER_ERROR
    			)
        	);
    }
    
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ExceptionResponse> handleHttpRequestMethodNotSupportedException(Exception e) {
    	return buildResponseEntity(
        		new ExceptionResponse(
    				NOT_FOUND, 
    				NOT_FOUND, 
    				HttpStatus.NOT_FOUND
    			)
        	);
    }
    
    @ExceptionHandler(value = {AccessDeniedException.class}) 
    public ResponseEntity<ExceptionResponse> handleAccessDeniedException(Exception e) {
    	return buildResponseEntity(
        		new ExceptionResponse(
    				UNAUTHORIZED, 
    				UNAUTHORIZED, 
    				HttpStatus.UNAUTHORIZED
    			)
    		);	
    }

    private ResponseEntity<ExceptionResponse> buildResponseEntity(ExceptionResponse exceptionResponse) {
        logger.error("Handling error - {}", exceptionResponse);
        return new ResponseEntity<>(
        		exceptionResponse, 
        		HttpStatus.valueOf(exceptionResponse.getStatus()
        	)
       );
    }
}