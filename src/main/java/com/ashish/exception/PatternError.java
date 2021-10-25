package com.ashish.exception;

import java.util.List;

public class PatternError<K, V> {
    private K code;
    private V message;

    public PatternError() {
    }

    public K getCode() {
        return code;
    }

    public void setCode(K code) {
        this.code = code;
    }

    public V getMessage() {
        return message;
    }

    public void setMessage(V message) {
        this.message = message;
    }

    public PatternError(K code, V message) {
        this.code = code;
        this.message = message;
    }

}
