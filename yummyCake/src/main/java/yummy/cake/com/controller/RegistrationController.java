package yummy.cake.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yummy.cake.com.bom.RegistrationRequest;
import yummy.cake.com.dto.RegistrationRequestDto;
import yummy.cake.com.service.registration.customer.CustomerRegistrationService;
import yummy.cake.com.service.registration.owner.OwnerRegistrationService;

import static yummy.cake.com.controller.RegistrationController.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = HOME_URL, produces = "application/json")
public class RegistrationController {
    public final static String HOME_URL = "/api/registration";
    public final static String CUSTOMER = "/customer";

    public final static String OWNER = "/owner";

    private final CustomerRegistrationService customerRegistrationService;
    private final OwnerRegistrationService ownerRegistrationService;

    @PostMapping(CUSTOMER)
    public void registerCustomer(@RequestBody RegistrationRequestDto request){
        customerRegistrationService.save(request);
    }

    @PostMapping(OWNER)
    public void registerOwner(@RequestBody RegistrationRequestDto request) {
        ownerRegistrationService.save(request);
    }

}
