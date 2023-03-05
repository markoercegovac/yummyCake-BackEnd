package yummy.cake.com.service.registration.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yummy.cake.com.bom.RegistrationRequest;
import yummy.cake.com.bom.Role;
import yummy.cake.com.bom.UserAccount;
import yummy.cake.com.dto.NotificationDto;
import yummy.cake.com.dto.RegistrationRequestDto;
import yummy.cake.com.enums.RoleEnum;
import yummy.cake.com.repository.RegistrationRequestRepository;
import yummy.cake.com.repository.UserAccountRepository;
import yummy.cake.com.service.notification.CustomerNotificationService;

import static yummy.cake.com.enums.RoleEnum.ROLE_CUSTOMER;

@Service
@RequiredArgsConstructor
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    private final RegistrationRequestRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final CustomerNotificationService customerNotificationService;

    @Override
    public void save(RegistrationRequestDto request) {
        RegistrationRequest registration = new RegistrationRequest();
        registration.setType(ROLE_CUSTOMER.value);
        registration.setUsername(request.getEmail());
        registration.setPassword(passwordEncoder.encode(request.getPassword()));
        registration.setFirstName(request.getFirstName());
        registration.setLastName(request.getLastName());

        RegistrationRequest saved = repository.save(registration);

        NotificationDto notification = create(saved);
        customerNotificationService.notifyCustomer(notification);
    }

    private NotificationDto create(RegistrationRequest saved){
        NotificationDto notification = new NotificationDto();
        notification.setEmail(saved.getUsername());
        notification.setFirstName(saved.getFirstName());
        notification.setLastName(saved.getLastName());
        notification.setType(saved.getType());
        notification.setId(saved.getId().toString());
        return notification;
    }
}
