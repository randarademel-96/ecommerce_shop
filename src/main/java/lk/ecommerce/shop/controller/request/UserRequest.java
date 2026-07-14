package lk.ecommerce.shop.controller.request;

import lk.ecommerce.shop.model.Gender;
import lk.ecommerce.shop.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private String name;
    private Gender gender;
    private Integer phone;
    private String address;
    private UserRole userRole;
}
