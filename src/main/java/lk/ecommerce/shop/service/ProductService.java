package lk.ecommerce.shop.service;

import lk.ecommerce.shop.controller.request.ProductRequest;
import lk.ecommerce.shop.model.Product;

import java.util.List;

public interface ProductService {

    void create(ProductRequest productRequest);

    List<Product> getAll();

    Product getById(Long id);
}
