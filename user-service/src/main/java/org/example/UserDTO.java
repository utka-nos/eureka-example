package org.example;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String login;

    private String serviceUrl;

}
