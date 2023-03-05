package yummy.cake.com.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class NotificationDto {
    private String email;
    private String firstName;
    private String lastName;
    private String id;
    private String type;
}
