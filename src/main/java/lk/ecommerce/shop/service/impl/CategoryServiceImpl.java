package lk.ecommerce.shop.service.impl;

import lk.ecommerce.shop.controller.request.CategoryRequest;
import lk.ecommerce.shop.model.Category;
import lk.ecommerce.shop.repository.CategoryRepository;
import lk.ecommerce.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void create(CategoryRequest categoryRequest) {

        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

        categoryRepository.save(category);


    }
}
