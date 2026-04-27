package com.project.retailproject.service;

import com.project.retailproject.db.ProductRepository;
import com.project.retailproject.db.PurchaseOrderRepository;
import com.project.retailproject.model.Inventory;
import com.project.retailproject.model.Product;
import com.project.retailproject.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private ProductRepository productRepository;
    public PurchaseOrder insertPurchaseOrder(PurchaseOrder purchaseOrder) {


            Integer pid = purchaseOrder.getProduct().getProductId();
        Product existingProduct = productRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + pid));

        purchaseOrder.setProduct(existingProduct);

        // 5. Save the order (now containing the full product details)
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public void deletePurchaseOrder(Long id){
        purchaseOrderRepository.deleteById(id);
    }

    public PurchaseOrder getPurchaseOrderById(Long id){
        return purchaseOrderRepository.findById(id).get();
    }

    public List<PurchaseOrder> getAllPurchaseOrders(){
        return purchaseOrderRepository.findAll();
    }
    public Page<PurchaseOrder> getAllPurchaseOrderWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return purchaseOrderRepository.findAll(pageable);
    }
}
