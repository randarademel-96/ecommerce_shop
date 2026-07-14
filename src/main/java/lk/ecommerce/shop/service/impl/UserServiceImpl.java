package lk.ecommerce.shop.service.impl;

import lk.ecommerce.shop.controller.request.UserRequest;
import lk.ecommerce.shop.model.User;
import lk.ecommerce.shop.repository.UserRepository;
import lk.ecommerce.shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(UserRequest userRequest) {
        User user = new User();

        user.setName(userRequest.getName());
        user.setGender(userRequest.getGender());
        user.setAddress(userRequest.getAddress());
        user.setPhoneNo(userRequest.getPhone());
        user.setUserRole(userRequest.getUserRole());

        userRepository.save(user);
    }
}
