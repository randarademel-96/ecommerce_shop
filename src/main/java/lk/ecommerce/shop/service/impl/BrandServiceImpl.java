package lk.ecommerce.shop.service.impl;

import lk.ecommerce.shop.controller.request.BrandRequest;
import lk.ecommerce.shop.controller.response.BrandResponse;
import lk.ecommerce.shop.model.Brand;
import lk.ecommerce.shop.repository.BrandRepository;
import lk.ecommerce.shop.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public void create(BrandRequest brandRequest) {

        Brand brand = new Brand();
        brand.setName(brandRequest.getName());
        brand.setDescription(brandRequest.getDescription());

        brandRepository.save(brand);

    }

    @Override
    public Brand findById(Long id) {

        return brandRepository.findById(id).orElseThrow(()-> new RuntimeException("Brand Id does not exist"));

    }

    @Override
    public List<Brand> findAll() {

        return brandRepository.findAll();
    }
}
