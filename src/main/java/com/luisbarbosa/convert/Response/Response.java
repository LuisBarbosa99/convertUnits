package com.luisbarbosa.convert.Response;

public class Response {
    private String user_type;
    private Float multiplication_factor;

    public Response(String user_type, Float multiplication_factor) {
        this.user_type = user_type;
        this.multiplication_factor = multiplication_factor;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Float getMultiplication_factor() {
        return multiplication_factor;
    }

    public void setMultiplication_factor(Float multiplication_factor) {
        this.multiplication_factor = multiplication_factor;
    }
}
