package lk.ecommerce.shop.repository;

import lk.ecommerce.shop.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
