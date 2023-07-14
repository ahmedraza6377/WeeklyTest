package com.UniversityEventManagment.UniversityEventManagment.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jdk.jfr.Enabled;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {
    @Id
    private Long StuId;
    @NotBlank
    @NotNull
    @Pattern(regexp="^[A-Z][a-zA-Z]*$")
    private String fName;

    private String lName;

    @Min(value = 18)
    @Max(value = 25)
    private int age;
    @Enumerated(EnumType.STRING)
    private Dep dep;

}
