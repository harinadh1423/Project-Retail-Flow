package com.project.retailproject.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "purchaseOrder")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseOrderId;

    private Long supplierId;


    private Date orderDate;
    private Date expectedDeliveryDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public Long getPoId() {
        return purchaseOrderId;
    }

    public void setPoId(Long poId) {
        this.purchaseOrderId = poId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public PurchaseOrder() {
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "purchaseOrderId=" + purchaseOrderId +
                ", supplierId=" + supplierId +
                ", orderDate=" + orderDate +
                ", expectedDeliveryDate=" + expectedDeliveryDate +
                ", status='" + status + '\'' +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrder that = (PurchaseOrder) o;
        return Objects.equals(purchaseOrderId, that.purchaseOrderId) && Objects.equals(supplierId, that.supplierId) && Objects.equals(orderDate, that.orderDate) && Objects.equals(expectedDeliveryDate, that.expectedDeliveryDate) && Objects.equals(status, that.status) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseOrderId, supplierId, orderDate, expectedDeliveryDate, status, product);
    }
}
