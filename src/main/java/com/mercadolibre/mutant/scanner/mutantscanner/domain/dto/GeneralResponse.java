package com.mercadolibre.mutant.scanner.mutantscanner.domain.dto;

public class GeneralResponse {
    private String message;

    public GeneralResponse() {
    }

    public GeneralResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
