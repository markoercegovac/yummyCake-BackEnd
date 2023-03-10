package yummy.cake.com.bom;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;


}
