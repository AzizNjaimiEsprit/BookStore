package tn.esprit.BookStore.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends  RuntimeException {

    HttpStatus status;

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
