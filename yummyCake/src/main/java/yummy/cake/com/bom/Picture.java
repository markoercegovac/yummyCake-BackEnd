package yummy.cake.com.bom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String path;
}
