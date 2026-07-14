package lk.ecommerce.shop.controller;

import jakarta.validation.Valid;
import lk.ecommerce.shop.controller.request.UserRequest;
import lk.ecommerce.shop.controller.response.UserResponse;
import lk.ecommerce.shop.model.User;
import lk.ecommerce.shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(headers = "x-api-version=v1")
    public ResponseEntity<Void> create(@Valid @RequestBody UserRequest userRequest){
        userService.create(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(headers = "x-api-version=v1")
    public ResponseEntity<List<UserResponse>> findAll(){

        List<User> users = userService.findAll();

        List<UserResponse> userResponses = new ArrayList<>();

        for(User user: users){

            UserResponse response = UserResponse.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .address(user.getAddress())
                    .gender(user.getGender())
                    .phone(user.getPhoneNo())
                    .userRole(user.getUserRole())
                    .build();
            userResponses.add(response);
        }

        return ResponseEntity.ok(userResponses);
    }

    @GetMapping(value = "/{user-id}", headers = "x-api-version=v1")
    public ResponseEntity<UserResponse> getById(@PathVariable("user-id")Long id){

        User user = userService.findByid(id);

        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .address(user.getAddress())
                .phone(user.getPhoneNo())
                .gender(user.getGender())
                .userRole(user.getUserRole())
                .build();

        return ResponseEntity.ok(userResponse);

    }
}
