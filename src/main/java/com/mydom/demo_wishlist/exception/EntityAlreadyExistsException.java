package com.mydom.demo_wishlist.exception;

/*
* se asociará al HTTP status code 422 (unprocessable entity). Usaremos esa excepción
*  en el caso de un usuario que ya tiene un e-mail registrado intente registrarse de nuevo.
*/
public class EntityAlreadyExistsException extends Exception {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
