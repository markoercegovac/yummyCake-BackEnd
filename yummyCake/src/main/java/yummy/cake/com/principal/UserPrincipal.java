package yummy.cake.com.principal;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import yummy.cake.com.bom.UserAccount;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    private static final String prefix = "ROLE_";
    private UserAccount account;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.account.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(prefix + r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.account.getPassword();
    }

    @Override
    public String getUsername() {
        return this.account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.account.isNonBanned();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.account.isActive();
    }
}
