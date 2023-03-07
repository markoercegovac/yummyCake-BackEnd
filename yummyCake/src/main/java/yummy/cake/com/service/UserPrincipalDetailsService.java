package yummy.cake.com.service;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yummy.cake.com.bom.UserAccount;
import yummy.cake.com.principal.UserPrincipal;
import yummy.cake.com.repository.UserAccountRepository;

import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

@Service
@RequiredArgsConstructor
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserAccountRepository repository;

    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount account = this.repository.findByUsername(username);
        return new UserPrincipal(account);
    }
}
