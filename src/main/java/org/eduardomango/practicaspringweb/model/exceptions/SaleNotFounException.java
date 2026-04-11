package org.eduardomango.practicaspringweb.model.exceptions;

import java.util.NoSuchElementException;

public class SaleNotFounException extends NoSuchElementException {
    public SaleNotFounException(String message) {
        super(message);
    }

    public SaleNotFounException(){};
}
