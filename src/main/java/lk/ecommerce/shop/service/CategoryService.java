package lk.ecommerce.shop.service;

import lk.ecommerce.shop.controller.request.CategoryRequest;
import lk.ecommerce.shop.model.Category;

import java.util.List;

public interface CategoryService {

    void create(CategoryRequest categoryRequest);

    Category findById(Long id);

    List<Category> findAll();

    void update(Long id, CategoryRequest categoryRequest);

    void delete(Long id);
}
