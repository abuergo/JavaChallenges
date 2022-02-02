package com.challenge.arrayProducts.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MessageErrorHandle {
    @ResponseBody
    @ExceptionHandler(ProductError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage messageErrorHandle(ProductError e){
        return new ErrorMessage(e.getMessage());
    }
}
