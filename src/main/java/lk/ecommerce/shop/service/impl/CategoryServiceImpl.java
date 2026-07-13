package lk.ecommerce.shop.service.impl;

import lk.ecommerce.shop.controller.request.CategoryRequest;
import lk.ecommerce.shop.model.Category;
import lk.ecommerce.shop.repository.CategoryRepository;
import lk.ecommerce.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Category findById(Long id) {

        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category Id does not exist"));
    }

    @Override
    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

    @Override
    public void update(Long id, CategoryRequest categoryRequest) {

        Category existingCategory = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category Id does not exist"));

        existingCategory.setName(categoryRequest.getName());
        existingCategory.setDescription(categoryRequest.getDescription());

        categoryRepository.save(existingCategory);
    }

    @Override
    public void delete(Long id) {

        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category id does not exist"));

        categoryRepository.delete(category);
    }
}
