package com.elcarim.cloudstoragedemo.exception;

public class StorageServiceException extends RuntimeException {
    public StorageServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
