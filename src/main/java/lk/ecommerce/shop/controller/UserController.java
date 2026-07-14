package lk.ecommerce.shop.controller;

import jakarta.validation.Valid;
import lk.ecommerce.shop.controller.request.UserRequest;
import lk.ecommerce.shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
