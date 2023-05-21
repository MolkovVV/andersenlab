package com.andersenlab.people.models.request;
import lombok.Data;

@Data
public class UserLoginModelRequest {
    private String email;
    private String password;
}
