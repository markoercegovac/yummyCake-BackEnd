package yummy.cake.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yummy.cake.com.dto.RegistrationRequestDto;
import yummy.cake.com.service.registration.customer.CustomerRegistrationService;

import static yummy.cake.com.controller.RegistrationController.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = HOME_URL, produces = "application/json")
public class RegistrationController {
    public final static String HOME_URL = "/api/registration";
    public final static String CUSTOMER = "/customer";

    private final CustomerRegistrationService customerRegistrationService;

    @PostMapping(CUSTOMER)
    public void registerCustomer(@RequestBody RegistrationRequestDto registrationRequestDto){
        customerRegistrationService.save(registrationRequestDto);
    }

}
