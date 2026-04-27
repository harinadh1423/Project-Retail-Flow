package com.project.retailproject.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalogId;

    @ManyToOne
    @JoinColumn(name = "productId")
    @JsonBackReference
    private Product product;


    private Date effectiveDate;

    private Date expiryDate;

    private String status;



    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Catalog() {
        super();
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", product=" + product +
                ", effectiveDate=" + effectiveDate +
                ", expiryDate=" + expiryDate +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(catalogId, catalog.catalogId) && Objects.equals(product, catalog.product) && Objects.equals(effectiveDate, catalog.effectiveDate) && Objects.equals(expiryDate, catalog.expiryDate) && Objects.equals(status, catalog.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogId, product, effectiveDate, expiryDate, status);
    }
}
