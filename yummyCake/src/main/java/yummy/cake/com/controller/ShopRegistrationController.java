package yummy.cake.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yummy.cake.com.dto.RegistrationShopRequest;

import static yummy.cake.com.controller.ShopRegistrationController.SHOP_REGISTRATION;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = SHOP_REGISTRATION, produces = "application/json")
public class ShopRegistrationController {
    public final static String SHOP_REGISTRATION = "/api/registration/shop";

    @PostMapping
    public void shopRegistration(@RequestBody RegistrationShopRequest request){
        System.out.println(request);
    }
}
