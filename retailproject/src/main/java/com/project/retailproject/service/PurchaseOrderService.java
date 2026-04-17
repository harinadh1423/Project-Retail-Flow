package com.project.retailproject.service;

import com.project.retailproject.db.PurchaseOrderRepository;
import com.project.retailproject.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrder insertPurchaseOrder(PurchaseOrder purchaseOrder){
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

}
