package com.project.retailproject.dto;

import com.project.retailproject.model.Sale;

public class SaleResponseDTO {

    private Sale sale;
    private int statusCode;
    private String message;

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
