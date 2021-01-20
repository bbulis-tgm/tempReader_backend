package com.bulis.temp.backend.helper;

public class ResponseError {

    private final String type;
    private final String text;

    public ResponseError(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
