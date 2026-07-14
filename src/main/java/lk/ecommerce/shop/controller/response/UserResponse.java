package lk.ecommerce.shop.controller.response;

import lk.ecommerce.shop.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String name;
    private Gender gender;
    private Integer phone;
    private String address;
    private Role userRole;
}
