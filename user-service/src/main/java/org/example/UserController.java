package org.example;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User userById = userRepo.findUserById(id);

        UserDTO userToSend = modelMapper.map(userById, UserDTO.class);

        userToSend.setServiceUrl(serverPort);

        return userToSend;
    }

    @PostMapping("user")
    public UserDTO addNewUser(
            @RequestBody UserDTO userDTO
    ) {
        User userToSave = modelMapper.map(userDTO, User.class);
        User savedUser = userRepo.save(userToSave);

        UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);
        savedUserDTO.setServiceUrl(serverPort);

        return savedUserDTO;
    }

}
