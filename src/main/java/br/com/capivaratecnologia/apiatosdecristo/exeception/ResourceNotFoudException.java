package br.com.capivaratecnologia.apiatosdecristo.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ResourceNotFoudException extends RuntimeException {
    public ResourceNotFoudException(String message){
        super(message);
    }
}
