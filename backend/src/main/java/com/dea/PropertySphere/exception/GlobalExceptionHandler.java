package com.dea.PropertySphere.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * This class provides a global exception handler for the application.
 * It intercepts exceptions and returns a proper response to the client.
 */
@ControllerAdvice  // Indicates that this class handles exceptions globally across the application.
public class GlobalExceptionHandler {

    /**
     * Handles all exceptions of type Exception.class or its subclasses.
     * @param ex - The caught exception.
     * @param request - The current web request during which the exception occurred.
     * @return ResponseEntity containing the error message with a 400 Bad Request status.
     */
    @ExceptionHandler(Exception.class)  // Specifies that this method handles general exceptions.
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        // Returns a 400 Bad Request response with the exception message in the response body.
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
