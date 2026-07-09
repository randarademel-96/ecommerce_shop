package lk.ecommerce.shop.controller;

import jakarta.validation.Valid;
import lk.ecommerce.shop.controller.request.BrandRequest;
import lk.ecommerce.shop.controller.response.BrandResponse;
import lk.ecommerce.shop.model.Brand;
import lk.ecommerce.shop.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping(value = "/brands", headers = "x-api-version=v1")
    public ResponseEntity<Void> create(@Valid @RequestBody BrandRequest brandRequest){
        brandService.create(brandRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "brands/{brand-id}", headers = "x-api-version=v1")
    public ResponseEntity<BrandResponse> findById(@PathVariable("brand-id")Long id){
        Brand brand = brandService.findById(id);

        BrandResponse brandResponse = BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .build();
        return ResponseEntity.ok(brandResponse);

    }
}
