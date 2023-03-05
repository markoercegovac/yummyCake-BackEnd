package yummy.cake.com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
