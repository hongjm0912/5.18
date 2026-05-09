package com.example._18.exception;
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) { super(message); }
}