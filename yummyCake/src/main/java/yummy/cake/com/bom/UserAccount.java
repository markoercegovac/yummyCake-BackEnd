package yummy.cake.com.bom;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class UserAccount {

    private static final String TABLE_NAME = "accounts_roles";
    private static final String JOIN_COLUMN_USER = "user_account_id";
    private static final String JOIN_COLUMN_ROLE = "role_id";
    private static final String REFER_COLUMN_NAME = "id";

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
    private boolean isNonBanned;


    @ManyToMany
    @JoinTable(name = TABLE_NAME,
            joinColumns = @JoinColumn(name = JOIN_COLUMN_USER, referencedColumnName = REFER_COLUMN_NAME),
            inverseJoinColumns = @JoinColumn(name = JOIN_COLUMN_ROLE, referencedColumnName = REFER_COLUMN_NAME))
    private Collection<Role> roles;
}
