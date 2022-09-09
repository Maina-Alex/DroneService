package com.musalasoft.droneservice.Exceptions;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
public class ItemNotFoundException extends IllegalArgumentException{
    public ItemNotFoundException(String message) {
        super (message);
    }
}
