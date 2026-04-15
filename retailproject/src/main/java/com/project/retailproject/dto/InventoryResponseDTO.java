package com.project.retailproject.dto;

import com.project.retailproject.model.Inventory;

public class InventoryResponseDTO {

    private Inventory inventory;
    private String message;
    private int statusCode;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
