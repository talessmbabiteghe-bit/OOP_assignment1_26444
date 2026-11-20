package com.auca.interfaces;
import com.auca.exceptions.ValidationException;
public interface Validatable {
    void validate() throws ValidationException;
    void printDetails();
    String getSummary();
}
