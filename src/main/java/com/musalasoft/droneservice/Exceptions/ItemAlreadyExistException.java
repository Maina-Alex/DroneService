package com.musalasoft.droneservice.Exceptions;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
public class ItemAlreadyExistException extends IllegalArgumentException{
    public ItemAlreadyExistException(String s) {
        super (s);
    }
}
