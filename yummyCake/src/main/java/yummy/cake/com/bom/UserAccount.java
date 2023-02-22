package yummy.cake.com.bom;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean isActive;

    @Column
    private boolean isBanned;
}
