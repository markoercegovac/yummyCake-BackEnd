package yummy.cake.com.bom;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String postalCode;

    @Column
    @Nullable
    private String province;

    @Column
    private String address;

    @Column
    private String additionalAddress;

    @OneToOne(mappedBy = "address")
    private Shop shop;
}
