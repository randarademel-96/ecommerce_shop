package lk.ecommerce.shop.repository;

import lk.ecommerce.shop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
