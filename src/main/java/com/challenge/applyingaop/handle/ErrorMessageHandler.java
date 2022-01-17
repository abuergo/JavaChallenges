package com.challenge.applyingaop.handle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorMessageHandler {
    Logger LOGGER = LogManager.getLogger(ErrorMessage.class);

    @ResponseBody
    @ExceptionHandler(ClientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage messageErrorHandle(ClientException ex){
        LOGGER.error(ex);
        return new ErrorMessage(ex.getMessage());
    }
}
