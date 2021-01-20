package com.bulis.temp.backend.helper;

public class Response {

    private final boolean successful;
    private final Object data;

    public Response(boolean successful, Object data) {
        this.successful = successful;
        this.data = data;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public Object getData() {
        return data;
    }

}
