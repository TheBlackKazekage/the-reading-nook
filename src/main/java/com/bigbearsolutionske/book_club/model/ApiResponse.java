package com.bigbearsolutionske.book_club.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponse {
    @JsonProperty(value = "success")
    private boolean success;

    @JsonProperty(value = "data")
    private Object data;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "errors")
    private List<StackTraceElement> errors;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(boolean success, Object data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(boolean success, String message, List<StackTraceElement> errors) {
        this.success = success;
        this.message = message;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<StackTraceElement> getErrors() {
        return errors;
    }

    public void setErrors(List<StackTraceElement> errors) {
        this.errors = errors;
    }
}
