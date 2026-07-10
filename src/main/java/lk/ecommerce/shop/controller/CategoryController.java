package lk.ecommerce.shop.controller;

import jakarta.validation.Valid;
import lk.ecommerce.shop.controller.request.CategoryRequest;
import lk.ecommerce.shop.model.Category;
import lk.ecommerce.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(value = "/categories", headers = "x-api-version=v1")
    public ResponseEntity<Void> create(@Valid @RequestBody CategoryRequest categoryRequest){

        categoryService.create(categoryRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
