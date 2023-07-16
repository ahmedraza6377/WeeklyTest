package com.RestaurentManagement.demoRestaurentManagemen.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpOutput {
    private boolean signUpStatus;
    private String signUpStatusMessage;
}
