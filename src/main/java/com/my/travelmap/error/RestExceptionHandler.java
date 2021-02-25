package com.my.travelmap.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    private final static String INTERNAL_SERVER_ERROR = "Internal Server Error";
    private final static String BAD_REQUEST = "Bad request";
    
    private final static String INVALID_INPUT = "Invalid input";
    
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(Exception e) {
    	logger.error("Bad request - {}", e.getMessage(), e);
        return buildResponseEntity(
        		new ExceptionResponse(
        				BAD_REQUEST, 
        				INVALID_INPUT, 
        				HttpStatus.BAD_REQUEST)
        		);
    }
    
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        logger.error("Server error - {}", e.getMessage(), e);
        return buildResponseEntity(
        		new ExceptionResponse(
        				INTERNAL_SERVER_ERROR, 
        				INTERNAL_SERVER_ERROR, 
        				HttpStatus.INTERNAL_SERVER_ERROR)
        		);
    }

    private ResponseEntity<ExceptionResponse> buildResponseEntity(ExceptionResponse exceptionResponse) {
        logger.error("Handling error - {}", exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.valueOf(exceptionResponse.getStatus()));
    }
}