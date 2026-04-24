package com.project.retailproject.controller;


import com.project.retailproject.dto.ProductDTO;
import com.project.retailproject.dto.ProductResponseDTO;
import com.project.retailproject.model.Product;
import com.project.retailproject.model.Sale;
import com.project.retailproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().body("Product deleted successfully.");
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



    @GetMapping("/fetch/{productId}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable int productId ) {
        Product product = productService.getProduct(productId);
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setProduct(product);
        dto.setStatusCode(200);
        dto.setMessage("Found product with ID: " + productId);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/fetchAllPagination")
    public ResponseEntity<Page<Product>> getAllSalesWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Product> productsPage = productService.getAllPagesWithPagination(page, size);
        return ResponseEntity.ok(productsPage);
    }
}
