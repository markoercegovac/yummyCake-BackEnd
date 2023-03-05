package yummy.cake.com.service.registration.client;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yummy.cake.com.bom.UserAccount;
import yummy.cake.com.dto.RegistrationRequest;
import yummy.cake.com.repository.UserAccountRepository;

@Service
@RequiredArgsConstructor
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(RegistrationRequest request) {
        UserAccount account = new UserAccount();
        account.setUsername(request.getEmail());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setActive(false);
        account.setNonBanned(true);

        repository.save(account);
    }
}
