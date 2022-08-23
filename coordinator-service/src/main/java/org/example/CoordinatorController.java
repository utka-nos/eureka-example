package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordinatorController {

    @Autowired
    private UserServiceClient userServiceClient;

    @GetMapping("/user/{id}")
    public UserDTO getUserById(
            @PathVariable Long id
    ){
        UserDTO userById = userServiceClient.getUserById(id);

        return userById;
    }

}
