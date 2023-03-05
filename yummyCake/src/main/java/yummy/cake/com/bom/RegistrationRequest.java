package yummy.cake.com.bom;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class RegistrationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String type;

}
