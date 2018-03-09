package com.andryspo.domain.dto;

public class ErrorMessageDto {

    private String error;

    public ErrorMessageDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
