package com.project.retailproject.dto;

import com.project.retailproject.model.AuditLog;
import com.project.retailproject.model.Catalog;

public class CatalogResponseDTO {

    private String message;
    private Catalog catalog;
    private int StatusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }
}
