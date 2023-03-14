package com.lino.security.exception;

import com.lino.security.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAdvisor {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        for (Throwable th : ex.getSuppressed()){
            log.error("{}", th.getCause());
        }
        return new ResponseEntity(new ErrorResponse("60000", "Username already exists"), HttpStatus.IM_USED);
    }
}
