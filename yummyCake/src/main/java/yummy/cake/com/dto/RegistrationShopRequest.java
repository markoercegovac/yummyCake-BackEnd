package yummy.cake.com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RegistrationShopRequest {
    private String name;
    private String city;
    private String country;
    private String zip;
    private String address;
    private String province;
    private String additionalAddress;
    private List<String> images;
}
