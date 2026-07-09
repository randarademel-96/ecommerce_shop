package lk.ecommerce.shop.service;

import lk.ecommerce.shop.controller.request.BrandRequest;
import lk.ecommerce.shop.model.Brand;

public interface BrandService {

    void create(BrandRequest brandRequest);

    Brand findById(Long id);
}
