package com.ashish.exception;

import com.ashish.validations.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ConstraintViolationExceptionResolver {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        List<Object> errorList = ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> {
                    final ErrorCode error = (ErrorCode) e.getArguments()[1];
                    return new PatternError(error.name(), error.getErrorDescription());
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(errorList, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
