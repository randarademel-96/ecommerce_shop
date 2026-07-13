package lk.ecommerce.shop.controller;

import lk.ecommerce.shop.controller.request.ProductRequest;
import lk.ecommerce.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping(headers = "x-api-version=v1")
    public ResponseEntity<Void> create(@RequestBody ProductRequest productRequest){

        productService.create(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
