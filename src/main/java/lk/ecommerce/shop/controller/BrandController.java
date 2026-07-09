package lk.ecommerce.shop.controller;

import jakarta.validation.Valid;
import lk.ecommerce.shop.controller.request.BrandRequest;
import lk.ecommerce.shop.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping(value = "/brands", headers = "x-api-version=v1")
    public ResponseEntity<Void> create(@Valid @RequestBody BrandRequest brandRequest){
        brandService.create(brandRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
