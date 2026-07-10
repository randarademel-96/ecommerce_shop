package lk.ecommerce.shop.service;

import lk.ecommerce.shop.controller.request.CategoryRequest;
import lk.ecommerce.shop.model.Category;

public interface CategoryService {

    void create(CategoryRequest categoryRequest);

    Category findById(Long id);
}
