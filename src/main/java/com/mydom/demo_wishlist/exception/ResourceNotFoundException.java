package com.mydom.demo_wishlist.exception;
/*
* Otra excepción que debemos considerar es aquélla para el caso
*  de un recurso no encontrado. Ese caso será abordado cuando el
* usuario intente, por ejemplo, actualizar o leer una entidad que no exista.
* */
public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
