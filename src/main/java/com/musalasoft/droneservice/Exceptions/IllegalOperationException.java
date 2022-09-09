package com.musalasoft.droneservice.Exceptions;

/**
 * @author Alex Maina
 * @created 09/09/2022
 **/
public class IllegalOperationException extends IllegalArgumentException{
    public IllegalOperationException(String s) {
        super (s);
    }
}
