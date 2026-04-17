package com.project.retailproject.service;

import com.project.retailproject.db.SaleRepository;
import com.project.retailproject.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    public Sale insertSale(Sale sale){
        return saleRepository.save(sale);
    }

    public Sale updateSale(Sale sale){
        return saleRepository.save(sale);
    }

    public void deleteSale(Long id){
        saleRepository.deleteById(id);
    }

    public Sale getSaleById(Long id){
        return saleRepository.findById(id).get();
    }

    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }
}
