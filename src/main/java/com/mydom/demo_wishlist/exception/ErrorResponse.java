package com.mydom.demo_wishlist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/*
* modelo de respuesta cuando una de esas excepciones fuesen activadas
* */

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String status;
    private String message;
    private String details;
}
