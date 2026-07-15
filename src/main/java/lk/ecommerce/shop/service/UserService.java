package lk.ecommerce.shop.service;

import lk.ecommerce.shop.controller.request.UserRequest;
import lk.ecommerce.shop.model.User;

import java.util.List;

public interface UserService {

    void create(UserRequest userRequest);

    List<User> findAll();

    User findById(Long id);

    void update(Long id, UserRequest userRequest);

    void delete(Long id);
}
