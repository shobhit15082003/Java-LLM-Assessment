package Java.Backend.LLM.Assesment.demo.config;

import Java.Backend.LLM.Assesment.demo.dto.ResponseWrapper;
import Java.Backend.LLM.Assesment.demo.exception.InsuranceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsuranceNotFoundException.class)
    public ResponseEntity<ResponseWrapper<String>> handleInsuranceNotFoundException(InsuranceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseWrapper<>(404,"No Insurance Found",ex.getMessage()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<String>>handleGenericException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseWrapper<>(500, "An unexpected error occured",ex.getMessage()));
    }
}
