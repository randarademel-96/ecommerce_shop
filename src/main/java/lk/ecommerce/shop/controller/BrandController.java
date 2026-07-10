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

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping(value = "/brands", headers = "x-api-version=v1")
    public ResponseEntity<Void> create(@Valid @RequestBody BrandRequest brandRequest){
        brandService.create(brandRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/brands/{brand-id}", headers = "x-api-version=v1")
    public ResponseEntity<BrandResponse> findById(@PathVariable("brand-id")Long id){
        Brand brand = brandService.findById(id);

        BrandResponse brandResponse = BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .build();
        return ResponseEntity.ok(brandResponse);

    }

    @GetMapping(value = "/brands", headers = "x-api-version")
    public ResponseEntity<List<BrandResponse>> findAll(){

        List<Brand> brands = brandService.findAll();

        List<BrandResponse> brandResponses = new ArrayList<>();

        for(Brand brand: brands){

            BrandResponse response = BrandResponse.builder()
                    .id(brand.getId())
                    .name(brand.getName())
                    .description(brand.getDescription())
                    .build();
            brandResponses.add(response);
        }
        return ResponseEntity.ok(brandResponses);
    }

    @PutMapping(value = "/brands/{brand-id}", headers = "x-api-version")
    public ResponseEntity<Void> update(@PathVariable("brand-id")Long id, @Valid @RequestBody BrandRequest brandRequest){

        brandService.update(id, brandRequest);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/brands/{brand-id}", headers = "x-api-version=v1")
    public ResponseEntity<Void> delete(@PathVariable("brand-id")Long id){

        brandService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
