package lk.ecommerce.shop.service.impl;

import lk.ecommerce.shop.controller.request.UserRequest;
import lk.ecommerce.shop.model.Brand;
import lk.ecommerce.shop.model.User;
import lk.ecommerce.shop.repository.UserRepository;
import lk.ecommerce.shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Id does not exist"));
    }

    @Override
    public void update(Long id, UserRequest userRequest) {

        User existingUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Id does not exist"));

        existingUser.setName(userRequest.getName());
        existingUser.setAddress(userRequest.getAddress());
        existingUser.setGender(userRequest.getGender());
        existingUser.setPhoneNo(userRequest.getPhone());

        userRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) {

        User existingUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Id does not exist"));

        userRepository.delete(existingUser);
    }
}
