package com.project.retailproject.controller;


import com.project.retailproject.dto.ProductResponseDTO;
import com.project.retailproject.model.Product;
import com.project.retailproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductResponseDTO productResponseDTO) {
        Product product = productService.addProduct(productResponseDTO.getProduct());
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProduct(product);
        responseDTO.setMessage("Product added successfully");
        responseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody ProductResponseDTO productResponseDTO) {
        productService.deleteProduct(productResponseDTO.getProduct());
    }


    @PutMapping("/updateProduct")
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductResponseDTO productResponseDTO) {
        Product product = productService.updateProduct(productResponseDTO.getProduct());
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProduct(product);
        responseDTO.setMessage("Product updated successfully");
        responseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(responseDTO);
    }



    @GetMapping("/productById")
    public ResponseEntity<ProductResponseDTO> getProduct(@RequestBody ProductResponseDTO productResponseDTO) {
        Product product = productService.getProduct(productResponseDTO.getProduct().getProductId());
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setProduct(product);
        responseDTO.setMessage("Product retrieved successfully");
        responseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(responseDTO);
    }
}
