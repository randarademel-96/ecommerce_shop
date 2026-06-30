package lk.ecommerce.shop.repository;

import lk.ecommerce.shop.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
