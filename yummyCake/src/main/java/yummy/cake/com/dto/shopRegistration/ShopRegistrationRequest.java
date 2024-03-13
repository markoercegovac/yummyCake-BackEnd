package yummy.cake.com.dto.shopRegistration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ShopRegistrationRequest {
    private String name;
    private String city;
    private String country;
    private String zip;
    private String address;
    private String province;
    private String additionalAddress;
    private List<String> images;
}
