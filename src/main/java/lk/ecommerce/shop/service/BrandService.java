package lk.ecommerce.shop.service;

import lk.ecommerce.shop.controller.request.BrandRequest;
import lk.ecommerce.shop.controller.response.BrandResponse;
import lk.ecommerce.shop.model.Brand;

import java.util.List;

public interface BrandService {

    void create(BrandRequest brandRequest);

    Brand findById(Long id);

    List<Brand> findAll();

    void update(Long id, BrandRequest brandRequest);

    void delete(Long id);
}
