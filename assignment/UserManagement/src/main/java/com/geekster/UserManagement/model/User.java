package com.geekster.UserManagement.model;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {


    private Integer userId;
     private String name;
    private String userName;



    private String userContact;


    private String address;
}
