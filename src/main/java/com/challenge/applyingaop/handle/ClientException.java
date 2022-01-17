package com.challenge.applyingaop.handle;

public class ClientException extends Exception{
    private String message;

    public ClientException(String message){
        this.message = message;
    }

}
