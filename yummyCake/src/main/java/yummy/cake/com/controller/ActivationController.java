package yummy.cake.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yummy.cake.com.service.activation.customer.ActivationAccountService;

import java.util.UUID;

import static yummy.cake.com.controller.ActivationController.HOME_URL;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = HOME_URL, produces = "application/json")
public class ActivationController {
    public final static String CUSTOMER = "/customer/{id}";
    public final static String OWNER = "/owner/{id}";
    public final static String HOME_URL = "/api/activation";



    private final ActivationAccountService activationAccountService;

    @PostMapping(CUSTOMER)
    public void activateCustomer(@PathVariable UUID id) {
        activationAccountService.activate(id);
    }

    @PostMapping(OWNER)
    public void activateOwner(@PathVariable UUID id) {
        activationAccountService.activate(id);
    }
}
