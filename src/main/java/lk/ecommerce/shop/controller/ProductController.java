package lk.ecommerce.shop.controller;

import lk.ecommerce.shop.controller.request.ProductRequest;
import lk.ecommerce.shop.controller.response.ProductResponse;
import lk.ecommerce.shop.model.Product;
import lk.ecommerce.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping(headers = "x-api-version=v1")
    public ResponseEntity<Void> create(@RequestBody ProductRequest productRequest){

        productService.create(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(headers = "x-api-version=v1")
    public ResponseEntity<List<ProductResponse>> getAll(){

        List<Product> products = productService.getAll();

        List<ProductResponse> productResponses = new ArrayList<>();

        for(Product product: products){

            ProductResponse response = ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .brandId(product.getBrand().getId())
                    .brandName(product.getBrand().getName())
                    .categoryId(product.getCategory().getId())
                    .categoryName(product.getCategory().getName())
                    .build();
            productResponses.add(response);
        }
        return ResponseEntity.ok(productResponses);
    }



}
