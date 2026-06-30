package lk.ecommerce.shop.repository;

import lk.ecommerce.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrialRepository extends JpaRepository<Product, Long> {
}
