package com.project.retailproject.dto;

import com.project.retailproject.model.Invoice;

public class InvoiceResponseDTO {

    private Invoice invoice;
    private int statusCode;
    private String message;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
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
