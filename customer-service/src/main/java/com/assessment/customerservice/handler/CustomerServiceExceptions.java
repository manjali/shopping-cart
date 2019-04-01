package com.assessment.customerservice.handler;

import com.assessment.customerservice.exception.InvalidResponseFromServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class CustomerServiceExceptions extends ResponseEntityExceptionHandler  {
    @Autowired
    ObjectMapper objectMapper;

    private static final Logger LOGGER = LogManager.getLogger(CustomerServiceExceptions.class);
    private static final HttpStatus EXPECTATION_FAILED = HttpStatus.EXPECTATION_FAILED;
    private static final HttpStatus UNAUTHORIZED = HttpStatus.UNAUTHORIZED;
    private static final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;
    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(InvalidResponseFromServiceException.class)
    public final ResponseEntity<ErrorDetails> handleInsufficientNumberException(InvalidResponseFromServiceException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(INTERNAL_SERVER_ERROR.value(), BAD_REQUEST.getReasonPhrase(),
                ex.getMessage());
        LOGGER.error("\n InvalidResponseFromServiceException " +
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
