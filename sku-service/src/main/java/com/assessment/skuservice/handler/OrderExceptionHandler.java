package com.assessment.skuservice.handler;

import com.assessment.skuservice.exception.InsufficientNumberException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class OrderExceptionHandler extends ResponseEntityExceptionHandler{

    @Autowired
    ObjectMapper objectMapper;

    private static final Logger LOGGER = LogManager.getLogger(OrderExceptionHandler.class);
    private static final HttpStatus EXPECTATION_FAILED = HttpStatus.EXPECTATION_FAILED;
    private static final HttpStatus UNAUTHORIZED = HttpStatus.UNAUTHORIZED;
    private static final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;
    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(InsufficientNumberException.class)
    public final ResponseEntity<ErrorDetails> handleInsufficientNumberException(InsufficientNumberException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(INTERNAL_SERVER_ERROR.value(), BAD_REQUEST.getReasonPhrase(),
                ex.getMessage());
        LOGGER.error("\n InsufficientNumberException Exception: " +
                transformtoJson(errorDetails));
        return new ResponseEntity<>(errorDetails, BAD_REQUEST);
    }

    private String transformtoJson(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
