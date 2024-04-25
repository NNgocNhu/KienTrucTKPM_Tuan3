package com.iuh.authservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "userInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String roles;
}
