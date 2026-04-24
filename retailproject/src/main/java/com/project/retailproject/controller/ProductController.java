package com.project.retailproject.controller;


import com.project.retailproject.dto.ProductDTO;
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
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.addProduct(productDTO.getProduct());
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProduct(product);
        responseDTO.setMessage("Product added successfully");
        responseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping("/deleteProduct/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId) {
        productService.deleteProduct(prodId);
        return ResponseEntity.status(200).body("Product deleted successfully");
    }


    @PutMapping("/updateProduct")
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.updateProduct(productDTO.getProduct());
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProduct(product);
        responseDTO.setMessage("Product updated successfully");
        responseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(responseDTO);
    }



    @GetMapping("/productById")
    public ResponseEntity<ProductResponseDTO> getProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.getProduct(productDTO.getProduct().getProductId());
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setProduct(product);
        responseDTO.setMessage("Product retrieved successfully");
        responseDTO.setStatusCode(200);
        return ResponseEntity.ok().body(responseDTO);
    }
}
