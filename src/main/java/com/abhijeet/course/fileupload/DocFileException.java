package com.abhijeet.course.fileupload;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DocFileException  {

    public static class FileStorageException extends RuntimeException {

        public FileStorageException(String message) {
            super(message);
        }

        public FileStorageException(String message, Throwable cause) {
            super(message, cause);
        }

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class MyFileNotFoundException extends RuntimeException {
        public MyFileNotFoundException(String message) {
            super(message);
        }

        public MyFileNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}


