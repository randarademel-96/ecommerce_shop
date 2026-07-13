package lk.ecommerce.shop.service.impl;

import lk.ecommerce.shop.controller.request.ProductRequest;
import lk.ecommerce.shop.model.Brand;
import lk.ecommerce.shop.model.Category;
import lk.ecommerce.shop.model.Product;
import lk.ecommerce.shop.repository.BrandRepository;
import lk.ecommerce.shop.repository.CategoryRepository;
import lk.ecommerce.shop.repository.ProductRepository;
import lk.ecommerce.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Override
    public void create(ProductRequest productRequest) {

        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(()-> new RuntimeException("Category id does not exist "));
        Brand brand = brandRepository.findById(productRequest.getBrandId()).orElseThrow(()-> new RuntimeException("Brand id doe not exist"));
        Product product = new Product();

        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCategory(category);
        product.setBrand(brand);

        productRepository.save(product);
    }
}
