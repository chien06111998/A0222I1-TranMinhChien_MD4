package com.example.demo.exception;

public class CustomerException extends Exception {
    public CustomerException(){};
    public CustomerException(String s){
        super(s);
    }
}
