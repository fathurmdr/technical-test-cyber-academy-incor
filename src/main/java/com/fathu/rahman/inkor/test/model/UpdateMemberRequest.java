package com.fathu.rahman.inkor.test.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberRequest {

    @Size(max = 20)
    private String name;

    @Past
    private LocalDate dateOfBirth;

    @Size(max = 200)
    private String education;

    @Size(max = 40)
    @Email
    private String email;

    @Size(max = 20)
    private String mobileNumber;
}
