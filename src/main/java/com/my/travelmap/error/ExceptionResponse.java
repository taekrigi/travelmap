package com.my.travelmap.error;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
class ExceptionResponse {

    private int status;

    private String statusText;

    private String localizedErrorMessage;

    private String errorDescription;

    private List<String> data;

    ExceptionResponse(String localizedErrorMessage, String errorDescription, HttpStatus status) {
        this.status = status.value();
        this.statusText = status.getReasonPhrase();
        this.localizedErrorMessage = localizedErrorMessage;
        this.errorDescription = errorDescription;
    }

    void setErrors(List<String> data) {
        this.data = data;
    }
}