package tn.esprit.BookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class} )
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        // Create payload containing exception and details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                e.getMessage(),
                e.status,
                ZonedDateTime.now(ZoneId.of("Africa/Tunis"))
        );

        //Return ResponseEntity
        return new ResponseEntity<>(apiException, e.status);
    }
}
