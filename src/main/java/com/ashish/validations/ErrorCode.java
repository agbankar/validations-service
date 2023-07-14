package com.ashish.validations;

import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

public enum ErrorCode {
    ERR001("Invalid userId", "userId must be alphanumeric, maximum 5 characters.", false, "^[0-9A-Za-z]{1,5}$", HttpStatus.ACCEPTED),
    ERR002("Invalid name", "Name must be alphanumeric, maximum 10 characters.", false, "^[0-9A-Za-z]{1,10}$", HttpStatus.ACCEPTED);

    private String userMessage;
    private String errorDescription;
    private HttpStatus httpStatus;
    private Pattern pattern;
    private boolean nullable = true;

    private ErrorCode(String userMessage, String errorDescription) {
        this.userMessage = userMessage;
        this.errorDescription = errorDescription;
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    private ErrorCode(String userMessage, String errorDescription, HttpStatus httpStatus) {
        this.userMessage = userMessage;
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
    }

    private ErrorCode(String userMessage, String errorDescription,
                      boolean nullable, String pattern, HttpStatus httpStatus) {
        this.userMessage = userMessage;
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
        this.nullable = nullable;
        this.pattern = Pattern.compile(pattern);
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public boolean isNullable() {
        return nullable;
    }

    private static String idMessage(String propertyName) {
        return String.format("", propertyName);
    }
}
