package yummy.cake.com.service.activation.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yummy.cake.com.bom.RegistrationRequest;
import yummy.cake.com.bom.Role;
import yummy.cake.com.bom.UserAccount;
import yummy.cake.com.repository.RegistrationRequestRepository;
import yummy.cake.com.repository.RoleRepository;
import yummy.cake.com.repository.UserAccountRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActivationAccountServiceImpl implements ActivationAccountService {

    private final RegistrationRequestRepository requestRepository;
    private final UserAccountRepository userAccountRepository;
    private final RoleRepository roleRepository;

    @Override
    public void activate(UUID id) {
        RegistrationRequest registrationRequest = requestRepository.findById(id).get();

        UserAccount account = new UserAccount();
        account.setUsername(registrationRequest.getUsername());
        account.setPassword(registrationRequest.getPassword());
        account.setActive(true);
        account.setNonBanned(true);

        Role role = roleRepository.findByName(registrationRequest.getType());
        account.setRoles(List.of(role));
        userAccountRepository.save(account);
        requestRepository.delete(registrationRequest);
    }
}
