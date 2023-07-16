package com.RestaurentManagement.demoRestaurentManagemen.Model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInInput {

    @Email
    private String email;
    private String password;
}
