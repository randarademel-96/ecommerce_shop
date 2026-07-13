package lk.ecommerce.shop.controller;

import jakarta.validation.Valid;
import lk.ecommerce.shop.controller.request.CategoryRequest;
import lk.ecommerce.shop.controller.response.CategoryResponse;
import lk.ecommerce.shop.model.Category;
import lk.ecommerce.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(value = "/categories", headers = "x-api-version=v1")
    public ResponseEntity<Void> create(@Valid @RequestBody CategoryRequest categoryRequest){

        categoryService.create(categoryRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping(value = ".categories/{category-id}", headers = "x-api-version=v1")
    public ResponseEntity<CategoryResponse> getById(@PathVariable("category-id")Long id){

        Category category = categoryService.findById(id);

        CategoryResponse categoryResponse = CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();

        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping(value = "/categories", headers = "x-api-version=v1")
    public ResponseEntity<List<CategoryResponse>> findAll(){

        List<Category> categories = categoryService.findAll();

        List<CategoryResponse> responses = new ArrayList<>();

        for(Category category: categories){

            CategoryResponse categoryResponse = CategoryResponse.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .description(category.getDescription())
                    .build();
            responses.add(categoryResponse);

        }

        return ResponseEntity.ok(responses);
    }

    @PutMapping(value = "/categories/{category-id}", headers = "x-api-version=v1")
    public ResponseEntity<Void> update(@PathVariable("category-id")Long id,@Valid @RequestBody CategoryRequest categoryRequest){

        categoryService.update(id, categoryRequest);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping(value = "categories/{category-id}", headers = "x-api-version=v1")
    public ResponseEntity<Void> delete(@PathVariable("category-id")Long id){

        categoryService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
