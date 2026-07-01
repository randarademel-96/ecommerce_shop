package lk.ecommerce.shop.repository;

import lk.ecommerce.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<User, Long> {
}
