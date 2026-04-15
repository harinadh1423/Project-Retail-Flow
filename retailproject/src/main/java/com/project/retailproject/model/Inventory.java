package com.project.retailproject.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private Long locationId;
    private Integer quantityOnHand;
    private Integer safetyStock;
    private String status;


    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public Integer getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(Integer safetyStock) {
        this.safetyStock = safetyStock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Inventory() {
        super();
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", product=" + product +
                ", locationId=" + locationId +
                ", quantityOnHand=" + quantityOnHand +
                ", safetyStock=" + safetyStock +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(inventoryId, inventory.inventoryId) && Objects.equals(product, inventory.product) && Objects.equals(locationId, inventory.locationId) && Objects.equals(quantityOnHand, inventory.quantityOnHand) && Objects.equals(safetyStock, inventory.safetyStock) && Objects.equals(status, inventory.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, product, locationId, quantityOnHand, safetyStock, status);
    }
}
