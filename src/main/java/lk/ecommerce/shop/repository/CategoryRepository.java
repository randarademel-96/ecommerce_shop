package lk.ecommerce.shop.repository;

import lk.ecommerce.shop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
