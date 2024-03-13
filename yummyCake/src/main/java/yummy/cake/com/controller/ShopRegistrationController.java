package yummy.cake.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yummy.cake.com.dto.shopRegistration.ShopRegistrationRequest;
import yummy.cake.com.service.registration.shop.ShopRegistrationService;

import static yummy.cake.com.controller.ShopRegistrationController.SHOP_REGISTRATION;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = SHOP_REGISTRATION, produces = "application/json")
public class ShopRegistrationController {
    public final static String SHOP_REGISTRATION = "/api/registration/shop";

    private final ShopRegistrationService service;
    @PostMapping
    public void shopRegistration(@RequestBody ShopRegistrationRequest request){
        service.register(request);
    }
}
