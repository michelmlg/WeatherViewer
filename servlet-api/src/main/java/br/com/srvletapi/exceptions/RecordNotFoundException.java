package br.com.srvletapi.exceptions;

public class RecordNotFoundException extends Exception{
    public RecordNotFoundException(String message) {
        super(message);
    }
}
