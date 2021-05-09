package az.kapitalbank.demo.exception;

import az.kapitalbank.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.ResponseEntity.notFound;

@RestControllerAdvice(basePackageClasses = {DemoApplication.class})
@Slf4j
public class RestExceptionHandler {
    
    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity vehicleNotFound(EmployeeNotFoundException ex, WebRequest request) {
        log.debug("Exception ocurred with Employee");
        return notFound().build();
    }
    
}
