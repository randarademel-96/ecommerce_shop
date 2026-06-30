package lk.ecommerce.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private LocalDateTime dateAndTime;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

}
