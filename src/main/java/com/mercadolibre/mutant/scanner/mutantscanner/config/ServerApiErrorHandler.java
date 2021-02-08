package com.mercadolibre.mutant.scanner.mutantscanner.config;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ServerApiErrorHandler {

    /**
     *
     * @param methodArgumentNotValidException
     * @return ResponseEntity<String> errorMessage
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> exception(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<ObjectError> errors = methodArgumentNotValidException.getAllErrors();
        String errorMessage = "";
        if (!errors.isEmpty()) {
            errorMessage = errors.stream().map(error -> error.getDefaultMessage()).collect(Collectors.joining("\n"));
        } else {
            errorMessage = "MethodArgumentNotValidException occured.";
        }
        return new ResponseEntity<>(new GeneralResponse(errorMessage), HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @param mismatchedInputException
     * @return ResponseEntity<GeneralResponse> errorMessage
     */
    @ExceptionHandler(MismatchedInputException.class)
    public ResponseEntity<Object> exception(MismatchedInputException mismatchedInputException) {
        return new ResponseEntity<>(
                new GeneralResponse("Input data is not in a valid format, should be a "+mismatchedInputException.getTargetType().getTypeName()),
                HttpStatus.BAD_REQUEST);
    }

}
